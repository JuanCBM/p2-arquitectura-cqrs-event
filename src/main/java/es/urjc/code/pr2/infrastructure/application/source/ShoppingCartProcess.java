package es.urjc.code.pr2.infrastructure.application.source;

import es.urjc.code.pr2.domain.event.ShoppingCartClosed;
import es.urjc.code.pr2.domain.event.ShoppingCartDeleted;
import es.urjc.code.pr2.domain.event.ShoppingCartSaved;
import javax.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartProcess {

  private final ApplicationEventPublisher applicationEventPublisher;

  ShoppingCartProcess(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Transactional
  public void close(ShoppingCartClosed event) {
    applicationEventPublisher.publishEvent(event);
  }

  public void save(ShoppingCartSaved event) {
    applicationEventPublisher.publishEvent(event);
  }

  public void delete(ShoppingCartDeleted event) {
    applicationEventPublisher.publishEvent(event);
  }
  /*public void close(ShoppingCartClosed event) {
    applicationEventPublisher.publishEvent(event);
  }*/


}
