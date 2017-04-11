package com.lzit.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext context = arg0.getInvocationContext();
		Map session = context.getSession();
		if (session.get("loginname") != null) {
			return arg0.invoke();
		} else
			return "login";
	}
}
