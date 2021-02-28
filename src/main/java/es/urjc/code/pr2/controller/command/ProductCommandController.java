package es.urjc.code.pr2.controller.command;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.urjc.code.pr2.controller.dto.ProductRequestDTO;
import es.urjc.code.pr2.controller.dto.ProductResponseDTO;
import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.ProductDTO;
import es.urjc.code.pr2.domain.service.command.ProductCommandService;
import java.net.URI;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

  private final ProductCommandService productCommandService;
  private final ModelMapper mapper = new ModelMapper();

  public ProductCommandController(ProductCommandService productCommandService) {
    this.productCommandService = productCommandService;
  }

  @PostMapping
  public ResponseEntity<ProductResponseDTO> createProduct(
      @RequestBody ProductRequestDTO productRequestDTO) {
    ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
    FullProductDTO fullProductDTO = productCommandService.createProduct(productDTO);

    URI location = fromCurrentRequest().path("/{id}")
        .buildAndExpand(fullProductDTO.getId()).toUri();

    return ResponseEntity.created(location).body(
        mapper.map(fullProductDTO, ProductResponseDTO.class));
  }

  @DeleteMapping("/{id}")
  public ProductResponseDTO deleteProduct(@PathVariable UUID id) {
    return mapper.map(productCommandService.deleteProduct(id), ProductResponseDTO.class);
  }

}
