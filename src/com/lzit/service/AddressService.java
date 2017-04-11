package com.lzit.service;

import java.util.ArrayList;

import com.lzit.entity.Address;

public interface AddressService {
	
	public void insertAddress(String name,String phone,String zip,String
			address,String username);
	
	public ArrayList<Address> selectAddress(String username);
	
	public void updateAddress(String name,String phone,String zip,String
			address,int addid);

}
