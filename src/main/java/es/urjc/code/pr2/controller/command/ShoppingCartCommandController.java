package es.urjc.code.pr2.controller.command;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.urjc.code.pr2.controller.dto.ShoppingCartRequestDTO;
import es.urjc.code.pr2.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.dto.ShoppingCartDTO;
import es.urjc.code.pr2.domain.service.command.ShoppingCartCommandService;
import java.net.URI;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartCommandController {

  private final ShoppingCartCommandService shoppingService;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartCommandController(ShoppingCartCommandService shoppingService) {
    this.shoppingService = shoppingService;
  }

  @PostMapping("/{idShoppingCart}/product/{idProduct}/quantity/{quantity}")
  public ShoppingCartResponseDTO addProductToShoppingCart(
      @PathVariable Long idShoppingCart,
      @PathVariable Long idProduct,
      @PathVariable int quantity) {

    return mapper.map(shoppingService.addProduct(idShoppingCart, idProduct, quantity),
        ShoppingCartResponseDTO.class);
  }

  @DeleteMapping("/{idShoppingCart}/product/{idProduct}")
  public ShoppingCartResponseDTO deleteProductInShoppingCart(
      @PathVariable Long idShoppingCart,
      @PathVariable Long idProduct) {
    return mapper.map(shoppingService.deleteProduct(idShoppingCart, idProduct),
        ShoppingCartResponseDTO.class);
  }

  @PostMapping
  public ResponseEntity<ShoppingCartResponseDTO> createShoppingCart() {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingService.createShoppingCart();

    URI location = fromCurrentRequest().path("/{id}")
        .buildAndExpand(fullShoppingCartDTO.getId()).toUri();

    return ResponseEntity.created(location).body(
        mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class));
  }

  @PatchMapping("/{id}")
  public ShoppingCartResponseDTO updateShoppingCart(
      @PathVariable Long id,
      @Validated @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
    FullShoppingCartDTO fullShoppingCartDTO = shoppingService.updateShoppingCart(id,
        mapper.map(shoppingCartRequestDTO, ShoppingCartDTO.class));

    return mapper.map(fullShoppingCartDTO, ShoppingCartResponseDTO.class);
  }

  @DeleteMapping("/{id}")
  public ShoppingCartResponseDTO deleteShoppingCart(@PathVariable Long id) {
    return mapper.map(shoppingService.deleteShoppingCart(id), ShoppingCartResponseDTO.class);
  }
}
