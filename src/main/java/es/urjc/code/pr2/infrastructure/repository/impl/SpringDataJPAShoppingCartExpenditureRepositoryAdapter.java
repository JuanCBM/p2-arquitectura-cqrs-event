package es.urjc.code.pr2.infrastructure.repository.impl;

import es.urjc.code.pr2.domain.dto.ShoppingCartExpenditureDTO;
import es.urjc.code.pr2.domain.repository.ShoppingCartExpenditureRepository;
import es.urjc.code.pr2.infrastructure.ShoppingCartExpenditureEntity;
import es.urjc.code.pr2.infrastructure.application.event.ShoppingCartClosed;
import es.urjc.code.pr2.infrastructure.repository.SpringDataJPAShoppingCartExpenditureRepository;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJPAShoppingCartExpenditureRepositoryAdapter implements
    ShoppingCartExpenditureRepository {

  private final ModelMapper mapper = new ModelMapper();
  private final SpringDataJPAShoppingCartExpenditureRepository springDataJPAShoppingCartExpenditureRepository;

  public SpringDataJPAShoppingCartExpenditureRepositoryAdapter(
      SpringDataJPAShoppingCartExpenditureRepository repository) {
    this.springDataJPAShoppingCartExpenditureRepository = repository;
  }

  public void save(ShoppingCartClosed shoppingCartClosed) {
    ShoppingCartExpenditureEntity shoppingCartExpenditureEntity = mapper
        .map(shoppingCartClosed, ShoppingCartExpenditureEntity.class);
    springDataJPAShoppingCartExpenditureRepository.save(shoppingCartExpenditureEntity);
  }

  @Override
  public Collection<ShoppingCartExpenditureDTO> findAll() {
    return Arrays.asList(mapper.map(springDataJPAShoppingCartExpenditureRepository.findAll(),
        ShoppingCartExpenditureDTO[].class));
  }
}
