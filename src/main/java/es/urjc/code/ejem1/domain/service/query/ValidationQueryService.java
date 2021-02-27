package es.urjc.code.ejem1.domain.service.query;

import es.urjc.code.ejem1.domain.ShoppingCartItem;
import java.util.List;

public interface ValidationQueryService {

  boolean validate(List<ShoppingCartItem> items);

}
