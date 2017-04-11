<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="com.lzit.*" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>一品书屋</title>e</title>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/semantic.min.css" />
<script type="text/javascript" src="js/semantic.min.js">
	function checkUsername()//先定义
	{
		var name = document.getElementById("username");//获得元素
		var uname = name.value;//获得元素的值
		/* ArrayList<Signon> list=SignonServiceImpl.checkByName(uname);
		if(list.size()>0)
		   alert("用户名不能重复");//对话框
		} */
		if (uname.length == 0)
			alert("用户名不能为空");//对话框

	}
	function checkPassword() {
		var pwd = document.getElementById("password").value;

		for (var i = 0; i < pwd.length; i++) {
			if (!(pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z' || pwd.charAt(i) >= '0'
					&& pwd.charAt(i) <= '9'))

				alert("密码必须是a-z及0-9之间的字符");

		}

	}
</script>

<style>
body {
	font-size: 18px
}

.table {
	border: 1px solid #808080
}
</style>



</head>

<body>
<div class="head">
		<c:if test="${sessionScope.loginname ==null}">
		<table width="85%" height="40px" align="center"><tr><td align="left">
			<a href="login.jsp">请登录 </a>&nbsp;&nbsp;&nbsp;<a href="register.jsp">
				免费注册 </a></td></tr></table>
		</c:if>
		<c:if test="${sessionScope.loginname !=null}">
			<table width="85%" height="40px" align="center">
				<tr>
					<td width="50%" align="left">Hi，${sessionScope.loginname }，欢迎来到一品书屋</td>
					<td align="right"><a
						href="showcart.action?username=${sessionScope.loginname }">我的购物车</a>
						&nbsp;&nbsp;&nbsp;<a
						href="showorders.action?username=${sessionScope.loginname }">我的订单</a>
						&nbsp;&nbsp;&nbsp;<a href="bookRecord.jsp">我的留言</a>
						&nbsp;&nbsp;&nbsp;<a href="invalidate.action">退出</a>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
	<div class="con" align="center">
		<div class="header">
			<div class="logo">
				<img src="images/logo.png">
			</div>
			<form action="search.action" method="post">
				<div class="ui action input search"
					style="width: 60%; height: 40px;">
					<input type="text" name="bookname" placeholder="请输入要查询的书名">
					<button class="ui orange button">搜索</button>
				</div>
			</form>
		</div>


		<div class="login">
			<div class="logintable">
				<form action="register.action" method="post">
					<table bgcolor="#FFFFFF" height="320px" width="450px"
						align="center">
						<tr>
							<td colspan="2"><h2>账户注册</h2></td>
						</tr>

						<tr>
							<td width="150px" align="center">用户名</td>
							<td align="left"><div class="ui input">
									<input name="username" id="username" type="text"
										placeholder="请输入用户名" onblur="checkUsername()">
								</div></td>
						</tr>
						<tr>
							<td align="center">密码</td>
							<td><div class="ui input">
									<input name="password" id="password" type="password"
										placeholder="请输入密码" onblur="checkPassword()">
								</div></td>
						</tr>
						<tr>
							<td align="center">重新输入密码</td>
							<td><div class="ui input">
									<input name="repassword" type="password" placeholder="请重新输入密码">
								</div></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button
									class="ui orange button">注册</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer"></div>

	</div>
</body>
</html>


