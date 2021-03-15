package com.volgainfo.inventorymgmt.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDto {
	
	private Long id;
	private String name;
	private Double ammount;
	
	private List<ImageDto> imageDtos;
	
	private Double quantity;
	private String brand;
	private Boolean isActivated;
}
