package com.volgainfo.inventorymgmt.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private String username;
	private String password;
	private Boolean enabled;
	private Integer roleId;
}
