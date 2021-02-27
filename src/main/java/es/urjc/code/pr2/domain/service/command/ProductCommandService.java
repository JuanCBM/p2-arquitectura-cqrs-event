package es.urjc.code.pr2.domain.service.command;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;

public interface ProductCommandService {

  FullProductDTO createProduct(ProductDTO productDTO);

  FullProductDTO deleteProduct(Long id);
}
