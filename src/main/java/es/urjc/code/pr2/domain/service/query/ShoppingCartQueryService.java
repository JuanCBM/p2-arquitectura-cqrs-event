package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import java.util.UUID;

public interface ShoppingCartQueryService {

  FullShoppingCartDTO getShoppingCart(UUID id);
}
