package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.List;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;

public interface IProductService {
	public Product saveProduct(Product product);
	public Product findProduct(Long id);
	public List<Product> getallProducts();
	
}
