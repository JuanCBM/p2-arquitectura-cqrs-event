package es.urjc.code.pr2.infrastructure.sink;

import es.urjc.code.pr2.domain.event.ProductCreated;
import es.urjc.code.pr2.domain.event.ProductDeleted;
import es.urjc.code.pr2.infrastructure.ProductEntity;
import es.urjc.code.pr2.infrastructure.repository.SpringDataJPAProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductReadModelUpdater {

  private final SpringDataJPAProductRepository springDataJPAProductRepository;
  private final ModelMapper mapper = new ModelMapper();

  ProductReadModelUpdater(
      SpringDataJPAProductRepository springDataJPAProductRepository) {
    this.springDataJPAProductRepository = springDataJPAProductRepository;
  }

  @EventListener
  public void saveProduct(ProductCreated event) {
    ProductEntity productEntity = mapper.map(event, ProductEntity.class);
    springDataJPAProductRepository.save(productEntity);
  }

  @EventListener
  public void deleteProduct(ProductDeleted event) {
    springDataJPAProductRepository.deleteById(event.getId());
  }
}
