package es.urjc.code.ejem1.domain;

import org.modelmapper.ModelMapper;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;
	private ProductRepository productRepository;
	private ValidationService validationService;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
	        ProductRepository productRepository,
	        ValidationService validationService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
	}
	
	private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		FullShoppingCartDTO saveFullShoppingCartDTO = shoppingCartRepository.save(fullShoppingCartDTO);

		return (saveFullShoppingCartDTO != null) ? saveFullShoppingCartDTO : fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO getShoppingCart(Long id) {
		return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(fullShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
		        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			shoppingCart.setValidationService(validationService);
			shoppingCart.validate();
		}

		FullShoppingCartDTO newShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		
		return saveShoppingCart(newShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO deleteShoppingCart(Long id) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);
		shoppingCartRepository.deleteById(id);

		return fullShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int quantity) {
		FullProductDTO fullProductDTO = productRepository.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		return addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
	}

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		// En lugar de guardar, debe crear un evento ShoppingCartProductAdded
		// También debe publicarlo en un eventPublisher que se encontrará en la capa de servicios
		// Como el publisher es dependiente de la tecnología (ApplicationEventPublisher de spring)
		// Deberemos inyectarlo como hacemos con el servicio externo de validación en un servicio a parte
		// EL procesador actualizará la vista (materialized view) de carritos completados con sus id-precio total

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}

	@Override
	public FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(idProduct);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}
}
