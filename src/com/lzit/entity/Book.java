package com.lzit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Book implements Serializable{
	
	private int bookid;
	private String bookname;
	private String author;
	private Double price;
	private Integer inventory;
	private Integer sellcount;
	private String picture;
	private String publishdate;
	private int secondhand;
	private String descn1;
	private String descn2;
	private String descn3;
	private String descn4;
	
	private Category category;
	//private Cart cart;
	private Set<Cart> cart=new HashSet<Cart>();
	private Set<Orderitem> orderitem=new HashSet<Orderitem>();
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	/*public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public int getSellcount() {
		return sellcount;
	}
	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}*/
	
	
	
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
	
	
	
	public Integer getSellcount() {
		return sellcount;
	}
	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Cart> getCart() {
		return cart;
	}
	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	public Set<Orderitem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(Set<Orderitem> orderitem) {
		this.orderitem = orderitem;
	}
	public int getSecondhand() {
		return secondhand;
	}
	public void setSecondhand(int secondhand) {
		this.secondhand = secondhand;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getDescn1() {
		return descn1;
	}
	public void setDescn1(String descn1) {
		this.descn1 = descn1;
	}
	public String getDescn2() {
		return descn2;
	}
	public void setDescn2(String descn2) {
		this.descn2 = descn2;
	}
	public String getDescn3() {
		return descn3;
	}
	public void setDescn3(String descn3) {
		this.descn3 = descn3;
	}
	public String getDescn4() {
		return descn4;
	}
	public void setDescn4(String descn4) {
		this.descn4 = descn4;
	}
	

	
	
	
	

}
