package es.urjc.code.pr2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import es.urjc.code.pr2.domain.Product;
import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartItemDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.domain.repository.ShoppingCartRepository;
import es.urjc.code.pr2.domain.service.command.impl.ProductCommandServiceImpl;
import es.urjc.code.pr2.domain.service.command.impl.ShoppingCartCommandServiceImpl;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import es.urjc.code.pr2.infrastructure.application.source.ShoppingCartProcess;
import es.urjc.code.pr2.service.ValidationQueryServiceImpl;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartCommandService {

  private ProductRepository productRepository;
  private ProductCommandServiceImpl productService;
  private ShoppingCartProcess shoppingCartProcess;
  private ProductProcess productProcess;

  private ShoppingCartRepository shoppingCartRepository;
  private ShoppingCartCommandServiceImpl shoppingCartService;

  private final ModelMapper mapper = new ModelMapper();

  private static FullShoppingCartDTO createdShoppingCart;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    shoppingCartRepository = mock(ShoppingCartRepository.class);
    shoppingCartProcess = mock(ShoppingCartProcess.class);
    productProcess = mock(ProductProcess.class);

    productService = new ProductCommandServiceImpl(productRepository, productProcess);
    shoppingCartService = new ShoppingCartCommandServiceImpl(
        shoppingCartRepository,
        productRepository,
        new ValidationQueryServiceImpl(),
        shoppingCartProcess);
  }

  @Test
  @Order(1)
  void shoppingCartCanBeAdded() {
    createdShoppingCart = shoppingCartService.createShoppingCart();
    verify(shoppingCartRepository).save(createdShoppingCart);
  }

  @Test
  @Order(2)
  void productCanBeAddedToShoppingCart() {
    Product product = new Product(
        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
        49.99);
    ProductDTO productDTO = mapper.map(product, ProductDTO.class);

    FullProductDTO fullProductDTO = productService.createProduct(productDTO);
    verify(productRepository).save(fullProductDTO);

    int items = Math.abs(new Random().nextInt());

    createdShoppingCart = shoppingCartService
        .addProduct(fullProductDTO, createdShoppingCart, items);
    FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);

    assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
    assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * productDTO.getPrice());
  }

  @Test
  @Order(3)
  void shoppingCartCanBeDeleted() {
    shoppingCartService.deleteShoppingCart(createdShoppingCart.getId());
    verify(shoppingCartRepository).deleteById(createdShoppingCart.getId());
  }
}
