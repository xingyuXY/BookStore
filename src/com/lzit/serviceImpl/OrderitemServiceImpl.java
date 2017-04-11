package com.lzit.serviceImpl;

import com.lzit.dao.OrderitemDao;
import com.lzit.service.OrderitemService;

public class OrderitemServiceImpl implements OrderitemService {

	OrderitemDao oido = null;
	
	public OrderitemDao getOido() {
		return oido;
	}
	public void setOido(OrderitemDao oido) {
		this.oido = oido;
	}

	@Override
	public void insertOrderitem(int ordercount, int bookid, int orderid) {
		oido.insertOrderitem(ordercount, bookid, orderid);

	}

}
