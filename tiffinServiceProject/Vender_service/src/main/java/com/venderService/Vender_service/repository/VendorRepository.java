package com.venderService.Vender_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venderService.Vender_service.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{

	@Query("SELECT v.latitude FROM Vendor v")
	List<Double> findAllLatitudes();
	
	@Query("SELECT v.longitude FROM Vendor v")
	List<Double> findAllLongitudes();

}
