package com.venderService.Vender_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.venderService.Vender_service.dao.VendorDao;
import com.venderService.Vender_service.entity.Vendor;
@Service
public class VendorService {

	@Autowired
	private VendorDao dao;
	
	public ResponseEntity<Vendor> saveVendor(Vendor v) {
    Vendor vendor = dao.saveVendor(v);
	return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Vendor> findByVendorId(int id){
		Optional<Vendor> optional = dao.findVendorById(id);
		if(optional.isPresent()) {
			return new ResponseEntity<Vendor>(optional.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Vendor> findAllVendors(){
		List<Vendor> list = dao.findAllVendors();
		return list;
	}
	
	public ResponseEntity<Vendor> deleteVendor(int id){
		dao.deleteVendorById(id);
		
		return new ResponseEntity<Vendor>(HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Vendor>> recommendVendors(double userLat, double userLon, double radius){
		List<Vendor> list = dao.getVendorsWithinRadius(userLat, userLon, radius);
		return new ResponseEntity<List<Vendor>>(list,HttpStatus.FOUND);
	}
	
}
