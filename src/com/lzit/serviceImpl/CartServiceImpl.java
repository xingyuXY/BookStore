package com.lzit.serviceImpl;

import java.util.ArrayList;

import com.lzit.dao.CartDao;
import com.lzit.entity.Cart;
import com.lzit.service.CartService;

public class CartServiceImpl implements CartService {
	CartDao ccdo=null;
	public CartDao getCcdo() {
		return ccdo;
	}
	public void setCcdo(CartDao ccdo) {
		this.ccdo = ccdo;
	}
	public ArrayList<Cart> selectCart(String username) {
		return ccdo.selectCart(username);
	}
	public void insertcart(int buycount, String username,int bookid) {
		ccdo.insertcart(buycount, username,bookid);
	}


	public void updatecart(int buycount, int cartid) {
		ccdo.updatecart(buycount, cartid);
		
	}

	

	public void deletecart(int cartid) {
		ccdo.deletecart(cartid);
		
	}
	@Override
	public void deletecartbyusername(String username) {
		ccdo.deletecartbyusername(username);
		
	}
	
}
