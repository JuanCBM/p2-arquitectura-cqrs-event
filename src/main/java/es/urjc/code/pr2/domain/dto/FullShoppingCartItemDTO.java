package es.urjc.code.pr2.domain.dto;

import es.urjc.code.pr2.domain.Product;
import java.util.UUID;

public class FullShoppingCartItemDTO {

  private UUID id;
  private Product product;
  private int quantity;
  private double totalPrice;

  public FullShoppingCartItemDTO() {
    super();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
