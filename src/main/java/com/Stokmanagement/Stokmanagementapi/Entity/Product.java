package com.Stokmanagement.Stokmanagementapi.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product",schema = "stokmanagement")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "isim")
	private String isim;
	
	@Column(name = "miktar")
	private int miktar;
	

	@OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Stok> stoklist=new ArrayList<>();
	
	
	
	
	

}
