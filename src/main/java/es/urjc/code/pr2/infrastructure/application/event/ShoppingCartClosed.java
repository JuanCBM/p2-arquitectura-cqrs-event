package es.urjc.code.pr2.infrastructure.application.event;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartClosed {

  private Long cartId;
  private Double expenditure;
  private Instant timestamp = Instant.now();

  public ShoppingCartClosed(Long cartId, Double expenditure) {
    this.cartId = cartId;
    this.expenditure = expenditure;
  }

}
