package com.lzit.dao;

import java.util.ArrayList;

import com.lzit.entity.Address;

public interface AddressDao {
	
	public void insertAddress(String name,String phone,String zip,String
			address,String username);
	
	public ArrayList<Address> selectAddress(String username);
	
	public void updateAddress(String name,String phone,String zip,String
			address,int addid);

}
