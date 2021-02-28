package es.urjc.code.pr2.domain.event;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoppingCartClosed {

  private UUID cartId;
  private Double expenditure;

  public ShoppingCartClosed(UUID cartId, Double expenditure) {
    this.cartId = cartId;
    this.expenditure = expenditure;
  }

}
