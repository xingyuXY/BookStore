package com.lzit.action;

import java.util.ArrayList;

import java.util.Date;
import java.util.Map;

import com.lzit.entity.Book;
import com.lzit.entity.Category;
import com.lzit.service.BookService;
import com.lzit.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAdminAction extends ActionSupport implements ModelDriven<Book> {

	BookService bse = null;
	CategoryService cse = null;
	private Book book = new Book();
	String secondhandbook;
	String bookcategory;
	String flag;
	int bookid;
	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public CategoryService getCse() {
		return cse;
	}

	public void setCse(CategoryService cse) {
		this.cse = cse;
	}

	public Book getModel() {
		return book;
	}

	public BookService getBse() {
		return bse;
	}

	public void setBse(BookService bse) {
		this.bse = bse;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getSecondhandbook() {
		return secondhandbook;
	}

	public void setSecondhandbook(String secondhandbook) {
		this.secondhandbook = secondhandbook;
	}

	public String getBookcategory() {
		return bookcategory;
	}

	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}

	public String execute() throws Exception {

		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) bse.getAllBookCount();
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
		ArrayList<Book> list = bse.showAllBook(pageNo, pagesize);
		session.put("ubooklist", list);
		return super.execute();
	}

	public String insertBook() {

		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int secondhand = 0;
		int catid = 0;
		if ("ÊÇ".equals(secondhandbook)) {
			secondhand = 2;
		} else {
			secondhand = 1;
		}
		ArrayList<Category> list = cse.showCategory();
		if (list.size() > 1) {
			for (Category c : list) {
				if (c.getCategory().equals(bookcategory))
					catid = c.getCatid();
			}
		}
		bse.insertBook(book.getBookname(), book.getAuthor(), book.getPrice(), book.getInventory(),
				"images/"+book.getPicture(),
				book.getPublishdate(), secondhand, catid, book.getDescn1(), book.getDescn2());
		return "success";
	}

	public String deleteBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		bse.deleteBook(book.getBookid());
		return "success";
	}
	
	
	public String chooseUpdateBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Book> list = bse.selectBook(book.getBookid());
		session.put("abooklist", list);
		return "success";
	}
	
	public String updateBook() {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int secondhand = 0;
		int catid = 0;
		if ("ÊÇ".equals(secondhandbook)) {
			secondhand = 2;
		} else {
			secondhand = 1;
		}
		ArrayList<Category> list = cse.showCategory();
		if (list.size() > 1) {
			for (Category c : list) {
				if (c.getCategory().equals(bookcategory))
					catid = c.getCatid();
			}
		}
		bse.updateBook(book.getBookid(), book.getAuthor(), book.getPrice(), book.getInventory(),
				"images/"+book.getPicture(), book.getPublishdate(), secondhand, catid, 
				book.getDescn1(), book.getDescn2());
		return "success";
	}

	


}
