package es.urjc.code.pr2.domain.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoppingCartClosed extends Event {

  private Long cartId;
  private Double expenditure;

  public ShoppingCartClosed(Long cartId, Double expenditure) {
    this.cartId = cartId;
    this.expenditure = expenditure;
  }

}
