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

import com.lzit.dao.OrdersDao;
import com.lzit.entity.Address;
import com.lzit.entity.Book;
import com.lzit.entity.Cart;
import com.lzit.entity.Orderitem;
import com.lzit.entity.Orders;
import com.lzit.entity.Signon;

public class OrdersDaoImpl extends HibernateDaoSupport implements OrdersDao {


	public ArrayList<Orders> showOrders(String username) {
	HibernateTemplate ht=this.getHibernateTemplate();
	String hql="from Orders where username='"+username+"'";
	ArrayList<Orders> list=(ArrayList<Orders>) ht.find(hql);
		return list;
	}


	public void insertOrders(String buydate, double totalprice,
			String orderstate, String username,ArrayList<Cart> list) {
	HibernateTemplate ht=this.getHibernateTemplate();
	Orders orders=new Orders();
	Signon signon=(Signon) ht.get(Signon.class, username);
	orders.setBuydate(buydate);
	orders.setTotalprice(totalprice);
	orders.setOrderstate(orderstate);
	orders.setSignon(signon);
	ht.save(orders);
	for(Cart c:list){
	Orderitem orderitem = new Orderitem();
	orderitem.setOrdercount(c.getBuycount());
	orderitem.setBook(c.getBook());
	orderitem.setOrders(orders);
	ht.save(orderitem);		
	}
	
}
	@Override
	public void updateOrderstate(int orderid, String orderstate) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Orders orders=(Orders) ht.get(Orders.class, orderid);
		orders.setOrderstate("“— ’ªı");
		ht.update(orders);
	}


	@Override
	public ArrayList<Orders> showAllOrders(final int pageno, final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Orders";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Orders>) list;
	}


	@Override
	public long getAllOrdersCount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Orders";
		long count=ht.find(hql).size();
		return count;
	}
}
