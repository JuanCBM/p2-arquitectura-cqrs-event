package es.urjc.code.ejem1.domain.service.query.impl;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.service.query.ProductQueryService;
import java.util.Collection;

public class ProductQueryServiceImpl implements ProductQueryService {

	private ProductRepository repository;

	public ProductQueryServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<FullProductDTO> getProducts() {
		return repository.finAll();
	}

	@Override
	public FullProductDTO getProduct(Long id) {
		return repository.findById(id);
	}

}
