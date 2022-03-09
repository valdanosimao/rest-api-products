package com.api.stock.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.api.stock.dto.ProductDTO;
import com.api.stock.exceptions.ResourceNotFoundException;
import com.api.stock.models.Product;
import com.api.stock.repositories.ProductRepository;

@Service
public class ProductService {

private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {	
		this.productRepository = productRepository;
	}

	/**
	 * metodo que retorna uma lista de produtos
	 * @return Returna lista de produtos
	 */
	public List<ProductDTO> getAllProducts(){
		
		List<Product> products = productRepository.findAll();
		
		return products.stream()
				.map(product -> new ModelMapper().map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}	
	
	/**
	 * metodo que retorna um produto encontrado por id.
	 * @param id do produto que serao localizado.
	 * @return Retorna um produto caso existir.
	 */
	public Optional<ProductDTO> getProductById(Long id) {	
		//obtendo produto pelo id
		Optional<Product> product = productRepository.findById(id);
		
		//se nao encontrar lanca exception
		if(product.isEmpty()) {
			throw new ResourceNotFoundException("Product by id " + id + " not found ");
		}
		
		//convertendo o meu optional de product em um productDto
		ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);
		
		//criando e retornando um optional de productDto
		return Optional.of(dto);
	}	
	
	/**
	 * metodo que salva um produto
	 * @param produto que serao salvo
	 * 
	 */
	@Transactional
	public ProductDTO saveProduct(ProductDTO productDTO) {	
		
		//criar um objeto de mapeamento.
		ModelMapper mapper = new ModelMapper();
		
		//converter o productDto em um product
		Product product = mapper.map(productDTO, Product.class);
		
		//salvar o product no banco
		product = productRepository.save(product);
		
		productDTO.setId(product.getId());
		
		//retorna o productDto atualizado
		return productDTO;
		
	}
	
	/**
	 * metodo que deleta um produto por id
	 * @param id do produto a ser deletado
	 */
	public void deleteProductById(Long id) {
		
		//verificar se o produto existe
		Optional<Product> product = productRepository.findById(id);
		
		//se nao existir lanca uma exception
		if(product.isEmpty()) {
			throw new ResourceNotFoundException("Product not found by id " + id + "product does not exist"); 
		}
		
		//dele o produto pelo id
		productRepository.deleteById(id);
	}	
	
	/**
	 * metodo para atualizar o produto na lista
	 * @param produto que serao atualizado
	 * @param id do produto que serao atualizado
	 * @return Retorna o produto apos atualizar a lista
	 */
	public ProductDTO updateProduct(ProductDTO productDTO,Long id) {
		
		//passar o id para o produtoDto
		productDTO.setId(id);
		
		//criar um objeto de mapeamento
		ModelMapper mapper = new ModelMapper();
		
		//converter o productDto em um product
		Product product = mapper.map(productDTO, Product.class);		
		
		//atualizar o product no bando de dados
		productRepository.save(product);
		
		//retorna o productDto atualizado
		return productDTO;	
	

	}

	
}
