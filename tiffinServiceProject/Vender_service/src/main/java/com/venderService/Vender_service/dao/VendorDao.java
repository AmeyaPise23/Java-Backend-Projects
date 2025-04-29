package com.venderService.Vender_service.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.venderService.Vender_service.entity.MenuItem;
import com.venderService.Vender_service.entity.Vendor;
import com.venderService.Vender_service.repository.VendorRepository;

import Vendor.Util.GeoUtils;
@Component
public class VendorDao {

	@Autowired
	private VendorRepository repo;
	
	
	public Vendor saveVendor(Vendor vendor) {
	    // Set vendor reference for each menu item before saving
	    if (vendor.getMenuItems() != null) {
	        for (MenuItem item : vendor.getMenuItems()) {
	            item.setVendor(vendor);
	        }
	    }

	    return repo.save(vendor);
	}
	
	public Optional<Vendor> findVendorById(int id){
		Optional<Vendor> optional = repo.findById(id);
		return optional;
	}
	
	public List<Vendor> findAllVendors(){
		List<Vendor> list = repo.findAll();
		return list;
	}
	
	public ResponseEntity<String> deleteVendorById(int id) {
		if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("Vendor deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
		
	}
		
	public List<Vendor> getVendorsWithinRadius(double userLat, double userLon, double radiusKm) {
	    List<Vendor> allVendors = repo.findAll();
	    List<Vendor> nearbyVendors = new ArrayList<>();

	    for (Vendor vendor : allVendors) {
	        double distance = GeoUtils.calculateDistance(userLat, userLon,vendor.getLatitude(), vendor.getLongitude());

	        if (distance <= radiusKm) {
	            nearbyVendors.add(vendor);
	        }
	    }

	    return nearbyVendors;
	}


}
