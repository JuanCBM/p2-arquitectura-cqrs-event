package es.urjc.code.pr2.infrastructure;

import es.urjc.code.pr2.domain.ShoppingCartStatus;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCartEntity {

  @Id
  private UUID id;
  private ShoppingCartStatus status;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ShoppingCartItemEntity> items;

  public ShoppingCartEntity() {
    super();
  }

  public ShoppingCartEntity(UUID id, List<ShoppingCartItemEntity> items) {
    super();
    this.id = id;
    this.items = items;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ShoppingCartStatus getStatus() {
    return status;
  }

  public void setStatus(ShoppingCartStatus status) {
    this.status = status;
  }

  public List<ShoppingCartItemEntity> getItems() {
    return items;
  }

  public void setItems(List<ShoppingCartItemEntity> items) {
    this.items = items;
  }

  public double getPrice() {
    double price = 0;

    if (this.items != null) {
      for (ShoppingCartItemEntity item : this.items) {
        price += item.getTotalPrice();
      }
    }

    return price;
  }
}
