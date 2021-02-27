package es.urjc.code.ejem1.domain.service.query.impl;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartExpenditureRepository;
import es.urjc.code.ejem1.domain.service.query.ShoppingCartExpenditureQueryService;
import java.util.Collection;

public class ShoppingCartExpenditureQueryServiceImpl implements
    ShoppingCartExpenditureQueryService {

  private final ShoppingCartExpenditureRepository shoppingCartExpenditureRepository;

  public ShoppingCartExpenditureQueryServiceImpl(
      ShoppingCartExpenditureRepository shoppingCartExpenditureRepository) {
    this.shoppingCartExpenditureRepository = shoppingCartExpenditureRepository;
  }

  @Override
  public Collection<ShoppingCartExpenditureDTO> getShoppingCartExpenditure() {
    return shoppingCartExpenditureRepository.findAll();
  }
}
