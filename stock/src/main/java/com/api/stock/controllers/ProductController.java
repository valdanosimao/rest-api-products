package com.api.stock.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ProductDTO>> getProducts(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.getAllProducts());
	}
	
	//Ao colocar o RequestBody o spring transforma/converte as informacoes passadas como JSON, em um objeto produto
	@PostMapping("/save")
	public ResponseEntity<ProductDTO> addProducts(@RequestBody @Valid ProductDTO productDto) { 
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.saveProduct(productDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductDTO>> getProductsById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.getProductById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {		
		productService.deleteProductById(id);
		 return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfylly");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.updateProduct(productDto, id));
	}
	
	
	//metodos getters and setters
	public ProductService getProductService() {
		return productService;
	}	

}
