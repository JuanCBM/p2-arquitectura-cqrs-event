package es.urjc.code.pr2.service.sink;

import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAShoppingCartExpenditureRepositoryAdapter;
import es.urjc.code.pr2.service.event.ShoppingCartClosed;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ReadModelUpdater {

  private final SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter;

  ReadModelUpdater(
      SpringDataJPAShoppingCartExpenditureRepositoryAdapter springDataJPAShoppingCartExpenditureRepositoryAdapter) {
    this.springDataJPAShoppingCartExpenditureRepositoryAdapter = springDataJPAShoppingCartExpenditureRepositoryAdapter;
  }

  @EventListener
  public void addWithdrawalOnCardWithdrawn(ShoppingCartClosed event) {
    springDataJPAShoppingCartExpenditureRepositoryAdapter.save(event);
  }
}
