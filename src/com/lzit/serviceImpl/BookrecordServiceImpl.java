package com.lzit.serviceImpl;

import java.util.ArrayList;

import com.lzit.dao.BookrecordDao;
import com.lzit.entity.Bookrecord;
import com.lzit.service.BookrecordService;

public class BookrecordServiceImpl implements BookrecordService {
	BookrecordDao brdo = null;
	

	public BookrecordDao getBrdo() {
		return brdo;
	}

	public void setBrdo(BookrecordDao brdo) {
		this.brdo = brdo;
	}

	@Override
	public ArrayList<Bookrecord> showRecordByUser(String username) {
		return brdo.showRecordByUser(username);
	}

	@Override
	public ArrayList<Bookrecord> showAllRecord(int pageno, int pagesize) {
		return brdo.showAllRecord(pageno, pagesize);
	}

	@Override
	public void insertBookrecord(String bookrecordname, String bookrecordauthor, String bookrecorddescn,
			String recorddate, String username) {
		brdo.insertBookrecord(bookrecordname, bookrecordauthor, bookrecorddescn, recorddate, username);
	}

	@Override
	public long getAllBookRecordCount() {
		return brdo.getAllBookRecordCount();
	}

}
