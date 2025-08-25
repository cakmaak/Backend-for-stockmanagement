package com.Stokmanagement.Stokmanagementapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;
import com.Stokmanagement.Stokmanagementapi.Service.IProductService;


@RestController
@RequestMapping("/stokman/product")
public class ProductControllerimpl implements IProductController {
	
	@Autowired
	IProductService productService;

	@PostMapping("/saveproduct")
	@Override
	public Product saveProduct(@RequestBody Product product) {
		
		return productService.saveProduct(product) ;
	}

	@GetMapping("/getproduct/{id}")
	@Override
	public Product findProduct(@PathVariable Long id) {
		
		return productService.findProduct(id) ;
	}
	
	@GetMapping("/getallproducts")
	@Override
	public List<Product> getallProducts() {
		
		return productService.getallProducts();
	}

}
