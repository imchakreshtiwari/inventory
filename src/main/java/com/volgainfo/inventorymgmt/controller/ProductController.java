package com.volgainfo.inventorymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.volgainfo.inventorymgmt.dto.ProductDto;
import com.volgainfo.inventorymgmt.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ProductDto addProduct(@RequestBody ProductDto productDto) {
		
		log.info("Calling api to add Product");
		return productService.addProduct(productDto);
	}
	
	@PutMapping("/product")
	public ProductDto updateProduct(@RequestBody ProductDto productDto) {
		
		log.info("Calling api to update Product");
		return productService.updateProduct(productDto);
	}
	
	@GetMapping("/product")
	public List<ProductDto> getAllProduct() {
		
		log.info("Calling api to get all  Product");
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/get/filter/asc")
	public List<ProductDto> getAllProductAsc() {
		
		log.info("Calling api to get all Product sorted by Price");
		return productService.getProductsByPriceAsc();
	}
	
	@GetMapping("/product/get/filter/desc")
	public List<ProductDto> getAllProductDesc() {
		
		log.info("Calling api to get all Product sorted by Price");
		return productService.getProductsByPriceDsc();
	}
	
	@GetMapping("/product/get/filter/{brand}")
	public List<ProductDto> getAllProductByBrand(@PathVariable("brand") String brand) {
		
		log.info("Calling api to get all Product filter by brand type");
		return productService.getProductsByBrand(brand);
	}
	
	@GetMapping("/product/get/{id}")
	public ProductDto getProductById(@PathVariable("id") Long id) {
		
		log.info("Calling api to get product by id");
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable("id") Long id) {
		
		log.info("Calling api to delete Product by id");
		productService.deleteProduct(id);
	}
	
}
