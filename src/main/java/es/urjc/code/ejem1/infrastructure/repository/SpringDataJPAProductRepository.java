package es.urjc.code.ejem1.infrastructure.repository;

import es.urjc.code.ejem1.infrastructure.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAProductRepository extends JpaRepository<ProductEntity, Long> {

}
