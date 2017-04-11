package com.lzit.dao;

import java.util.ArrayList;

import com.lzit.entity.Bookrecord;

public interface BookrecordDao {
	
	public ArrayList<Bookrecord> showRecordByUser(String username);
	
	public ArrayList<Bookrecord> showAllRecord(int pageno,int pagesize);
	
	public void insertBookrecord(String bookrecordname,String bookrecordauthor,String bookrecorddescn,
			String recorddate,String username);
	
	public long getAllBookRecordCount();

}
