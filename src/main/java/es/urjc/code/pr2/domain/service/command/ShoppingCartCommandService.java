package es.urjc.code.pr2.domain.service.command;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.dto.ShoppingCartDTO;
import java.util.UUID;

public interface ShoppingCartCommandService {

  FullShoppingCartDTO createShoppingCart();

  FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO);

  FullShoppingCartDTO deleteShoppingCart(UUID id);

  FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int nProducts);

  FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO,
      FullShoppingCartDTO fullShoppingCartDTO,
      int quantity);

  FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
