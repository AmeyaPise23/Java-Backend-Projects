package com.qsp.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Ecommerce.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
