package es.urjc.code.pr2;

import es.urjc.code.pr2.domain.Product;
import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.repository.ProductRepository;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

  ModelMapper mapper = new ModelMapper();
  @Autowired
  private ProductRepository productRepository;

  @Override
  public void run(String... args) {

    Product product1 = new Product(
        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
        49.99);

    Product product2 = new Product(
        "PANTALÓN RUNNING RUN WARM",
        "Hemos diseñado este pantalón para los hombres que corren con tiempo frío.",
        19.0);

    Product product3 = new Product(
        "ZAPATILLAS RUNNING",
        "Nuestros equipos de diseño han desarrollado esta zapatilla de running ligera y con amortiguación para correr hasta 10 km a la semana.",
        12.48);

    product1.setId(UUID.randomUUID());
    product2.setId(UUID.randomUUID());
    product3.setId(UUID.randomUUID());

    productRepository.save(mapper.map(product1, FullProductDTO.class));
    productRepository.save(mapper.map(product2, FullProductDTO.class));
    productRepository.save(mapper.map(product3, FullProductDTO.class));
  }

}
