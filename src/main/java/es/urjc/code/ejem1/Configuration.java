package es.urjc.code.ejem1;

import es.urjc.code.ejem1.domain.service.command.ProductCommandService;
import es.urjc.code.ejem1.domain.service.ShoppingCartExpenditureService;
import es.urjc.code.ejem1.domain.service.ShoppingCartService;
import es.urjc.code.ejem1.domain.service.command.impl.ProductCommandServiceImpl;
import es.urjc.code.ejem1.domain.service.impl.ShoppingCartExpenditureServiceImpl;
import es.urjc.code.ejem1.domain.service.impl.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.domain.service.query.ProductQueryService;
import es.urjc.code.ejem1.domain.service.query.impl.ProductQueryServiceImpl;
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
	public ProductQueryService productQueryService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductQueryServiceImpl(repositoryAdapter);
	}

	@Bean
	public ProductCommandService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductCommandServiceImpl(repositoryAdapter);
	}

	@Bean
	public ShoppingCartExpenditureService shoppingCartExpenditureService(
			SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter) {
		return new ShoppingCartExpenditureServiceImpl(
				springDataJPAShoppingCartExpenditureRepositoryAdapter);
	}

}
