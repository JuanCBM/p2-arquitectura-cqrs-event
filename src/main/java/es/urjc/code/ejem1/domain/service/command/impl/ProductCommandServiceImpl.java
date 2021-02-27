package es.urjc.code.ejem1.domain.service.command.impl;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.service.command.ProductCommandService;
import org.modelmapper.ModelMapper;

public class ProductCommandServiceImpl implements ProductCommandService {

  private final ProductRepository repository;
  ModelMapper mapper = new ModelMapper();

  public ProductCommandServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public FullProductDTO createProduct(ProductDTO productDTO) {
    FullProductDTO fullProductDTO = mapper.map(productDTO, FullProductDTO.class);
    FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

    return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
  }

  @Override
  public FullProductDTO deleteProduct(Long id) {
    FullProductDTO product = repository.findById(id);
    repository.deleteById(id);

    return product;
  }

}
