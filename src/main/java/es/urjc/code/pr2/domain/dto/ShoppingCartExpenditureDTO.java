package es.urjc.code.pr2.domain.dto;

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
