package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;
import com.Stokmanagement.Stokmanagementapi.Repository.ProductRepository;

@Service
public class ProductServiceimpl implements IProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		
		productRepository.save(product);
		return product;
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
