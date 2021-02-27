package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartQueryService {

  FullShoppingCartDTO getShoppingCart(Long id);
}
