package es.urjc.code.pr2.domain.repository;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import java.util.Collection;

public interface ProductRepository {

  Collection<FullProductDTO> finAll();

  FullProductDTO findById(Long id);

  FullProductDTO save(FullProductDTO product);

  void deleteById(Long id);
}
