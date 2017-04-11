package com.lzit.daoImpl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.CategoryDao;
import com.lzit.entity.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
	@Override
	public ArrayList<Category> showCategory() {
		HibernateTemplate ht = this.getHibernateTemplate();
		String hql = "from Category";
		ArrayList<Category> list = (ArrayList<Category>) ht.find(hql);
		return list;
	}

	/*
	 * public ArrayList<Category> selectCategory(String category) {
	 * HibernateTemplate ht=this.getHibernateTemplate(); String hql=
	 * "from Category where category='"+category+"'"; ArrayList<Category>
	 * list=(ArrayList<Category>) ht.find(hql); return list; }
	 */

}
