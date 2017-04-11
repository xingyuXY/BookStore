package com.lzit.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzit.dao.CartDao;
import com.lzit.dao.SignonDao;
import com.lzit.service.OrdersService;

import junit.framework.TestCase;

public class TestCart extends TestCase {
	public void testcart(){
		 BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
		CartDao cd=(CartDao) factory.getBean("cartdao");
		cd.deletecartbyusername("user");
	}
	
	public void testorders(){
		 BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
		 OrdersService os=(OrdersService) factory.getBean("ordersservice");
	/*	 Date date=new Date();
		 SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");
		 String time=dt.format(date);*/
		 System.out.println(new Date()+"<<<<<<<<<<<<<<<<<");
//		os.insertOrders("", 120, "ÒÑÖ§¸¶", "user");
	}

	private Date to_days(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public void testSignon(){
		 BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
		SignonDao cd =(SignonDao) factory.getBean("signondao");
		  long c=cd.getAllSignonCount();
		  System.out.println(c+">>>>>>>>>>>>>>>>>>");
	}

}
