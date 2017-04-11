<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>一品书屋</title>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/semantic.min.css" />
<script type="text/javascript" src="js/semantic.min.js"></script>
<style>
body {
	font-size: 18px
}

.table {
	border: 1px solid #000
}
</style>
</head>
<body>
	<div class="head">
			<table width="85%" height="40px" align="center">
				<tr>
					<td width="50%" align="left">Hi，${sessionScope.loginname }，欢迎来到一品书屋</td>
					<td align="right"><a
						href="showcart.action?username=${sessionScope.loginname }">我的购物车</a>
						&nbsp;&nbsp;&nbsp;<a
						href="showorders.action?username=${sessionScope.loginname }">我的订单</a>
						&nbsp;&nbsp;&nbsp;<a href="bookrecord.action">我的留言</a>
						&nbsp;&nbsp;&nbsp;<a href="invalidate.action">退出</a>
					</td>
				</tr>
			</table>
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

		<div id="center" align="center" class="order">
			<br /> <br />
			
			<div class="h1">缺书留言</div>
			<br/>

			<table width="90%" class="table">
				<tr align="center">
					<td><br />
						<table width="80%">
							<tr align="center">
							    <td height="40px" width="20%">编号</td>
								<td width="20%">书名</td>
								<td width="20%">作者</td>
								<td width="20%">描述</td>
								<td width="20%">日期</td>
				
							</tr>
						</table>
						<%int i=0; %>
						<div class="ui divider"></div> <c:forEach var="br"
							items="${sessionScope.bookrecordlist}" varStatus="status">
							<table width="80%">
								<tr align="center">
								   <td height="30px" width="20%"><%=i+1 %></td>
									<td  width="20%">${br.bookrecordname}</td>
									<td width="20%">${br.bookrecordauthor}</td>
									<td width="20%">${br.bookrecorddescn}</td>
									<td width="20%">${br.recorddate}</td>
									
								</tr>
							</table>
							<div class="ui divider"></div>
							<%i++; %> 
						</c:forEach> <br /></td>
				</tr>
			</table>
			<br/><br/>
		
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
