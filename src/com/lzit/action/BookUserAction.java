package com.lzit.action;

import java.util.ArrayList;
import java.util.Map;

import com.lzit.entity.Book;
import com.lzit.service.BookService;
import com.lzit.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookUserAction extends ActionSupport {

	BookService bse = null;
	CategoryService cse = null;
	int catid;
	int bookid;
	String flag;
	int type;
	String bookname;

	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public BookService getBse() {
		return bse;
	}

	public void setBse(BookService bse) {
		this.bse = bse;
	}

	public CategoryService getCse() {
		return cse;
	}

	public void setCse(CategoryService cse) {
		this.cse = cse;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) bse.getAllBookCount();
		int pageNo = 1;
		int pagesize = 4;
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
		if (type == 1) {
			ArrayList<Book> list = bse.showAllBook(pageNo, pagesize);
			session.put("ubooklist", list);
		}
		if (type == 2) {
			ArrayList<Book> list = bse.checkBookBySellcount(pageNo, pagesize);

			session.put("ubooklist", list);
		}
		if (type == 3) {
			ArrayList<Book> list = bse.checkBookByPriceD(pageNo, pagesize);
			session.put("ubooklist", list);
		}
		if (type == 4) {
			ArrayList<Book> list = bse.checkBookByPriceA(pageNo, pagesize);
			session.put("ubooklist", list);
		}
		return super.execute();
	}

	public String categoryBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Book> list = bse.checkBookBycate(catid, 1, 4);
		session.put("ubooklist", list);
		return "success";
	}

	public String secondhandBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) bse.getSecondhandBookCount();
		int pageNo = 1;
		int pagesize = 4;
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
		ArrayList<Book> list = bse.selectSecondhandBook(pageNo, pagesize);
		session.put("ubooklist", list);
		return "success";
	}
	
	public String searchBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) bse.getSearchBookCount(bookname);
		int pageNo = 1;
		int pagesize = 4;
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
		ArrayList<Book> list =bse.searchBook(bookname, pageNo, pagesize);
		session.put("ubooklist", list);
		return "success";
	}

	public String topSecondhandBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Book> list = bse.selectTopSecondhandBook();
		session.put("topSecondhandBook", list);
		return "success";
	}

	public String topSellcountBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Book> list = bse.checkBookByTopSellcount();
		session.put("topSellcountBook", list);
		return "success";
	}

	public String bookInfo() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Book> list = bse.selectBook(bookid);
		session.put("bookInfo", list);
		return "success";
	}

	/*
	 * public String categoryCount() { ActionContext context =
	 * ActionContext.getContext(); Map session = context.getSession();
	 * ArrayList<Long> categoryCount = bse.categorycount(catid);
	 * session.put("categoryCount", categoryCount); return "success"; }
	 */
}
