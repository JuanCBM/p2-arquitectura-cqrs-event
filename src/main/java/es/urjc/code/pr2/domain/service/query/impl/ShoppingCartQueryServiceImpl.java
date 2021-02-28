package es.urjc.code.pr2.domain.service.query.impl;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.repository.ShoppingCartRepository;
import es.urjc.code.pr2.domain.service.query.ShoppingCartQueryService;
import java.util.UUID;
import org.modelmapper.ModelMapper;

public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartQueryServiceImpl(ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }

  @Override
  public FullShoppingCartDTO getShoppingCart(UUID id) {
    return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
  }

}
