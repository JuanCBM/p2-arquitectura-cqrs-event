package es.urjc.code.pr2.domain.service.command.impl;

import es.urjc.code.pr2.domain.Product;
import es.urjc.code.pr2.domain.ShoppingCart;
import es.urjc.code.pr2.domain.ShoppingCartItem;
import es.urjc.code.pr2.domain.ShoppingCartStatus;
import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.dto.ShoppingCartDTO;
import es.urjc.code.pr2.domain.event.ShoppingCartClosed;
import es.urjc.code.pr2.domain.event.ShoppingCartDeleted;
import es.urjc.code.pr2.domain.event.ShoppingCartSaved;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.domain.repository.ShoppingCartRepository;
import es.urjc.code.pr2.domain.service.command.ShoppingCartCommandService;
import es.urjc.code.pr2.domain.service.query.ValidationQueryService;
import es.urjc.code.pr2.infrastructure.application.source.ShoppingCartProcess;
import java.util.UUID;
import org.modelmapper.ModelMapper;

public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final ProductRepository productRepository;
  private final ValidationQueryService validationQueryService;
  private final ShoppingCartProcess shoppingCartProcess;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartCommandServiceImpl(ShoppingCartRepository shoppingCartRepository,
      ProductRepository productRepository,
      ValidationQueryService validationQueryService,
      ShoppingCartProcess shoppingCartProcess) {
    this.shoppingCartRepository = shoppingCartRepository;
    this.productRepository = productRepository;
    this.validationQueryService = validationQueryService;
    this.shoppingCartProcess = shoppingCartProcess;
  }

  private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
    ShoppingCartSaved shoppingCartSaved = mapper.map(fullShoppingCartDTO, ShoppingCartSaved.class);
    shoppingCartProcess.save(shoppingCartSaved);

    return fullShoppingCartDTO;
  }

  @Override
  public FullShoppingCartDTO createShoppingCart() {
    FullShoppingCartDTO fullShoppingCartDTO = mapper
        .map(new ShoppingCart(), FullShoppingCartDTO.class);
    fullShoppingCartDTO.setId(UUID.randomUUID());
    return saveShoppingCart(fullShoppingCartDTO);
  }

  @Override
  public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

    ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
    ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

    if (updateShoppingCart.getStatus() != null &&
        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
      shoppingCart.setValidationService(validationQueryService);
      shoppingCart.validate();

      ShoppingCartClosed event = new ShoppingCartClosed(id, shoppingCart.getPrice());
      shoppingCartProcess.close(event);
    }

    FullShoppingCartDTO newShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

    return saveShoppingCart(newShoppingCartDTO);
  }

  @Override
  public FullShoppingCartDTO deleteShoppingCart(UUID id) {
    ShoppingCartDeleted shoppingCartDeleted = new ShoppingCartDeleted(id);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
    shoppingCartProcess.delete(shoppingCartDeleted);

    return fullShoppingCartDTO;
  }

  @Override
  public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int quantity) {
    FullProductDTO fullProductDTO = productRepository.findById(idProduct);
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

    return addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
  }

  public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO,
      FullShoppingCartDTO fullShoppingCartDTO,
      int quantity) {
    ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
    shoppingCart.removeItem(fullProductDTO.getId());

    ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
        mapper.map(fullProductDTO, Product.class),
        quantity);
    shoppingCartItem.setId(UUID.randomUUID());
    shoppingCart.addItem(shoppingCartItem);

    FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

    return saveShoppingCart(newFullProductDTO);
  }

  @Override
  public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

    ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
    shoppingCart.removeItem(idProduct);

    FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

    return saveShoppingCart(newFullProductDTO);
  }
}
