package es.urjc.code.pr2.infrastructure.application.source;

import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.repository.ShoppingCartRepository;
import es.urjc.code.pr2.infrastructure.application.event.ShoppingCartClosed;
import javax.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartProcess {

  private final ApplicationEventPublisher applicationEventPublisher;
  private final ShoppingCartRepository shoppingCartRepository;

  ShoppingCartProcess(ApplicationEventPublisher applicationEventPublisher,
      ShoppingCartRepository shoppingCartRepository) {
    this.applicationEventPublisher = applicationEventPublisher;
    this.shoppingCartRepository = shoppingCartRepository;
  }

  @Transactional
  public void close(Long id, Double prize) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
    if (fullShoppingCartDTO == null) {
      throw new IllegalStateException("Cannot find card with id " + id);
    }
    ShoppingCartClosed event = new ShoppingCartClosed(id, prize);

    applicationEventPublisher.publishEvent(event);
  }
}
