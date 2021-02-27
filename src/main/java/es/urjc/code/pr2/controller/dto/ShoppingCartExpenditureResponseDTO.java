package es.urjc.code.pr2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartExpenditureResponseDTO {

  private Long cartId;
  private Double expenditure;

}
