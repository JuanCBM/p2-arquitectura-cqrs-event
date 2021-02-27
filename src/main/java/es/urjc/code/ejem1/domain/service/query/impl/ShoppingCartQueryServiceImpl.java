package es.urjc.code.ejem1.domain.service.query.impl;

import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.domain.service.query.ShoppingCartQueryService;
import org.modelmapper.ModelMapper;

public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartQueryServiceImpl(ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }

  @Override
  public FullShoppingCartDTO getShoppingCart(Long id) {
    return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
  }

}
