package com.lzit.action;

import java.util.ArrayList;
import java.util.Map;

import com.lzit.entity.Category;
import com.lzit.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {

	CategoryService cse = null;
	String category;
	public CategoryService getCse() {
		return cse;
	}
	public void setCse(CategoryService cse) {
		this.cse = cse;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ArrayList<Category> list = cse.showCategory();
		session.put("catelist", list);
		return super.execute();
	}

	/*
	 * public String cateBook() { ActionContext
	 * context=ActionContext.getContext(); Map session=context.getSession();
	 * ArrayList<Category> list=cse.selectCategory(category);
	 * session.put("catebooklist", list);
	 * 
	 * return "success"; }
	 */

}
