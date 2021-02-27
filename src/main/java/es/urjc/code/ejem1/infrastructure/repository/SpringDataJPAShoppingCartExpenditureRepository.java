package es.urjc.code.ejem1.infrastructure.repository;

import es.urjc.code.ejem1.infrastructure.ShoppingCartExpenditureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartExpenditureRepository extends
    JpaRepository<ShoppingCartExpenditureEntity, Long> {

}
