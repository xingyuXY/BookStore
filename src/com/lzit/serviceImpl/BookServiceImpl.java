package com.lzit.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import com.lzit.dao.BookDao;
import com.lzit.entity.Book;
import com.lzit.service.BookService;

public class BookServiceImpl implements BookService {
	BookDao bdo=null;
	public BookDao getBdo() {
		return bdo;
	}
	public void setBdo(BookDao bdo) {
		this.bdo = bdo;
	}
	@Override
	public ArrayList<Book> showAllBook(int pageno,int pagesize) {
		return bdo.showAllBook(pageno, pagesize);
	}
	@Override
	public long getAllBookCount() {
		// TODO Auto-generated method stub
		return bdo.getAllBookCount();
	}
	
	@Override
	public void deleteBook(int bookid) {
		bdo.deleteBook(bookid);
	}
	@Override
	public ArrayList<Book> selectBook(int bookid) {
		// TODO Auto-generated method stub
		return bdo.selectBook(bookid);
	}
	
	@Override
	public ArrayList<Book> selectTopSecondhandBook() {
		return bdo.selectTopSecondhandBook();
	}
	@Override
	public ArrayList<Book> checkBookByTopSellcount() {
		// TODO Auto-generated method stub
		return bdo.checkBookByTopSellcount();
	}
	/*@Override
	public long categorycount(int catid) {
		
		return bdo.categorycount(catid);
	}*/
	@Override
	public void insertBook(String bookname, String author, double price, int inventory, String picture,
			String publishdate, int secondhand, int catid, String descn1, String descn2) {
		bdo.insertBook(bookname, author, price, inventory, picture, publishdate, secondhand, catid, descn1, descn2);
		
	}
	@Override
	public ArrayList<Book> checkBookBySellcount(int pageno, int pagesize) {
		return bdo.checkBookBySellcount(pageno, pagesize);
	}
	@Override
	public ArrayList<Book> checkBookByPriceD(int pageno, int pagesize) {
		return bdo.checkBookByPriceD(pageno, pagesize);
	}
	@Override
	public ArrayList<Book> checkBookByPriceA(int pageno, int pagesize) {
		return bdo.checkBookByPriceA(pageno, pagesize);
	}
	@Override
	public ArrayList<Book> checkBookBycate(int catid, int pageno, int pagesize) {
		return bdo.checkBookBycate(catid, pageno, pagesize);
	}
	@Override
	public ArrayList<Book> searchBook(String bookname, int pageno, int pagesize) {
		return bdo.searchBook(bookname, pageno, pagesize);
	}
	@Override
	public ArrayList<Book> selectSecondhandBook(int pageno, int pagesize) {
		return bdo.selectSecondhandBook(pageno, pagesize);
	}
	@Override
	public long getSearchBookCount(String bookname) {
		return bdo.getSearchBookCount(bookname);
	}
	@Override
	public long getSecondhandBookCount() {
		return bdo.getSecondhandBookCount();
	}
	@Override
	public void updateBook(int bookid, String author, double price, int inventory, String picture, String publishdate,
			int secondhand, int catid, String descn1, String descn2) {
		bdo.updateBook(bookid, author, price, inventory, picture, publishdate, secondhand,
				catid, descn1, descn2);
		
	}
	@Override
	public void updateBookInventory(int bookid,  int buycount) {
		bdo.updateBookInventory(bookid, buycount);
		
	}

	
	

}
