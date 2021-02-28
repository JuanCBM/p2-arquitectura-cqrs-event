package es.urjc.code.pr2.infrastructure.sink;

import es.urjc.code.pr2.infrastructure.application.event.ShoppingCartClosed;
import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAShoppingCartExpenditureRepositoryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartExpenditureReadModelUpdater {

  private final SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter;

  ShoppingCartExpenditureReadModelUpdater(
      SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter) {
    this.springDataJPAShoppingCartExpenditureRepositoryAdapter = springDataJPAShoppingCartExpenditureRepositoryAdapter;
  }

  @EventListener
  public void addWithdrawalOnCardWithdrawn(ShoppingCartClosed event) {
    springDataJPAShoppingCartExpenditureRepositoryAdapter.save(event);
  }
}
