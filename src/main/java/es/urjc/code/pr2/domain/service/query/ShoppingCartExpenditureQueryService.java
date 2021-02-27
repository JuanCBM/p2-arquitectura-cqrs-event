package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.dto.ShoppingCartExpenditureDTO;
import java.util.Collection;

public interface ShoppingCartExpenditureQueryService {

  Collection<ShoppingCartExpenditureDTO> getShoppingCartExpenditure();
}
