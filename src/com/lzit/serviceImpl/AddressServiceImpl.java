package com.lzit.serviceImpl;

import java.util.ArrayList;

import com.lzit.dao.AddressDao;
import com.lzit.entity.Address;
import com.lzit.service.AddressService;

public class AddressServiceImpl implements AddressService {

	AddressDao ado=null;
	
	public AddressDao getAdo() {
		return ado;
	}
	public void setAdo(AddressDao ado) {
		this.ado = ado;
	}

	
	public void insertAddress(String name, String phone, String zip,
			String address, String username) {
		ado.insertAddress(name, phone, zip, address, username);

	}

	public ArrayList<Address> selectAddress(String username) {
		return ado.selectAddress(username);
	}
	@Override
	public void updateAddress(String name, String phone, String zip, String address, int addid) {
		ado.updateAddress(name, phone, zip, address, addid);
		
	}

}
