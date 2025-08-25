package com.Stokmanagement.Stokmanagementapi.Security;

import com.Stokmanagement.Stokmanagementapi.Entity.User; // kendi User entity’n
import com.Stokmanagement.Stokmanagementapi.Repository.UserRepository;
import com.Stokmanagement.Stokmanagementapi.Service.IUserService; // senin servis
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	IUserService userService;
	


  

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userService.getUserbyEmail(email);
        if (u == null) throw new UsernameNotFoundException("User not found: " + email);

        
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getPassword()) 
                .authorities(List.of())
                .accountExpired(false).accountLocked(false)
                .credentialsExpired(false).disabled(false)
                .build();
    }
}