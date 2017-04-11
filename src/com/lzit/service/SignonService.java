package com.lzit.service;

import java.util.ArrayList;

import com.lzit.entity.Signon;

public interface SignonService {
	
	public boolean checkBySignon(String username,String password);
	public ArrayList<Signon> checkByName(String username);
	
	public void insertSignon(String username,String password);
	
	 public ArrayList<Signon> showAllSignon(int pageno,int pagesize);
	 
	 public void deleteSignon(String username);
	 
	 public void updateSignon(String username);
	 
	 public long getAllSignonCount();

}
