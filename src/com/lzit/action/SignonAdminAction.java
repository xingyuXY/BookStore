package com.lzit.action;

import java.util.ArrayList;

import java.util.Map;

import com.lzit.entity.Book;
import com.lzit.entity.Signon;
import com.lzit.service.SignonService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SignonAdminAction extends ActionSupport {

	SignonService sse=null;
	String username;
	String flag;
	public SignonService getSse() {
		return sse;
	}
	public void setSse(SignonService sse) {
		this.sse = sse;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		int count = (int) sse.getAllSignonCount();
		int pageNo = 1;
		int pagesize = 10;
		int countPage;
		if (session.get("pageNo") == null) {
			pageNo = 1;
		} else {
			if ("up".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (pageNo > 1)
					pageNo--;
			} else if ("down".equals(flag)) {
				pageNo = (Integer) session.get("pageNo");
				if (count % pagesize != 0) {
					if (pageNo < ((count / pagesize) + 1))
						pageNo++;
				} else {
					if (pageNo < (count / pagesize))
						pageNo++;
				}
			}
		}
		if (count % pagesize != 0)
			countPage = ((count / pagesize) + 1);
		else
			countPage = count / pagesize;

		session.put("countPage", countPage);
		session.put("pageNo", pageNo);
		ArrayList<Signon> list=sse.showAllSignon(pageNo, pagesize);
		session.put("signonlist",list);	
		return super.execute();
	}

	public String deleteSignon(){
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		sse.deleteSignon(username);
		return "success";	 
	}
	
	public String updateSignon(){
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		sse.updateSignon(username);
		return "success";	 
	}
	

}
