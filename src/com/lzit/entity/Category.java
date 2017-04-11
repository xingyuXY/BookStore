package com.lzit.entity;

import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

public class Category implements Serializable {
	
	private int catid;
	private String category;
	private Set<Book> book=new HashSet<Book>();
	
	
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	

}
