package com.user_service.UserService.Entity;

import java.util.List;

import Utility.OrderDTO;
import Utility.VendorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class UserService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String name;
	@Column(unique = true)
	private String username;
	private String role;
	private String password;
	private String dob;
	private String college;
	private String degree;
	private long contact;
	private String email;
	private String location;
	private String address;
	private double lon;
	private double lat;
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Transient
	private List<OrderDTO> order;
	@Transient
	private List<VendorDTO> list;
	
	//constructor
	public UserService() {
		super();
	}
	
	//getters&setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderDTO> getOrder() {
		return order;
	}

	public void setOrder(List<OrderDTO> order) {
		this.order = order;
	}

	public List<VendorDTO> getList() {
		return list;
	}

	public void setList(List<VendorDTO> list) {
		this.list = list;
	}
	
}
