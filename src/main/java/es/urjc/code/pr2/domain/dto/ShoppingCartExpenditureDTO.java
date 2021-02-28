package es.urjc.code.pr2.domain.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartExpenditureDTO {

  private UUID cartId;
  private Double expenditure;

}
