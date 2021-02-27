package es.urjc.code.ejem1.controller.dto;

import es.urjc.code.ejem1.domain.Product;

public class ShoppingCartItemResponseDTO {

  private Long id;
  private Product product;
  private int quantity;
  private double totalPrice;

  public ShoppingCartItemResponseDTO() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
