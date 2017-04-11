package com.lzit.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Signon implements Serializable{
	private String username;
	private String password;
	private Integer role;
	private Set<Cart> cart=new HashSet<Cart>();
	private Set<Address> address=new HashSet<Address>();
	private Set<Orders> orders=new HashSet<Orders>();
	private Set<Bookrecord> bookrecord=new HashSet<Bookrecord>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Set<Cart> getCart() {
		return cart;
	}
	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<Bookrecord> getBookrecord() {
		return bookrecord;
	}
	public void setBookrecord(Set<Bookrecord> bookrecord) {
		this.bookrecord = bookrecord;
	}
	
	
	
	
	
	
	
	
	

}
