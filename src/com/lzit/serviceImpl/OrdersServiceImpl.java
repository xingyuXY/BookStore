package com.lzit.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import com.lzit.dao.OrdersDao;
import com.lzit.entity.Cart;
import com.lzit.entity.Orders;
import com.lzit.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	OrdersDao odo=null;
	public OrdersDao getOdo() {
		return odo;
	}
	public void setOdo(OrdersDao odo) {
		this.odo = odo;
	}


	public ArrayList<Orders> showOrders(String username) {
		
		return odo.showOrders(username);
	}

	public void insertOrders(String buydate, double totalprice,
			String orderstate, String username,ArrayList<Cart> list) {
		odo.insertOrders(buydate, totalprice, orderstate, username, list);
		
	}
	@Override
	public void updateOrderstate(int orderid, String orderstate) {
		odo.updateOrderstate(orderid, orderstate);
		
	}
	@Override
	public ArrayList<Orders> showAllOrders(int pageno, int pagesize) {
		return odo.showAllOrders(pageno, pagesize);
	}
	@Override
	public long getAllOrdersCount() {
		return odo.getAllOrdersCount();
	}

}
