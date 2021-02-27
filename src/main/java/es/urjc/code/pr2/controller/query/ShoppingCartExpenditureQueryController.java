package es.urjc.code.pr2.controller.query;

import es.urjc.code.pr2.controller.dto.ShoppingCartExpenditureResponseDTO;
import es.urjc.code.pr2.domain.service.query.ShoppingCartExpenditureQueryService;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartexpenditure")
public class ShoppingCartExpenditureQueryController {

  private final ShoppingCartExpenditureQueryService shoppingCartExpenditureQueryService;
  private final ModelMapper mapper = new ModelMapper();

  public ShoppingCartExpenditureQueryController(
      ShoppingCartExpenditureQueryService shoppingCartExpenditureQueryService) {
    this.shoppingCartExpenditureQueryService = shoppingCartExpenditureQueryService;
  }

  @GetMapping({"/", ""})
  public Collection<ShoppingCartExpenditureResponseDTO> getShoppingCarts() {
    return Arrays.asList(mapper
        .map(shoppingCartExpenditureQueryService.getShoppingCartExpenditure(),
            ShoppingCartExpenditureResponseDTO[].class));
  }


}
