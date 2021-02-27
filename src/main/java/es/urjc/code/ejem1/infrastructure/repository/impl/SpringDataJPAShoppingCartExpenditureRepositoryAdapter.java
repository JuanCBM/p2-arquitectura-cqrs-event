package es.urjc.code.ejem1.infrastructure.repository.impl;

import es.urjc.code.ejem1.domain.dto.ShoppingCartExpenditureDTO;
import es.urjc.code.ejem1.domain.repository.ShoppingCartExpenditureRepository;
import es.urjc.code.ejem1.infrastructure.ShoppingCartExpenditureEntity;
import es.urjc.code.ejem1.infrastructure.repository.SpringDataJPAShoppingCartExpenditureRepository;
import es.urjc.code.ejem1.service.event.ShoppingCartClosed;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJPAShoppingCartExpenditureRepositoryAdapter implements
    ShoppingCartExpenditureRepository {
  private ModelMapper mapper = new ModelMapper();
  private SpringDataJPAShoppingCartExpenditureRepository springDataJPAShoppingCartExpenditureRepository;

  public SpringDataJPAShoppingCartExpenditureRepositoryAdapter(
      SpringDataJPAShoppingCartExpenditureRepository repository) {
    this.springDataJPAShoppingCartExpenditureRepository = repository;
  }

  public void save(ShoppingCartClosed shoppingCartClosed) {
    ShoppingCartExpenditureEntity shoppingCartExpenditureEntity = mapper.map(shoppingCartClosed, ShoppingCartExpenditureEntity.class);
    springDataJPAShoppingCartExpenditureRepository.save(shoppingCartExpenditureEntity);
  }

  @Override
  public Collection<ShoppingCartExpenditureDTO> findAll() {
    return Arrays.asList(mapper.map(springDataJPAShoppingCartExpenditureRepository.findAll(), ShoppingCartExpenditureDTO[].class));
  }
}