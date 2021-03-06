package es.urjc.code.pr2;

import es.urjc.code.pr2.domain.service.command.ProductCommandService;
import es.urjc.code.pr2.domain.service.command.ShoppingCartCommandService;
import es.urjc.code.pr2.domain.service.command.impl.ProductCommandServiceImpl;
import es.urjc.code.pr2.domain.service.command.impl.ShoppingCartCommandServiceImpl;
import es.urjc.code.pr2.domain.service.query.ProductQueryService;
import es.urjc.code.pr2.domain.service.query.ShoppingCartExpenditureQueryService;
import es.urjc.code.pr2.domain.service.query.ShoppingCartQueryService;
import es.urjc.code.pr2.domain.service.query.impl.ProductQueryServiceImpl;
import es.urjc.code.pr2.domain.service.query.impl.ShoppingCartExpenditureQueryServiceImpl;
import es.urjc.code.pr2.domain.service.query.impl.ShoppingCartQueryServiceImpl;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import es.urjc.code.pr2.infrastructure.application.source.ShoppingCartProcess;
import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAShoppingCartExpenditureRepositoryAdapter;
import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.pr2.service.ValidationQueryServiceImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  public ShoppingCartCommandService shoppingCartService(
      SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
      SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
      ShoppingCartProcess shoppingCartProcess) {
    return new ShoppingCartCommandServiceImpl(
        shoppingCartRepositoryAdapter,
        productRepositoryAdapter,
        new ValidationQueryServiceImpl(),
        shoppingCartProcess);
  }

  @Bean
  public ShoppingCartQueryService shoppingCartQueryService(
      SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter) {
    return new ShoppingCartQueryServiceImpl(shoppingCartRepositoryAdapter);
  }

  @Bean
  public ProductQueryService productQueryService(
      SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
    return new ProductQueryServiceImpl(repositoryAdapter);
  }

  @Bean
  public ProductCommandService productService(
      SpringDataJPAProductRepositoryAdapter repositoryAdapter,
      ProductProcess productProcess) {
    return new ProductCommandServiceImpl(repositoryAdapter, productProcess);
  }

  @Bean
  public ShoppingCartExpenditureQueryService shoppingCartExpenditureService(
      SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter) {
    return new ShoppingCartExpenditureQueryServiceImpl(
        springDataJPAShoppingCartExpenditureRepositoryAdapter);
  }

}
