package com.lzit.service;

import java.util.ArrayList;
import java.util.Date;

import com.lzit.entity.Cart;
import com.lzit.entity.Orders;

public interface OrdersService {
	
	public ArrayList<Orders> showOrders(String username); 
	
	public void insertOrders(String buydate,double totalprice,String orderstate,String username,
			ArrayList<Cart> list);
	
	public void updateOrderstate(int orderid,String orderstate);
	
	public ArrayList<Orders> showAllOrders(int pageno,int pagesize);
	
	public long getAllOrdersCount();

}
