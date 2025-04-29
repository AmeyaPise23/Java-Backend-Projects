package com.venderService.Vender_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venderService.Vender_service.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

	List<Orders> findByVendorId(int vendorId);
}
