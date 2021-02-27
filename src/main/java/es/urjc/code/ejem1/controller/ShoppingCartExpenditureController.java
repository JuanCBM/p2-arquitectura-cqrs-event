package es.urjc.code.ejem1.controller;

import es.urjc.code.ejem1.controller.dto.ProductResponseDTO;
import es.urjc.code.ejem1.controller.dto.ShoppingCartExpenditureResponseDTO;
import es.urjc.code.ejem1.domain.service.ShoppingCartExpenditureService;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartexpenditure")
public class ShoppingCartExpenditureController {

    private ShoppingCartExpenditureService shoppingCartExpenditureService;
    private ModelMapper mapper = new ModelMapper();

    public ShoppingCartExpenditureController(ShoppingCartExpenditureService shoppingCartExpenditureService) {
      this.shoppingCartExpenditureService = shoppingCartExpenditureService;
    }

    @GetMapping({"/",""})
    public Collection<ShoppingCartExpenditureResponseDTO> getShoppingCarts() {
      return Arrays.asList(mapper.map(shoppingCartExpenditureService.getShoppingCartExpenditure(), ShoppingCartExpenditureResponseDTO[].class));
    }


}
