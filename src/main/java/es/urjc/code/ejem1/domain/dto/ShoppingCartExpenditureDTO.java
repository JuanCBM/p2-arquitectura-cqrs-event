package es.urjc.code.ejem1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartExpenditureDTO {

  private Long cartId;
  private Double expenditure;

}
