package es.urjc.code.pr2.domain;

import es.urjc.code.pr2.domain.exception.ShoppingCartDontStockException;
import es.urjc.code.pr2.domain.service.query.ValidationQueryService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {

  private UUID id;
  private ShoppingCartStatus status;
  private List<ShoppingCartItem> items;

  private ValidationQueryService validationQueryService;

  public ShoppingCart() {
    super();

    this.status = ShoppingCartStatus.PENDING;
    this.items = new ArrayList<>();
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

  public List<ShoppingCartItem> getItems() {
    return items;
  }

  public void setItems(List<ShoppingCartItem> items) {
    this.items = items;
  }

  public ValidationQueryService getValidationService() {
    return validationQueryService;
  }

  public void setValidationService(ValidationQueryService validationQueryService) {
    this.validationQueryService = validationQueryService;
  }

  public void addItem(ShoppingCartItem shoppingCartItem) {
    this.items.add(shoppingCartItem);
  }

  public void removeItem(UUID idProduct) {
    this.items.removeIf(item -> item.getProduct().getId().equals(idProduct));
  }

  public double getPrice() {
    double price = 0;

    if (this.items != null) {
      for (ShoppingCartItem item : this.items) {
        price += item.getTotalPrice();
      }
    }

    return price;
  }

  public void validate() {
    if (this.status != ShoppingCartStatus.COMPLETED) {

      if (!validationQueryService.validate(this.items)) {
        throw new ShoppingCartDontStockException("Not enough stock");
      }

      this.status = ShoppingCartStatus.COMPLETED;
    }
  }

}
