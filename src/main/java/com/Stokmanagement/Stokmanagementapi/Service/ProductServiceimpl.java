package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;
import com.Stokmanagement.Stokmanagementapi.Entity.User;
import com.Stokmanagement.Stokmanagementapi.Repository.ProductRepository;

@Service
public class ProductServiceimpl implements IProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	IUserService userService;

	@Override
	public Product saveProduct(Product product) {
	   
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	    if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }

	    String email;
	    Object principal = auth.getPrincipal();
	    if (principal instanceof UserDetails) {
	        email = ((UserDetails) principal).getUsername();
	    } else if (principal instanceof com.Stokmanagement.Stokmanagementapi.Entity.User) {
	       
	        email = ((com.Stokmanagement.Stokmanagementapi.Entity.User) principal).getEmail();
	    } else {
	        throw new RuntimeException("Bilinmeyen principal tipi");
	    }

	    
	    User user = userService.getUserbyEmail(email);

	  
	    return productRepository.save(product);
	}

	@Override
	public Product findProduct(Long id) {
		Optional<Product> optional=productRepository.findById(id);
		Product product=optional.get();
		return product;
	}


	@Override
	public List<Product> getallProducts() {
		List<Product> getallList=productRepository.findAll();
		
		
		return getallList;
	}



}
