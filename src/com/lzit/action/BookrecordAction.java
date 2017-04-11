package com.lzit.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.lzit.entity.Book;
import com.lzit.entity.Bookrecord;
import com.lzit.entity.Signon;
import com.lzit.service.BookrecordService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookrecordAction extends ActionSupport{
	BookrecordService brde = null;
	String bookrecordname;
	String bookrecordauthor;
	String bookrecorddescn;
	String flag;
	
	public BookrecordService getBrde() {
		return brde;
	}
	public void setBrde(BookrecordService brde) {
		this.brde = brde;
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
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		String username = (String) session.get("loginname");
		ArrayList<Bookrecord> list = brde.showRecordByUser(username);
		session.put("bookrecordlist", list);
		return super.execute();
	}
	public String insertBookRecord() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Date date=new Date();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		String recorddate=dt.format(date);
		String username = (String) session.get("loginname");
		brde.insertBookrecord(bookrecordname, bookrecordauthor, bookrecorddescn, recorddate, username);
		return "success";
	}
	public String showAllBookRecord() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) brde.getAllBookRecordCount();
		int pageNo = 1;
		int pagesize = 10;
		int countPage;
		if (session.get("pageNo") == null) {
			pageNo = 1;
		} else {
			if ("up".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (pageNo > 1)
					pageNo--;
			} else if ("down".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (count % pagesize != 0) {
					if (pageNo < ((count / pagesize) + 1))
						pageNo++;
				} else {
					if (pageNo < (count / pagesize))
						pageNo++;
				}
			}
		}
		if (count % pagesize != 0)
			countPage = ((count / pagesize) + 1);
		else
			countPage = count / pagesize;

		session.put("countPage", countPage);
		session.put("pageNo", pageNo);
		ArrayList<Bookrecord> list=brde.showAllRecord(pageNo, pagesize);
		session.put("bookrecordlist",list);
		return "success";
	}
	
	

}
