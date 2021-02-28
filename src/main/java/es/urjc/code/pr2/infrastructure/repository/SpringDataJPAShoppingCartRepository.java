package es.urjc.code.pr2.infrastructure.repository;

import es.urjc.code.pr2.infrastructure.ShoppingCartEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartRepository extends
    JpaRepository<ShoppingCartEntity, UUID> {

}
