package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import java.util.Collection;

public interface ProductQueryService {

  Collection<FullProductDTO> getProducts();

  FullProductDTO getProduct(Long id);
}
