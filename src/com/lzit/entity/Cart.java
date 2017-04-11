package com.lzit.entity;

import java.io.Serializable;

public class Cart implements Serializable {	
	private int cartid;
	private Integer buycount;	
	private Signon signon;
	private Book book;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public Integer getBuycount() {
		return buycount;
	}
	public void setBuycount(Integer buycount) {
		this.buycount = buycount;
	}
	/*public String getBookname() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}*/
	public Signon getSignon() {
		return signon;
	}
	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
	

}
