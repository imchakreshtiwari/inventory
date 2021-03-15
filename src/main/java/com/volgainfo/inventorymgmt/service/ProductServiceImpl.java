package com.volgainfo.inventorymgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.volgainfo.inventorymgmt.dto.ProductDto;
import com.volgainfo.inventorymgmt.entity.ProductEntity;
import com.volgainfo.inventorymgmt.exception.RecordNotFoundException;
import com.volgainfo.inventorymgmt.mapper.ProductMapper;
import com.volgainfo.inventorymgmt.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public ProductDto addProduct(ProductDto productDto) {

		long startTime = System.currentTimeMillis();

		ProductEntity productEntity = productRepository.save(productMapper.toEntity(productDto));
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDto(productEntity);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		long startTime = System.currentTimeMillis();
		ProductEntity productEntity = productRepository.findById(productDto.getId())
				.orElseThrow(() -> new RecordNotFoundException("Product not found"));
		ProductEntity updatedProductEntity = productRepository
				.save(productMapper.toEntityUpdate(productDto, productEntity));
		
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDto(updatedProductEntity);
	}

	@Override
	public ProductDto getProductById(Long id) {

		long startTime = System.currentTimeMillis();
		ProductEntity productEntity = productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Product not found"));
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDto(productEntity);

	}

	@Override
	public List<ProductDto> getAllProducts() {
		long startTime = System.currentTimeMillis();
		List<ProductEntity> productEntities = productRepository.findAll();
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDtos(productEntities);
	}

	@Override
	public List<ProductDto> getProductsByBrand(String brand) {
		long startTime = System.currentTimeMillis();
		List<ProductEntity> productEntities = productRepository.findByBrand(brand);
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDtos(productEntities);
	}

	// Results Sorted By Price Asc
	@Override
	public List<ProductDto> getProductsByPriceAsc() {
		
		long startTime = System.currentTimeMillis();
		Iterable<ProductEntity> products = productRepository.findAll(Sort.by("ammount").ascending());
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDtos((List<ProductEntity>) products);
	}

	// Results Sorted By Price Desc
	@Override
	public List<ProductDto> getProductsByPriceDsc() {
		
		long startTime = System.currentTimeMillis();
		Iterable<ProductEntity> products = productRepository.findAll(Sort.by("ammount").descending());
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		return productMapper.toDtos((List<ProductEntity>) products);
	}

	@Override
	public void deleteProduct(Long id) {

		long startTime = System.currentTimeMillis();
		ProductEntity productEntity = productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Product not found"));
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Total time taken by process in ms : {}", timeTaken);
		productRepository.delete(productEntity);
	}

}
