package com.Stokmanagement.Stokmanagementapi.Service;

import java.net.Authenticator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import com.Stokmanagement.Stokmanagementapi.Entity.User;
import com.Stokmanagement.Stokmanagementapi.Repository.UserRepository;



@Service
public class UserServiceimpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	
	@Override
	public User saveUser(User newuser) {
		
		
		userRepository.save(newuser);
		
		return newuser;
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

	@Override
	public User getuser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }
	    String email;
	    Object principal = auth.getPrincipal();
	    if (principal instanceof UserDetails) {
	        email = ((UserDetails) principal).getUsername();
	    } else if (principal instanceof User) {
	        email = ((User) principal).getEmail();
	    } else {
	        throw new RuntimeException("Bilinmeyen principal tipi");
	    }
	    
	    User user=getUserbyEmail(email);

		return user;
	
		
		
	}
	
	

}
