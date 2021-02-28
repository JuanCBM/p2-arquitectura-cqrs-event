package es.urjc.code.pr2.domain.repository;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import java.util.UUID;

public interface ShoppingCartRepository {

  FullShoppingCartDTO findById(UUID id);

  FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

  void deleteById(UUID id);
}
