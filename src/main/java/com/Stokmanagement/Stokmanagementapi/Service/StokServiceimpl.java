package com.Stokmanagement.Stokmanagementapi.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;
import com.Stokmanagement.Stokmanagementapi.Entity.Stok;
import com.Stokmanagement.Stokmanagementapi.Repository.ProductRepository;
import com.Stokmanagement.Stokmanagementapi.Repository.StokRepository;

@Service
public class StokServiceimpl implements IStokService {
	@Autowired
	IProductService productService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	StokRepository stokRepository;

	@Override
	public Stok saveStokHistory(Stok stokhistory,Long id,Long id2) {
		  Stok newStok = new Stok();
		    BeanUtils.copyProperties(stokhistory, newStok);

		    newStok.setUser(userService.finduserById(id2));
		    newStok.setOluşturmatarihi(LocalDateTime.now());

		    Product product = productService.findProduct(id);
		    newStok.setProduct(product);

		    
		    product.setMiktar(product.getMiktar() + newStok.getEklenenmiktar());

		    stokRepository.save(newStok);
		    return newStok;
	}
	
	

}
