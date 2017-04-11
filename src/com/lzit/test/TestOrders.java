package com.lzit.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzit.dao.CartDao;
import com.lzit.dao.OrdersDao;
import com.lzit.dao.SignonDao;
import com.lzit.entity.Cart;
import com.lzit.service.OrdersService;

import junit.framework.TestCase;

public class TestOrders extends TestCase {
	
	public void testorders(){
		 BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
		 OrdersDao os= (OrdersDao) factory.getBean("ordersdao");
		 Date date=new Date();
		 SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		 String time=dt.format(date);
		/* ose.insertOrders(buydate, totalprice, "已支付", username);
			ArrayList<Cart> list=ccse.selectCart(username);
			for(Cart c:list){
				
			oise.insertOrderitem(c.getCartid(), c.getBook().getBookid(), 1);
			}*/
//		os.insertOrders(time, 134, "已支付", "xy", 2, 3);
	}

	

}
