package es.urjc.code.pr2.domain.repository;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartRepository {

  FullShoppingCartDTO findById(Long id);

  FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

  void deleteById(Long id);
}
