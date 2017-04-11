package com.lzit.daoImpl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.CartDao;
import com.lzit.entity.Book;
import com.lzit.entity.Cart;
import com.lzit.entity.Signon;

public class CartDaoImpl extends HibernateDaoSupport implements CartDao {
	public ArrayList<Cart> selectCart(String username) {
		HibernateTemplate ht = this.getHibernateTemplate();
		String hql = "from Cart c where username='" + username + "'";
		ArrayList<Cart> list = (ArrayList<Cart>) ht.find(hql);
		return list;
	}
	public void insertcart(int buycount, String username, int bookid) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Cart cart = new Cart();
		Signon signon = (Signon) ht.get(Signon.class, username);
		Book book = (Book) ht.get(Book.class, bookid);
		cart.setBuycount(buycount);
		cart.setSignon(signon);
		cart.setBook(book);
		ht.save(cart);
	}

	public void updatecart(int buycount, int cartid) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Cart cart = (Cart) ht.get(Cart.class, cartid);
		cart.setBuycount(cart.getBuycount() + buycount);
		ht.update(cart);

	}

	public void deletecart(int cartid) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Cart cart = (Cart) ht.get(Cart.class, cartid);
		ht.delete(cart);

	}

	@Override
	public void deletecartbyusername(String username) {
		HibernateTemplate ht = this.getHibernateTemplate();
		String hql = "from Cart where username='" + username + "'";
		ArrayList<Cart> list = (ArrayList<Cart>) ht.find(hql);
		System.out.println("<<<<<<<<<<<<"+list.size());
		for(Cart c:list){
			Cart cart = (Cart) ht.get(Cart.class, c.getCartid());
			ht.delete(cart);
		}
	
	
	}

}
