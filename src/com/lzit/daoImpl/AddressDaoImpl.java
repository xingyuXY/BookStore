package com.lzit.daoImpl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzit.dao.AddressDao;
import com.lzit.entity.Address;
import com.lzit.entity.Signon;

public class AddressDaoImpl extends HibernateDaoSupport implements AddressDao {

	
	public void insertAddress(String name, String phone, String zip,
			String address, String username) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Address add=new Address();
		Signon signon=(Signon) ht.get(Signon.class, username);
		add.setName(name);
		add.setPhone(phone);
		add.setZip(zip);
		add.setAddress(address);
		add.setSignon(signon);
		ht.save(add);
		
	}

	public ArrayList<Address> selectAddress(String username) {
		HibernateTemplate ht=this.getHibernateTemplate();
		String hql="from Address a where username='"+username+"'";
		ArrayList<Address> list=(ArrayList<Address>) ht.find(hql);
		return list;
	}

	@Override
	public void updateAddress(String name, String phone, String zip, String address,int addid) {
		HibernateTemplate ht=this.getHibernateTemplate();
		Address add = (Address) ht.get(Address.class, addid);
	   add.setName(name);
	   add.setPhone(phone);
	   add.setZip(zip);
	   add.setAddress(address);
	   ht.update(add);		
	}
}
