package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import java.util.Collection;
import java.util.UUID;

public interface ProductQueryService {

  Collection<FullProductDTO> getProducts();

  FullProductDTO getProduct(UUID id);
}
