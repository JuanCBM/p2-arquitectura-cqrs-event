package es.urjc.code.pr2.controller.dto;

import es.urjc.code.pr2.domain.ShoppingCartStatus;

public class ShoppingCartRequestDTO {

  private ShoppingCartStatus status;

  public ShoppingCartRequestDTO() {
    super();
  }

  public ShoppingCartStatus getStatus() {
    return status;
  }

  public void setStatus(ShoppingCartStatus status) {
    this.status = status;
  }

}
