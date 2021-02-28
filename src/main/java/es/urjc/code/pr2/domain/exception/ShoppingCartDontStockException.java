package es.urjc.code.pr2.domain.exception;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ShoppingCartDontStockException extends RuntimeException {

  private static final UUID serialVersionUID = UUID.randomUUID();

  public ShoppingCartDontStockException(String message) {
    super(message);
  }
}
