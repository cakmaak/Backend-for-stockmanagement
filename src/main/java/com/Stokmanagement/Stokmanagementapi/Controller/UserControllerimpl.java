package com.Stokmanagement.Stokmanagementapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stokmanagement.Stokmanagementapi.Entity.User;
import com.Stokmanagement.Stokmanagementapi.Service.IUserService;

@RestController
@RequestMapping("/stokman/user")
public class UserControllerimpl implements IUserController {
	@Autowired
	IUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	@PostMapping("/saveuser")
	@Override
	public User saveUser(@RequestBody User newuser) {
		newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
		
		return userService.saveUser(newuser) ;
	}
	
	@GetMapping("/getuser/{id}")
	@Override
	public User finduserById(@PathVariable Long id) {
		
		return userService.finduserById(id);
	}

}
