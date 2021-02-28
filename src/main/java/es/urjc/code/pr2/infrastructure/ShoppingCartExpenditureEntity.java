package es.urjc.code.pr2.infrastructure;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartExpenditureEntity {

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID cartId;
  private Double expenditure;

}
