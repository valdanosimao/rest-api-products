package com.api.stock.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.dto.ProductDTO;
import com.api.stock.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ProductDTO> getProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/save")
	public ProductDTO addProducts(@RequestBody ProductDTO productDto) { //Ao colocar o RequestBody o spring transforma/converte as informaÃ§Ãµes passadas como JSON, em um objeto produto
		productService.saveProduct(productDto);
		return productDto;
	}
	
	@GetMapping("/{id}")
	public Optional<ProductDTO> getProductsById(@PathVariable Long id){
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "product with id " + id + " successfully deleted!";
	}
	
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDto, @PathVariable Long id) {
		return productService.updateProduct(productDto, id);
	}
	
	
	//mÃ©todos getters and setters
	public ProductService getProductService() {
		return productService;
	}	

}
