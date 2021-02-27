package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.service.ProductService;
import es.urjc.code.ejem1.domain.service.ShoppingCartExpenditureService;
import es.urjc.code.ejem1.domain.service.ShoppingCartService;
import es.urjc.code.ejem1.domain.service.impl.ProductServiceImpl;
import es.urjc.code.ejem1.domain.service.impl.ShoppingCartExpenditureServiceImpl;
import es.urjc.code.ejem1.domain.service.impl.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.infrastructure.repository.impl.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.repository.impl.SpringDataJPAShoppingCartExpenditureRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.repository.impl.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;
import es.urjc.code.ejem1.service.source.ShoppingCartProcess;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
					ShoppingCartProcess shoppingCartProcess) {
		return new ShoppingCartServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationServiceImpl(),
						shoppingCartProcess);
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

	@Bean
	public ShoppingCartExpenditureService shoppingCartExpenditureService(
			SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter) {
		return new ShoppingCartExpenditureServiceImpl(
				springDataJPAShoppingCartExpenditureRepositoryAdapter);
	}

}
