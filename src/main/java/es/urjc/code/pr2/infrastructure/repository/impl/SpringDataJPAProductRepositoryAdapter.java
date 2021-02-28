package es.urjc.code.pr2.infrastructure.repository.impl;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.infrastructure.ProductEntity;
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

  public SpringDataJPAProductRepositoryAdapter(SpringDataJPAProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<FullProductDTO> finAll() {
    return Arrays.asList(mapper.map(repository.findAll(), FullProductDTO[].class));
  }

  @Override
  public FullProductDTO findById(UUID id) {
    return mapper.map(repository.findById(id).orElseThrow(ProductNotFoundException::new),
        FullProductDTO.class);
  }

  @Override
  public FullProductDTO save(FullProductDTO product) {
    ProductEntity productEntity = mapper.map(product, ProductEntity.class);
    repository.save(productEntity);

    return mapper.map(productEntity, FullProductDTO.class);
  }

  @Override
  public void deleteById(UUID id) {
    repository.deleteById(id);
  }

}
