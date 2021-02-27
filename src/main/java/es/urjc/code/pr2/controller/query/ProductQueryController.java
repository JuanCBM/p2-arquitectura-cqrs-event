package es.urjc.code.pr2.controller.query;

import es.urjc.code.pr2.controller.dto.ProductResponseDTO;
import es.urjc.code.pr2.domain.service.query.ProductQueryService;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

  private final ProductQueryService productQueryService;
  private final ModelMapper mapper = new ModelMapper();

  public ProductQueryController(ProductQueryService productQueryService) {
    this.productQueryService = productQueryService;
  }

  @GetMapping
  public Collection<ProductResponseDTO> getProducts() {
    return Arrays.asList(mapper.map(productQueryService.getProducts(), ProductResponseDTO[].class));
  }

  @GetMapping("/{id}")
  public ProductResponseDTO getProduct(@PathVariable Long id) {
    return mapper.map(productQueryService.getProduct(id), ProductResponseDTO.class);
  }

}
