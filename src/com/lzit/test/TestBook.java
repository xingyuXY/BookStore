package com.lzit.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzit.dao.BookDao;
import com.lzit.dao.CartDao;
import com.lzit.entity.Book;
import com.lzit.entity.Cart;
import com.lzit.entity.Category;
import com.lzit.entity.Signon;
import com.lzit.service.BookService;
import com.lzit.service.CategoryService;
import com.lzit.service.SignonService;

public class TestBook extends TestCase {
	
	/*public void testsignon()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  
  	  SignonService ss=(SignonService) factory.getBean("signonservice");
  	  //ArrayList<Signon> list=ss.checkByName("tom");
  	  ArrayList<Signon> list=ss.showAllSignon();
  	  for(Signon s:list)
  	  {
  		System.out.println(s.getUsername());
  	   System.out.println(s.getPassword());
  	  }
	 }
	*/
	
	public void testCategory()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  
  	  CategoryService cs=(CategoryService) factory.getBean("categoryservice");
  	  ArrayList<Category> list=cs.showCategory();
  	  for(Category c:list)
  	  {
  		  System.out.println(c.getCategory());
  		  
  	  }
    }
  	  
  	  
  	public void testBook()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  
  	  BookService bs=(BookService) factory.getBean("bookservice");
  	  
  	  ArrayList<Book> list=bs.showAllBook(1,2);
  	  for(Book b:list)
  	  {
  		  System.out.println(b.getBookid());
  		  System.out.println(b.getBookname());
  		  System.out.println(b.getAuthor());
  		  System.out.println(b.getPrice()); 
  	  }
    }
  	
  	/*public void testinsertBook()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  BookService bs=(BookService) factory.getBean("bookservice");
  	  bs.insertBook("西游记", "吴承恩", 58.8, 34, "buzgidao", "ff","",1);
  	  
    }*/
	public void testdeteleBook()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  BookService bs=(BookService) factory.getBean("bookservice");
  	  bs.deleteBook(1003);
  	  
    }


	private Date to_days(String string) {
		// TODO Auto-generated method stub
		return null;
	} 
  	  
  	
	  
  	public void testcart()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  CartDao cs=(CartDao) factory.getBean("cartdao");
  	 // CartService cs=(CartService) factory.getBean("cartservice");
  	  ArrayList<Cart> list=cs.selectCart("tom");
  	  for(Cart c:list)
  	  {
  		
  		System.out.println(c.getCartid());
  		System.out.println(c.getBuycount());
  		System.out.println(c.getBook().getBookname());
  		System.out.println(c.getBook().getBookid());
  	
  		System.out.println(c.getSignon().getUsername());
  		  
  		  
  	  }
    }
  	
  	
	public void testdecart()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  CartDao cs=(CartDao) factory.getBean("cartdao");
  	  cs.deletecart(2);
    }  
  	  
  	  
	  
  	public void testcategory()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  CategoryService cs=(CategoryService) factory.getBean("categoryservice");
  	  /*ArrayList<Category> list=cs.selectCategory("文学");
  	  for(Category c:list)
  	  {
  		  System.out.println(c.getCatid());
  		  System.out.println(c.getBook());  
  	  }*/
    }
  	
  	/*public void testbookcat()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
      BookService bs=(BookService) factory.getBean("bookservice");
  	  ArrayList<Book> list=bs.checkBookBycate(1);
  	  for(Book b:list)
  	  {
  		  System.out.println(b.getBookname());
  		  System.out.println(b.getCategory().getCategory());  
  	  }
    }*/
  	
	public void testcategorycount()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
      BookDao bs=(BookDao) factory.getBean("bookdao");
  	  //ArrayList<Book> list=bs.categorycount(1);
  	/*  for(Book b:list)
  	  {
  		  System.out.println(b.getCategory().getCategory());
  		  System.out.println();  
  	  }*/
    }
  	  
	public void testaddcart()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  CartDao cs=(CartDao) factory.getBean("cartdao");
  	  cs.insertcart(1,"tom",1);
    } 
	
	public void testaddcartcount()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  CartDao cs=(CartDao) factory.getBean("cartdao");
  	  cs.updatecart(4, 6);
    } 
	
	
	public void testDeleteSignon()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  SignonService cs= (SignonService) factory.getBean("signonservice");
  	  cs.deleteSignon("jack");
    } 
  	  
	public void testUpdateSignon()
    {
  	  BeanFactory factory=new ClassPathXmlApplicationContext("a*.xml");
  	  SignonService cs= (SignonService) factory.getBean("signonservice");
  	  cs.updateSignon("tom");
    }


}
