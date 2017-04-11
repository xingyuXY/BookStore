package com.lzit.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.SignonDao;
import com.lzit.entity.Book;
import com.lzit.entity.Cart;
import com.lzit.entity.Signon;

public class SignonDaoImpl extends HibernateDaoSupport implements SignonDao {
	public ArrayList<Signon> checkByName(String username) {
		 HibernateTemplate ht=this.getHibernateTemplate();
		 String hql="from Signon s where username='"+username+"'";
		 ArrayList<Signon> list=(ArrayList<Signon>) ht.find(hql);
		 return list;
	}
	
	public ArrayList<Signon> checkBySignon(String username, String password) {
		HibernateTemplate ht=this.getHibernateTemplate();
		String hql="from Signon s where username='"+username+"' and password='"+password+"'";
		ArrayList<Signon> list=(ArrayList<Signon>) ht.find(hql);
		return list;
	}



	
	public void insertSignon(String username, String password) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Signon signon=new Signon();
		signon.setUsername(username);
		signon.setPassword(password);
		signon.setRole(2);
		
		ht.save(signon);
		
	}

	
	public ArrayList<Signon> showAllSignon(final int pageno,final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Signon";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Signon>) list;
	}

	@Override
	public void deleteSignon(String username) {
		HibernateTemplate ht=this.getHibernateTemplate();
	    Signon signon=(Signon) ht.get(Signon.class, username); 
		ht.delete(signon);	
	}

	@Override
	public void updateSignon(String username) {
		HibernateTemplate ht=this.getHibernateTemplate();
	    Signon signon=(Signon) ht.get(Signon.class, username);
	    if(signon.getRole()==1){
	    	signon.setRole(2);
	    }
	    else if(signon.getRole()==2){
	    	signon.setRole(1);
	    }
	    ht.update(signon);	
	}

	@Override
	public long getAllSignonCount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Signon";
		long count=ht.find(hql).size();
		return count;
	}	
}
