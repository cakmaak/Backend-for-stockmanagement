package com.Stokmanagement.Stokmanagementapi.Controller;

import com.Stokmanagement.Stokmanagementapi.Entity.User;

public interface IUserController {
	public User saveUser(User newuser);
	public User finduserById(Long id);

}
