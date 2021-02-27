package es.urjc.code.ejem1.domain.service.impl;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartExpenditureRepository;
import es.urjc.code.ejem1.domain.service.ShoppingCartExpenditureService;
import java.util.Collection;

public class ShoppingCartExpenditureServiceImpl implements ShoppingCartExpenditureService {

	private ShoppingCartExpenditureRepository shoppingCartExpenditureRepository;

	public ShoppingCartExpenditureServiceImpl(ShoppingCartExpenditureRepository shoppingCartExpenditureRepository) {
		this.shoppingCartExpenditureRepository = shoppingCartExpenditureRepository;
	}

	@Override
	public Collection<ShoppingCartExpenditureDTO> getShoppingCartExpenditure() {
		return shoppingCartExpenditureRepository.findAll();
	}
}
