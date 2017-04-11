package com.lzit.serviceImpl;

import java.util.ArrayList;

import com.lzit.dao.CategoryDao;
import com.lzit.entity.Category;
import com.lzit.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cdo=null;
	public CategoryDao getCdo() {
		return cdo;
	}
	public void setCdo(CategoryDao cdo) {
		this.cdo = cdo;
	}
	@Override
	public ArrayList<Category> showCategory() {	
		return cdo.showCategory();
	}
	
	/*public ArrayList<Category> selectCategory(String category) {
		return cdo.selectCategory(category);
	}*/

}
