package com.volgainfo.inventorymgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.volgainfo.inventorymgmt.dto.UserDto;
import com.volgainfo.inventorymgmt.entity.UserEntity;
import com.volgainfo.inventorymgmt.repository.RoleRepository;
import com.volgainfo.inventorymgmt.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/user")
	public void addCoachingDetails() {
		System.out.println("From Get");
		
	}
	
	@PostMapping(value = "/admin")
	public void getAllPriorityAreaU(){
		System.out.println("From Post");
		
	}
	
	@PostMapping(value = "/")
	public void getAllPriorityAreaUss(){
		System.out.println("From Pos only /t");
		
	}
	
	
	@PostMapping(value = "/register")
	public void processRegister(@RequestBody UserDto userDto) {
		
		UserEntity user = new UserEntity();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEnabled(userDto.getEnabled());
		
		
		user.getRoles().add(roleRepository.findById(userDto.getRoleId()).orElse(null));
		
		userRepository.save(user);
	}
}
