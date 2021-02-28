package es.urjc.code.pr2.domain.repository;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import java.util.Collection;
import java.util.UUID;

public interface ProductRepository {

  Collection<FullProductDTO> finAll();

  FullProductDTO findById(UUID id);

  FullProductDTO save(FullProductDTO product);

  void deleteById(UUID id);
}
