package com.venderService.Vender_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venderService.Vender_service.entity.Orders;
import com.venderService.Vender_service.entity.Vendor;
import com.venderService.Vender_service.repository.OrderRepository;
import com.venderService.Vender_service.repository.VendorRepository;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public Orders placeOrder(int vendorId, Orders order) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        order.setVendor(vendor);
        order.setOrderTime(LocalDate.now());
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public List<Orders> getOrdersByVendor(int vendorId) {
        return orderRepository.findByVendorId(vendorId);
    }

    public Orders updateOrderStatus(Long orderId, String status) {
        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
