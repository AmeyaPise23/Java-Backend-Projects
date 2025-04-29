package com.qsp.Ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Ecommerce.Service.ProductService;
import com.qsp.Ecommerce.dto.Product;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService service;


	@GetMapping("/products")
	public ResponseEntity<List<Product>> displayAllProducts(){
		return new ResponseEntity<List<Product>>(service.displayAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable int id) {
		
		Optional<Product> optional = service.addProductById(id);
		if(optional.isPresent()) {
			
			return new ResponseEntity<Product>(optional.get(), HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product")
		public ResponseEntity<?> saveProduct(@RequestBody Product product) {
			service.addProduct(product);
			return new ResponseEntity<Product>(HttpStatus.CREATED);
		}
	
}






















