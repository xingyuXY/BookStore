package com.lzit.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.lzit.entity.Cart;
import com.lzit.entity.Orders;
import com.lzit.entity.Signon;
import com.lzit.service.BookService;
import com.lzit.service.CartService;
import com.lzit.service.OrderitemService;
import com.lzit.service.OrdersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersAction extends ActionSupport {

	OrdersService ose = null;
	OrderitemService oise = null;
	CartService ccse=null;
	BookService bse=null;
	
	String username;
	String flag;

	
	public BookService getBse() {
		return bse;
	}
	public void setBse(BookService bse) {
		this.bse = bse;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public OrdersService getOse() {
		return ose;
	}
	public void setOse(OrdersService ose) {
		this.ose = ose;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public OrderitemService getOise() {
		return oise;
	}
	public void setOise(OrderitemService oise) {
		this.oise = oise;
	}
	public CartService getCcse() {
		return ccse;
	}
	public void setCcse(CartService ccse) {
		this.ccse = ccse;
	}
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Orders> list = ose.showOrders(username);
		session.put("orderslist", list);
		return super.execute();
	}
	
	public String insertOrder(){
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Date date=new Date();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		String buydate=dt.format(date);
		double totalprice=(Double) session.get("totalprice");
		ArrayList<Cart> list=ccse.selectCart(username);
	    ose.insertOrders(buydate, totalprice, "ÒÑÖ§¸¶",username,list);
	    for(Cart c:list){
	    	bse.updateBookInventory(c.getBook().getBookid(), c.getBuycount());
	    }
		ccse.deletecartbyusername(username);
		return "success";
	}
	
	public String showOrderAdmin(){
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) ose.getAllOrdersCount();
		int pageNo = 1;
		int pagesize = 10;
		int countPage;
		if (session.get("pageNo") == null) {
			pageNo = 1;
		} else {
			if ("up".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (pageNo > 1)
					pageNo--;
			} else if ("down".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (count % pagesize != 0) {
					if (pageNo < ((count / pagesize) + 1))
						pageNo++;
				} else {
					if (pageNo < (count / pagesize))
						pageNo++;
				}
			}
		}
		if (count % pagesize != 0)
			countPage = ((count / pagesize) + 1);
		else
			countPage = count / pagesize;

		session.put("countPage", countPage);
		session.put("pageNo", pageNo);
		ArrayList<Orders> list = ose.showAllOrders(pageNo, pagesize);
		session.put("orderslist",list);	
		return "success";
	}
}
