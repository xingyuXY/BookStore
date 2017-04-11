package com.lzit.daoImpl;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.OrderitemDao;
import com.lzit.entity.Book;
import com.lzit.entity.Orderitem;
import com.lzit.entity.Orders;
import com.lzit.entity.Signon;

public class OrderitemDaoImpl extends HibernateDaoSupport implements OrderitemDao {

	@Override
	public void insertOrderitem(int ordercount, int bookid, int orderid) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Orderitem orderitem = new Orderitem();
		
		Book book = (Book) ht.get(Book.class, bookid);
		Orders orders = (Orders) ht.get(Orders.class, orderid);
		orderitem.setOrdercount(ordercount);
		orderitem.setBook(book);
		orderitem.setOrders(orders);
		
		ht.save(orderitem);

	}

}
