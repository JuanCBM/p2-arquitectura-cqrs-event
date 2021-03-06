package es.urjc.code.pr2.controller.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartExpenditureResponseDTO {

  private UUID cartId;
  private Double expenditure;

}
