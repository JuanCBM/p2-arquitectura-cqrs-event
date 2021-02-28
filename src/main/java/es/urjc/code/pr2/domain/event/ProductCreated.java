package es.urjc.code.pr2.domain.event;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreated {

  private UUID id;
  private String name;
  private String description;
  private double price;

}
