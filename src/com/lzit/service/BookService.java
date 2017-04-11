package com.lzit.service;

import java.util.ArrayList;
import com.lzit.entity.Book;

public interface BookService {

	public ArrayList<Book> showAllBook(int pageno, int pagesize);

	public long getAllBookCount();

	public ArrayList<Book> checkBookBySellcount(int pageno, int pagesize);

	public ArrayList<Book> checkBookByPriceD(int pageno, int pagesize);

	public ArrayList<Book> checkBookByPriceA(int pageno, int pagesize);

	public ArrayList<Book> checkBookBycate(int catid, int pageno, int pagesize);

	public ArrayList<Book> searchBook(String bookname, int pageno, int pagesize);

	public ArrayList<Book> selectSecondhandBook(int pageno, int pagesize);

	public long getSearchBookCount(String bookname);

	public long getSecondhandBookCount();

	public void insertBook(String bookname, String author, double price, int inventory, String picture,
			String publishdate, int secondhand, int catid, String descn1, String descn2);

	public void deleteBook(int bookid);

	public ArrayList<Book> selectBook(int bookid);

	public ArrayList<Book> selectTopSecondhandBook();

	public ArrayList<Book> checkBookByTopSellcount();

	// public ArrayList<Long> categorycount(int catid);
	public void updateBook(int bookid,String author,double price,int inventory,
			String picture,String publishdate,int secondhand,int catid,
			String descn1,String descn2);
	
	public void updateBookInventory(int bookid,int buycount);

}
