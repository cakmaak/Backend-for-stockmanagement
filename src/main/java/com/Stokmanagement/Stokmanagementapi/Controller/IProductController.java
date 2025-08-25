package com.Stokmanagement.Stokmanagementapi.Controller;

import java.util.List;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;

public interface IProductController {
	
	public Product saveProduct(Product product);
	public Product findProduct(Long id);
	public List<Product> getallProducts();

}
