package es.urjc.code.ejem1.domain.service.query;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.ProductDTO;
import java.util.Collection;

public interface ProductQueryService {
	public Collection<FullProductDTO> getProducts();
	public FullProductDTO getProduct(Long id);
}
