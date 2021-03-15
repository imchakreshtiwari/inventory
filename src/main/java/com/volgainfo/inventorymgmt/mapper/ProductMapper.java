package com.volgainfo.inventorymgmt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.volgainfo.inventorymgmt.dto.ImageDto;
import com.volgainfo.inventorymgmt.dto.ProductDto;
import com.volgainfo.inventorymgmt.entity.ImageEntity;
import com.volgainfo.inventorymgmt.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	default ProductEntity toEntity(ProductDto productDto) {
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDto.getName());
		productEntity.setAmmount(productDto.getAmmount());
		productEntity.setBrand(productDto.getBrand());
		productEntity.setQuantity(productDto.getQuantity());
		productEntity.setImageEntities(toImageEnitites(productDto.getImageDtos(), productEntity));
		productEntity.setIsActivated(productDto.getIsActivated());
		return productEntity;
		
	}
	
	default ImageEntity toImageEntity(ImageDto imageDto, ProductEntity productEntity){
		
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setProduct(productEntity);
		imageEntity.setImagePath(imageDto.getImagePath());
		return imageEntity;
	}
	
	default List<ImageEntity> toImageEnitites(List<ImageDto> imageDtos, ProductEntity productEntity){
		
		List<ImageEntity> images = new ArrayList<>();
		for (ImageDto imageDto : imageDtos) {
			images.add(toImageEntity(imageDto, productEntity));
		}
		return images;
		
	}

	default ProductDto toDto(ProductEntity productEntity) {
		
		ProductDto productDto = new ProductDto();
		productDto.setId(productEntity.getId());
		productDto.setName(productEntity.getName());
		productDto.setAmmount(productEntity.getAmmount());
		productDto.setBrand(productEntity.getBrand());
		productDto.setQuantity(productEntity.getQuantity());
		productDto.setIsActivated(productEntity.getIsActivated());
		productDto.setImageDtos(toImageDtos(productEntity.getImageEntities()));
		return productDto;
	}
	
	default ImageDto toImageDto(ImageEntity imageEntity){
		
		ImageDto imageDto = new ImageDto();
		imageDto.setId(imageEntity.getId());
		imageDto.setImagePath(imageEntity.getImagePath());
		return imageDto;
	}
	
	default List<ImageDto> toImageDtos(List<ImageEntity> imageEntities){
		
		List<ImageDto> images = new ArrayList<>();
		for (ImageEntity imageEntity : imageEntities) {
			images.add(toImageDto(imageEntity));
		}
		return images;
	}
	

	default ProductEntity toEntityUpdate(ProductDto productDto, ProductEntity productEntity) {

		productEntity.setName(productDto.getName());
		productEntity.setAmmount(productDto.getAmmount());
		productEntity.setBrand(productDto.getBrand());
		productEntity.setQuantity(productDto.getQuantity());
		productEntity.setIsActivated(productDto.getIsActivated());
		return productEntity;
	}

	default List<ProductDto> toDtos(List<ProductEntity> productEntities) {

		List<ProductDto> products = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			products.add(toDto(productEntity));
		}
		return products;
	}
}
