package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stokmanagement.Stokmanagementapi.Entity.User;
import com.Stokmanagement.Stokmanagementapi.Repository.UserRepository;

@Service
public class UserServiceimpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User newuser) {
		
		User user=new User();
		BeanUtils.copyProperties(newuser, user);
		userRepository.save(user);
		
		return user;
	}

	@Override
	public User finduserById(Long id) {
		Optional<User> optional=userRepository.findById(id);
		User user=optional.get();
		
	
		
		return user;
	}


	@Override
	public User getUserbyEmail(String email) {
		System.out.println("DB'de aranıyor (IgnoreCase): " + email);

	    Optional<User> userOpt = userRepository.findByEmailIgnoreCase(email.trim());

	    if(userOpt.isPresent()) {
	        User user = userOpt.get();

	        System.out.println("Kullanıcı bulundu: " + user.getEmail());

	        return user;
	    } else {
	        throw new RuntimeException("kullanıcı bulunamadi");
	    }
	}
	
	

}
