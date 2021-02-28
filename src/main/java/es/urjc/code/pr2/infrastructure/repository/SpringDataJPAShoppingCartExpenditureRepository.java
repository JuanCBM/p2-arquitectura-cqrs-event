package es.urjc.code.pr2.infrastructure.repository;

import es.urjc.code.pr2.infrastructure.ShoppingCartExpenditureEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartExpenditureRepository extends
    JpaRepository<ShoppingCartExpenditureEntity, UUID> {

}
