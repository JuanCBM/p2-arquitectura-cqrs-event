package es.urjc.code.ejem1.infrastructure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartId;
  private Double expenditure;

}
