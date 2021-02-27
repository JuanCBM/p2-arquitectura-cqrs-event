package es.urjc.code.pr2.infrastructure.repository;

import es.urjc.code.pr2.infrastructure.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAProductRepository extends JpaRepository<ProductEntity, Long> {

}
