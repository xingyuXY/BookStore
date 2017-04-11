package com.lzit.action;

import java.util.ArrayList;
import java.util.Map;

import com.lzit.entity.Cart;
import com.lzit.service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {

	CartService ccse = null;
	int bookid;
	int cartid;

	public CartService getCcse() {
		return ccse;
	}

	public void setCcse(CartService ccse) {
		this.ccse = ccse;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		String username=(String) session.get("loginname");
		ArrayList<Cart> list = ccse.selectCart(username);
		double totalprice = 0;
		for (Cart c : list) {
			totalprice = totalprice + c.getBuycount() * c.getBook().getPrice();
		}
		session.put("totalprice", totalprice);
		session.put("cartlist", list);
		return super.execute();
	}

	public String addCart() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		String username=(String) session.get("loginname");
		int cartid;
		ArrayList<Cart> list = ccse.selectCart(username);
		if (list.size() > 0) {
			for (Cart c : list) {
				if ((c.getBook().getBookid()) == bookid) {
					cartid = c.getCartid();
					ccse.updatecart(1, cartid);
					execute();
					return "success";
				} else {
					ccse.insertcart(1, username, bookid);
					execute();
					return "success";
				}
			}
		} else {
			ccse.insertcart(1, username, bookid);
			execute();
			return "success";
		}
		return null;
	}

	public String deleteCart() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ccse.deletecart(cartid);
		execute();
		return "success";
	}

	public String updateCart() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		String username=(String) session.get("loginname");
		ArrayList<Cart> list = ccse.selectCart(username);
		int buycount = 0;
		for (Cart c : list) {
			if (cartid == c.getCartid())
				buycount = c.getBuycount();
			  break;  
		}
		System.out.println(buycount+"<<<<<<<<<<<<<<<<,,,");
		ccse.updatecart(buycount+1, cartid);
		execute();
		return "success";
	}
}
