package com.Stokmanagement.Stokmanagementapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Stokmanagement.Stokmanagementapi.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long >{

}
