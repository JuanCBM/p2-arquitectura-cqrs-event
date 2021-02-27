package es.urjc.code.ejem1.domain.service.command;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;

public interface ProductCommandService {

  FullProductDTO createProduct(ProductDTO productDTO);

  FullProductDTO deleteProduct(Long id);
}
