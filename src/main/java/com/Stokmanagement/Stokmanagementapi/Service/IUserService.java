package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Stokmanagement.Stokmanagementapi.Entity.User;

public interface IUserService {
	
	public User saveUser(User newuser);
	public User finduserById(Long id);
	public User getUserbyEmail(String email);
	public User getuser();

}
