package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import java.util.Collection;

public interface ShoppingCartExpenditureService {
	public Collection<ShoppingCartExpenditureDTO> getShoppingCartExpenditure();
}
