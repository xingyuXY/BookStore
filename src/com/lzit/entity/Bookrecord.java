package com.lzit.entity;

import java.io.Serializable;
import java.util.Date;

public class Bookrecord implements Serializable {

	private int recordid;
	private String bookrecordname;
	private String bookrecordauthor;
	private String bookrecorddescn;
	private String recorddate;

	private Signon signon;

	public int getRecordid() {
		return recordid;
	}

	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}

	public String getBookrecordname() {
		return bookrecordname;
	}

	public void setBookrecordname(String bookrecordname) {
		this.bookrecordname = bookrecordname;
	}

	public String getBookrecordauthor() {
		return bookrecordauthor;
	}

	public void setBookrecordauthor(String bookrecordauthor) {
		this.bookrecordauthor = bookrecordauthor;
	}

	public String getBookrecorddescn() {
		return bookrecorddescn;
	}

	public void setBookrecorddescn(String bookrecorddescn) {
		this.bookrecorddescn = bookrecorddescn;
	}

	public String getRecorddate() {
		return recorddate;
	}

	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

}
