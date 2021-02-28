package es.urjc.code.pr2.domain.event;

import es.urjc.code.pr2.domain.ShoppingCartStatus;
import es.urjc.code.pr2.domain.dto.FullShoppingCartItemDTO;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoppingCartSaved {

  private UUID cartId;
  private ShoppingCartStatus cartStatus;
  private List<FullShoppingCartItemDTO> cartItems;
  private double cartPrice;

  public ShoppingCartSaved(UUID cartId, ShoppingCartStatus cartStatus,
      List<FullShoppingCartItemDTO> cartItems, double cartPrice) {
    this.cartId = cartId;
    this.cartStatus = cartStatus;
    this.cartItems = cartItems;
    this.cartPrice = cartPrice;
  }

}
