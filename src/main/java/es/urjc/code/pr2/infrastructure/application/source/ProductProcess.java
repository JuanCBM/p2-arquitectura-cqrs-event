package es.urjc.code.pr2.infrastructure.application.source;

import es.urjc.code.pr2.domain.event.ProductCreated;
import es.urjc.code.pr2.domain.event.ProductDeleted;
import javax.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ProductProcess {

  private final ApplicationEventPublisher applicationEventPublisher;

  ProductProcess(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Transactional
  public void save(ProductCreated productCreated) {
    applicationEventPublisher.publishEvent(productCreated);
  }

  @Transactional
  public void delete(ProductDeleted productDeleted) {
    applicationEventPublisher.publishEvent(productDeleted);
  }
}
