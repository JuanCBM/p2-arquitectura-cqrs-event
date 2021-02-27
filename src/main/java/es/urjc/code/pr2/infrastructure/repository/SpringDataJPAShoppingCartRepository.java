package es.urjc.code.pr2.infrastructure.repository;

import es.urjc.code.pr2.infrastructure.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartRepository extends
    JpaRepository<ShoppingCartEntity, Long> {

}
