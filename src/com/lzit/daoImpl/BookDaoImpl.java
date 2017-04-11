package com.lzit.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.BookDao;
import com.lzit.entity.Book;
import com.lzit.entity.Category;
import com.lzit.entity.Signon;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {
	public ArrayList<Book> showAllBook(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}
	
	@Override
	public long getAllBookCount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book";
		long count=ht.find(hql).size();
		return count;
	}

	public ArrayList<Book> checkBookBySellcount(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b order by b.sellcount desc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	public ArrayList<Book> checkBookByPriceD(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b order by b.price desc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	public ArrayList<Book> checkBookByPriceA(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b order by b.price asc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	public ArrayList<Book> checkBookBycate(int catid,final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where catid=" + catid + "";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	/*
	 * public ArrayList<Book> categorycount(int catid) { HibernateTemplate
	 * ht=this.getHibernateTemplate(); String hql=
	 * "select catid,count(*) from Book b where catid="+catid+"";
	 * ArrayList<Book> list=(ArrayList<Book>) ht.find(hql); return list; }
	 */

	/*
	 * public ArrayList<Integer> categorycount(int catid) { HibernateTemplate
	 * ht=this.getHibernateTemplate(); String hql="from Book b where b.catid="
	 * +catid+""; ArrayList<Integer> list=(ArrayList<Integer>)ht.find(hql);
	 * return list; }
	 */

	public ArrayList<Book> searchBook(String bookname,final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where b.bookname like '%" + bookname + "%'";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}
	
	@Override
	public long getSearchBookCount(String bookname) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where b.bookname like '%" + bookname + "%'";
		long count=ht.find(hql).size();
		return count;
	}

	@Override
	public long getSecondhandBookCount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where b.secondhand=" + 2 + "";
		long count=ht.find(hql).size();
		return count;
	}

	public void insertBook(String bookname,String author,double price,int inventory,
			String picture,String publishdate,int secondhand,int catid,
			String descn1,String descn2) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Book book = new Book();
		Category cate = (Category) ht.get(Category.class, catid);
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setPrice(price);
		book.setInventory(inventory);
		book.setPicture(picture);
		book.setPublishdate(publishdate);
		book.setSecondhand(secondhand);
		book.setSellcount(0);
		book.setDescn1(descn1);
		book.setDescn2(descn2);
		book.setCategory(cate);
		ht.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Book book = (Book) ht.get(Book.class, bookid);
		ht.delete(book);
	}

	@Override
	public ArrayList<Book> selectBook(int bookid) {
		HibernateTemplate ht = this.getHibernateTemplate();
		String hql = "from Book b where b.bookid=" + bookid + "";
		ArrayList<Book> list = (ArrayList<Book>) ht.find(hql);
		return list;
	}

	@Override
	public ArrayList<Book> selectTopSecondhandBook() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where b.secondhand=" + 2 + " order by b.sellcount desc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(0);
				query.setMaxResults(3);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	@Override
	public ArrayList<Book> checkBookByTopSellcount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b order by b.sellcount desc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(0);
				query.setMaxResults(3);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;

	}

	@Override
	public ArrayList<Book> selectSecondhandBook(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Book b where b.secondhand=" + 2 + "";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(0);
				query.setMaxResults(3);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Book>) list;
	}

	@Override
	public void updateBook(int bookid, String author, double price, int inventory, String picture, 
			String publishdate,int secondhand, int catid, String descn1, String descn2) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Book book=(Book) ht.get(Book.class, bookid);
		Category cate = (Category) ht.get(Category.class, catid);
		book.setAuthor(author);
		book.setPrice(price);
		book.setInventory(inventory);
		book.setPicture(picture);
		book.setPublishdate(publishdate);
		book.setSecondhand(secondhand);
		book.setCategory(cate);
		book.setDescn1(descn1);
		book.setDescn2(descn2);
	    ht.update(book);
	}

	@Override
	public void updateBookInventory(int bookid, int buycount) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Book book=(Book) ht.get(Book.class, bookid);
		book.setInventory(book.getInventory()-buycount);
		book.setSellcount(book.getSellcount()+buycount);
		ht.update(book);
		
	}

	


	

}
