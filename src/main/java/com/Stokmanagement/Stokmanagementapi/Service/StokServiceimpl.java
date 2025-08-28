package com.Stokmanagement.Stokmanagementapi.Service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;
import com.Stokmanagement.Stokmanagementapi.Entity.Stok;
import com.Stokmanagement.Stokmanagementapi.Entity.User;
import com.Stokmanagement.Stokmanagementapi.Repository.ProductRepository;
import com.Stokmanagement.Stokmanagementapi.Repository.StokRepository;


@Service
public class StokServiceimpl implements IStokService {

    private final SecurityFilterChain filterChain;
	@Autowired
	IProductService productService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	StokRepository stokRepository;

    StokServiceimpl(SecurityFilterChain filterChain) {
        this.filterChain = filterChain;
    }

	@Override
	public Stok saveStokHistory(Stok stockhistory,Long productid) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }

	    String email = ((UserDetails) auth.getPrincipal()).getUsername();
	    User user = userService.getUserbyEmail(email);

	    Product product = productService.findProduct(productid);
	    if (product == null) {
	        throw new RuntimeException("Ürün bulunamadı: " + productid);
	    }

	    Stok newStok = new Stok();
	    newStok.setUser(user);
	    newStok.setProduct(product);
	    newStok.setEklenenmiktar(stockhistory.getEklenenmiktar());
	    newStok.setOluşturmatarihi(LocalDateTime.now());

	    product.setMiktar(product.getMiktar() + stockhistory.getEklenenmiktar());

	    stokRepository.save(newStok);
	    productService.saveProduct(product);

	    return newStok;
	}

	


	
	

}
