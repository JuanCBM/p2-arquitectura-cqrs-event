package es.urjc.code.pr2.infrastructure.repository.impl;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.infrastructure.ProductEntity;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import es.urjc.code.pr2.infrastructure.exception.ProductNotFoundException;
import es.urjc.code.pr2.infrastructure.repository.SpringDataJPAProductRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJPAProductRepositoryAdapter implements ProductRepository {

  private final SpringDataJPAProductRepository repository;
  private final ModelMapper mapper = new ModelMapper();
  private final ProductProcess productProcess;

  public SpringDataJPAProductRepositoryAdapter(SpringDataJPAProductRepository repository,
      ProductProcess productProcess) {
    this.repository = repository;
    this.productProcess = productProcess;
  }

  @Override
  public Collection<FullProductDTO> finAll() {
    return Arrays.asList(mapper.map(repository.findAll(), FullProductDTO[].class));
  }

  @Override
  public FullProductDTO findById(Long id) {
    return mapper.map(repository.findById(id).orElseThrow(ProductNotFoundException::new),
        FullProductDTO.class);
  }

  @Override
  public FullProductDTO save(FullProductDTO product) {
    product.setId(UUID.randomUUID());

    ProductEntity productEntity = mapper.map(product, ProductEntity.class);

    productProcess.create(product);

    //repository.save(productEntity);

    return mapper.map(productEntity, FullProductDTO.class);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}
