package com.lzit.action;

import java.util.ArrayList;
import java.util.Map;

import com.lzit.entity.Address;
import com.lzit.service.AddressService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {
	
	String name;
	String phone;
	String zip;
	String province;
	String city;
	String county;
	String street;
	String username;
	
	AddressService ase=null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public AddressService getAse() {
		return ase;
	}
	public void setAse(AddressService ase) {
		this.ase = ase;
	}
	
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String execute() throws Exception {
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		Address add=new Address();
		add.setAddress(province+city+county+street);
		String address=add.getAddress();
		ase.insertAddress(name, phone, zip, address, username);	
		ArrayList<Address> list=ase.selectAddress(username);
		session.put("addresslist", list);
		return super.execute();
	}
	
	public String address()
	{
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		ArrayList<Address> list=ase.selectAddress(username);
		if(list.size()>=1){
		session.put("addresslist", list);
		return "success";
		}else
		return "address";
	}
	
	public String updateAddress()
	{
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		ArrayList<Address> list=ase.selectAddress(username);
		int addid=0;
		for(Address a:list){
			addid=a.getAddid();
		}
		Address add=new Address();
		add.setAddress(province+city+county+street);
		String address=add.getAddress();
		ase.updateAddress(name, phone, zip, address, addid);
		session.put("addresslist", list);
		return "success";	
	}
}
