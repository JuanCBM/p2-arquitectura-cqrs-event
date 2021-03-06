package es.urjc.code.pr2.domain.service.command.impl;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;
import es.urjc.code.pr2.domain.event.ProductCreated;
import es.urjc.code.pr2.domain.event.ProductDeleted;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.domain.service.command.ProductCommandService;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import java.util.UUID;
import org.modelmapper.ModelMapper;

public class ProductCommandServiceImpl implements ProductCommandService {

  private final ProductRepository repository;
  private final ProductProcess productProcess;
  ModelMapper mapper = new ModelMapper();

  public ProductCommandServiceImpl(ProductRepository repository,
      ProductProcess productProcess) {
    this.repository = repository;
    this.productProcess = productProcess;
  }

  @Override
  public FullProductDTO createProduct(ProductDTO productDTO) {
    ProductCreated productCreated = mapper.map(productDTO, ProductCreated.class);
    productCreated.setId(UUID.randomUUID());
    productProcess.save(productCreated);

    return mapper.map(productCreated, FullProductDTO.class);
  }

  @Override
  public FullProductDTO deleteProduct(UUID id) {
    ProductDeleted productDeleted = new ProductDeleted(id);
    FullProductDTO fullProductDTO = repository.findById(id);
    productProcess.delete(productDeleted);

    return fullProductDTO;
  }

}
