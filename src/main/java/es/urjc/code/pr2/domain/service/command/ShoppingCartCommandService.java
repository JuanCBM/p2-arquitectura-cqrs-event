package es.urjc.code.pr2.domain.service.command;

import es.urjc.code.pr2.domain.dto.FullProductDTO;
import es.urjc.code.pr2.domain.dto.FullShoppingCartDTO;
import es.urjc.code.pr2.domain.dto.ShoppingCartDTO;
import java.util.UUID;

public interface ShoppingCartCommandService {

  FullShoppingCartDTO createShoppingCart();

  FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

  FullShoppingCartDTO deleteShoppingCart(Long id);

  FullShoppingCartDTO addProduct(Long idShoppingCart, UUID idProduct, int nProducts);

  FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO,
      FullShoppingCartDTO fullShoppingCartDTO,
      int quantity);

  FullShoppingCartDTO deleteProduct(Long idShoppingCart, UUID idProduct);
}
