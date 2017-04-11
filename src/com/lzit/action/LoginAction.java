package com.lzit.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lzit.entity.Signon;
import com.lzit.service.SignonService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	String username;
	String password;

	SignonService sse = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SignonService getSse() {
		return sse;
	}

	public void setSse(SignonService sse) {
		this.sse = sse;
	}

	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		if (sse.checkBySignon(username, password)) {
			session.put("loginname", username);
			ArrayList<Signon> list = sse.checkByName(username);
			int role = 0;
			for (Signon signon : list) {
				role = signon.getRole();
			}
			if (role == 1){
				return "admin";}
			else
				return "user";
		}
		else
			return "error";
	}

	public String register() {
		sse.insertSignon(username, password);
		return "success";
	}

	public String invalidate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginname");
//		session.invalidate();
		return "success";
	}

}
