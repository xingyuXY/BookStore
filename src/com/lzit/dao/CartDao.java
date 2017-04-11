package com.lzit.dao;

import java.util.ArrayList;

import com.lzit.entity.Cart;

public interface CartDao {
	
	public ArrayList<Cart> selectCart(String username);
	
	public void insertcart(int buycount,String username,int bookid);
	
	public void updatecart(int buycount,int cartid);
	
	public void deletecart(int cartid);
	
	public void deletecartbyusername(String username);

}
