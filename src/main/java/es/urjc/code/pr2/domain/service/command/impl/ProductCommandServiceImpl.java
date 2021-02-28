package es.urjc.code.pr2.domain.service.command.impl;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.domain.service.command.ProductCommandService;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import java.util.UUID;
import org.modelmapper.ModelMapper;

public class ProductCommandServiceImpl implements ProductCommandService {

  private final ProductRepository repository;
  ModelMapper mapper = new ModelMapper();
  private final ProductProcess productProcess;

  public ProductCommandServiceImpl(ProductRepository repository,
      ProductProcess productProcess) {
    this.repository = repository;
    this.productProcess = productProcess;
  }

  @Override
  public FullProductDTO createProduct(ProductDTO productDTO) {
    FullProductDTO fullProductDTO = mapper.map(productDTO, FullProductDTO.class);

    fullProductDTO.setId(UUID.randomUUID());
    productProcess.create(fullProductDTO);

    //FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

    return fullProductDTO;
    // return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
  }

  @Override
  public FullProductDTO deleteProduct(Long id) {
    FullProductDTO product = repository.findById(id);
    repository.deleteById(id);

    return product;
  }

}
