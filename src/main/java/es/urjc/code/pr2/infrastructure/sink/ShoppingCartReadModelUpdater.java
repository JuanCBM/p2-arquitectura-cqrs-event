package es.urjc.code.pr2.infrastructure.sink;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.event.ShoppingCartDeleted;
import es.urjc.code.pr2.domain.event.ShoppingCartSaved;
import es.urjc.code.pr2.infrastructure.repository.impl.SpringDataJPAShoppingCartRepositoryAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartReadModelUpdater {

  private final SpringDataJPAShoppingCartRepositoryAdapter springDataJPAShoppingCartRepositoryAdapter;
  private final ModelMapper mapper = new ModelMapper();

  ShoppingCartReadModelUpdater(
      SpringDataJPAShoppingCartRepositoryAdapter springDataJPAShoppingCartRepositoryAdapter) {
    this.springDataJPAShoppingCartRepositoryAdapter = springDataJPAShoppingCartRepositoryAdapter;
  }

  @EventListener
  public void saveShoppingCart(ShoppingCartSaved event) {
    FullShoppingCartDTO shoppingCartEntity = mapper.map(event, FullShoppingCartDTO.class);
    springDataJPAShoppingCartRepositoryAdapter.save(shoppingCartEntity);
  }

  @EventListener
  public void deleteShoppingCart(ShoppingCartDeleted event) {
    springDataJPAShoppingCartRepositoryAdapter.deleteById(event.getCartId());
  }
}
