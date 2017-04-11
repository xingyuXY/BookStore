package com.lzit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Orders implements Serializable {

	private int orderid;
	private String buydate;
	private Double totalprice;
	private String orderstate;

	// private Address address;
	private Signon signon;
	private Set<Orderitem> orderitem = new HashSet<Orderitem>();

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getBuydate() {
		return buydate;
	}

	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Set<Orderitem> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Set<Orderitem> orderitem) {
		this.orderitem = orderitem;
	}

}
