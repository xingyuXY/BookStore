package com.lzit.serviceImpl;

import java.util.ArrayList;

import com.lzit.dao.SignonDao;
import com.lzit.entity.Signon;
import com.lzit.service.SignonService;

public class SignonServiceImpl implements SignonService {
	SignonDao sdo=null;
	public SignonDao getSdo() {
		return sdo;
	}
	public void setSdo(SignonDao sdo) {
		this.sdo = sdo;
	}
	
	public boolean checkBySignon(String username, String password) {
		 ArrayList<Signon> list=sdo.checkBySignon(username, password);
			if(list!=null && list.size()>0)
				return true;
		return false;
	}
	
	public ArrayList<Signon> checkByName(String username) {
		return sdo.checkByName(username);
	}

	public void insertSignon(String username, String password) {
		sdo.insertSignon(username, password);
		
	}
	
	public ArrayList<Signon> showAllSignon(int pageno,int pagesize) {
		return sdo.showAllSignon(pageno, pagesize);
	}
	@Override
	public void deleteSignon(String username) {
		sdo.deleteSignon(username);
		
	}
	@Override
	public void updateSignon(String username) {
		sdo.updateSignon(username);
		
	}
	@Override
	public long getAllSignonCount() {
		return sdo.getAllSignonCount();
	}
	

}
