package es.urjc.code.ejem1.domain.service.query;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import java.util.Collection;

public interface ShoppingCartExpenditureQueryService {

  Collection<ShoppingCartExpenditureDTO> getShoppingCartExpenditure();
}
