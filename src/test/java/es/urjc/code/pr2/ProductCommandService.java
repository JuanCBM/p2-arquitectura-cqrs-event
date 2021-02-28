package es.urjc.code.pr2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import es.urjc.code.pr2.domain.Product;
import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import es.urjc.code.pr2.domain.service.command.impl.ProductCommandServiceImpl;
import es.urjc.code.pr2.infrastructure.application.source.ProductProcess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;

@TestMethodOrder(OrderAnnotation.class)
public class ProductCommandService {

  private static FullProductDTO createdProduct;
  private final ModelMapper mapper = new ModelMapper();
  private ProductRepository productRepository;
  private ProductCommandServiceImpl productService;
  private ProductProcess productProcess;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    productProcess = mock(ProductProcess.class);

    productService = new ProductCommandServiceImpl(productRepository, productProcess);
  }

  @Test
  @Order(1)
  void productCanBeAdded() {
    Product product = new Product(
        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
        49.99);

    ProductDTO productDTO = mapper.map(product, ProductDTO.class);

    createdProduct = productService.createProduct(productDTO);
    verify(productRepository).save(createdProduct);
  }

  @Test
  @Order(2)
  void productCanBeDeleted() {
//    productService.deleteProduct(createdProduct.getId());
//    verify(productRepository).deleteById(createdProduct.getId());
  }
}
