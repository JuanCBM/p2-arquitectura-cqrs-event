package es.urjc.code.pr2.service;

import es.urjc.code.pr2.domain.ShoppingCartItem;
import es.urjc.code.pr2.domain.service.query.ValidationQueryService;
import java.util.List;
import java.util.Random;

public class ValidationQueryServiceImpl implements ValidationQueryService {

  @Override
  public boolean validate(List<ShoppingCartItem> items) {
    Random rnd = new Random();

    return rnd.nextBoolean();
  }

}
