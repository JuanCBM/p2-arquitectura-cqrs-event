package es.urjc.code.pr2.controller.query;

import es.urjc.code.pr2.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.pr2.domain.service.query.ShoppingCartQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

  private final ShoppingCartQueryService shoppingCartQueryService;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartQueryController(ShoppingCartQueryService shoppingCartQueryService) {
    this.shoppingCartQueryService = shoppingCartQueryService;
  }

  @GetMapping("/{id}")
  public ShoppingCartResponseDTO getShoppingCart(@PathVariable Long id) {
    return mapper.map(shoppingCartQueryService.getShoppingCart(id), ShoppingCartResponseDTO.class);
  }

}
