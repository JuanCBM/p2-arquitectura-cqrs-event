package es.urjc.code.pr2.domain.service.query;

import es.urjc.code.pr2.domain.ShoppingCartItem;
import java.util.List;

public interface ValidationQueryService {

  boolean validate(List<ShoppingCartItem> items);

}
