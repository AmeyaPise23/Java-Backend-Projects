package com.qsp.Ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Ecommerce.Repository.ProductRepo;
import com.qsp.Ecommerce.dto.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;

	public List<Product> displayAllProducts(){
		return repo.findAll(); 
	}

	public Optional<Product> addProductById(int id) {
		Optional<Product> optional = repo.findById(id);
		return optional;
		
	}

	public void addProduct(Product product) {
		repo.save(product);		
	}
}
