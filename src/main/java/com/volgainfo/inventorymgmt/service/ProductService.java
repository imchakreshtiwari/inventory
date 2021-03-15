package com.volgainfo.inventorymgmt.service;

import java.util.List;

import com.volgainfo.inventorymgmt.dto.ProductDto;

public interface ProductService {

	public ProductDto addProduct(ProductDto productDto);
	
	public ProductDto updateProduct(ProductDto productDto);
	
	public ProductDto getProductById(Long id);
	
	public List<ProductDto> getAllProducts();
	
	public List<ProductDto> getProductsByBrand(String brand);
	
	public List<ProductDto> getProductsByPriceAsc();
	
	public List<ProductDto> getProductsByPriceDsc();
	
	public void deleteProduct(Long id);
}
