package es.urjc.code.pr2.infrastructure.application.source;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.infrastructure.application.event.ProductCreated;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ProductProcess {

  private final ApplicationEventPublisher applicationEventPublisher;
  private final ModelMapper mapper = new ModelMapper();

  ProductProcess(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Transactional
  public void create(FullProductDTO fullProductDTO) {
    ProductCreated event = mapper.map(fullProductDTO, ProductCreated.class);

    applicationEventPublisher.publishEvent(event);
  }
}
