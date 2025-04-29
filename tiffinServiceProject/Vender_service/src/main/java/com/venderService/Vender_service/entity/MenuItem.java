package com.venderService.Vender_service.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MenuItem {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @JsonProperty("item_name")
	    private String itemName;
	    private String description;
	    private double price;

	    // "regular" or "special"
	    private String type;

	    // Only applicable if type = "special"
	    private LocalDate date;

	    @ManyToOne
	    @JoinColumn(name = "vendor")
	    @JsonBackReference
	    private Vendor vendor;

	    // Constructors
	    public MenuItem() {}

	    public MenuItem(String itemName, String description, double price, String type, LocalDate date, Vendor vendor) {
	        this.itemName = itemName;
	        this.description = description;
	        this.price = price;
	        this.type = type;
	        this.date = date;
	        this.vendor = vendor;
	    }

	    // Getters & Setters
	    public Long getId() { return id; }

	    public String getItemName() { return itemName; }
	    public void setItemName(String itemName) { this.itemName = itemName; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public double getPrice() { return price; }
	    public void setPrice(double price) { this.price = price; }

	    public String getType() { return type; }
	    public void setType(String type) { this.type = type; }

	    public LocalDate getDate() { return date; }
	    public void setDate(LocalDate date) { this.date = date; }

	    public Vendor getVendor() { return vendor; }
	    public void setVendor(Vendor vendor) { this.vendor = vendor; }
}
