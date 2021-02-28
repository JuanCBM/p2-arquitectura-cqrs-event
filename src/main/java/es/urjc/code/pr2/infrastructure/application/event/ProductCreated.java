package es.urjc.code.pr2.infrastructure.application.event;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreated extends Event {

  private UUID id;
  private String name;
  private String description;
  private double price;

}
