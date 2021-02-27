package es.urjc.code.pr2.domain.repository;

import es.urjc.code.pr2.domain.dto.ShoppingCartExpenditureDTO;
import java.util.Collection;

public interface ShoppingCartExpenditureRepository {

  Collection<ShoppingCartExpenditureDTO> findAll();
}
