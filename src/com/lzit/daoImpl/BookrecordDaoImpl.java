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

import com.lzit.dao.BookrecordDao;
import com.lzit.entity.Book;
import com.lzit.entity.Bookrecord;
import com.lzit.entity.Category;
import com.lzit.entity.Signon;

public class BookrecordDaoImpl extends HibernateDaoSupport implements BookrecordDao{

	@Override
	public ArrayList<Bookrecord> showRecordByUser(String username) {
		HibernateTemplate ht = this.getHibernateTemplate();
		String hql = "from Bookrecord b where username='"+username+"'";
		ArrayList<Bookrecord> list = (ArrayList<Bookrecord>) ht.find(hql);
		return list;
	}

	@Override
	public ArrayList<Bookrecord> showAllRecord(final int pageno, final int pagesize) {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Bookrecord";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno-1)*pagesize);
				query.setMaxResults(pagesize);
				List list = query.list();
				return list;
			}
		});
		return (ArrayList<Bookrecord>) list;
	}

	@Override
	public void insertBookrecord(String bookrecordname, String bookrecordauthor, String bookrecorddescn,
			String recorddate, String username) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Bookrecord bookrecord=new Bookrecord();
		Signon signon = (Signon) ht.get(Signon.class, username);
		bookrecord.setBookrecordname(bookrecordname);
		bookrecord.setBookrecordauthor(bookrecordauthor);
		bookrecord.setBookrecorddescn(bookrecorddescn);
		bookrecord.setRecorddate(recorddate);
		bookrecord.setSignon(signon);
		ht.save(bookrecord);
	}

	@Override
	public long getAllBookRecordCount() {
		HibernateTemplate ht = this.getHibernateTemplate();
		final String hql = "from Bookrecord";
		long count=ht.find(hql).size();
		return count;
	}

}
