package com.venderService.Vender_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venderService.Vender_service.entity.Orders;
import com.venderService.Vender_service.entity.Vendor;
import com.venderService.Vender_service.service.OrderService;
import com.venderService.Vender_service.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService service;
	
    
    @Autowired
    private OrderService orderService;
		
	@PostMapping("/save")
	public ResponseEntity<Vendor> saveVendor(@RequestBody Vendor vendor)
	{
		return service.saveVendor(vendor);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Vendor> deleteVendor(@PathVariable int id)
	{
		return service.deleteVendor(id);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Vendor>> findAllVendors(){
		return new ResponseEntity<List<Vendor>>( service.findAllVendors(),HttpStatus.OK);
	}
	
	@GetMapping("/findbyId/{id}")
	public ResponseEntity<Vendor> findById(@PathVariable int id){
		return service.findByVendorId(id);
	}
	
	// GET /vendor/nearby?lat=18.5&lon=73.8&radius=5
    @GetMapping("/nearby")
    public ResponseEntity<List<Vendor>> getNearbyVendors(@RequestParam("lat") double latitude,
                                         @RequestParam("lon") double longitude,
                                         @RequestParam("radius") double radiusKm) {
        return service.recommendVendors(latitude, longitude, radiusKm);
    }


    // Place a new order
    @PostMapping("/place/{vendorId}")
    public ResponseEntity<Orders> placeOrder(@PathVariable int vendorId, @RequestBody Orders order) {
        Orders placedOrder = orderService.placeOrder(vendorId, order);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }

    // Get all orders for a specific vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Orders>> getOrdersByVendor(@PathVariable int vendorId) {
        List<Orders> orders = orderService.getOrdersByVendor(vendorId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Update status of an order
    @PutMapping("/status/{orderId}")
    public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        Orders updatedOrder = orderService.updateOrderStatus(orderId, status);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
	
}
