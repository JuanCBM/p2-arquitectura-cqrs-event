package es.urjc.code.ejem1.domain.repository;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import java.util.Collection;

public interface ShoppingCartExpenditureRepository {

  Collection<ShoppingCartExpenditureDTO> findAll();
}
