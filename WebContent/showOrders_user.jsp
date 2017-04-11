<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>一品书屋</title>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/semantic.min.css" />
<script type="text/javascript" src="js/semantic.min.js"></script>
<style>
body{
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
<div id="center" align="center">
<br/><br/>
		<div class="h1">我的订单</div>
			<br />
			<br>
			<table width="90%" align="center" class="table"><tr><td>
			<table width="85%" align="center" >
				<tr height="80px" align="center">
					<td width="15%">订单号</td>
					<td width="20%">书名</td>
					<td width="10%">单价（元 ）</td>
					<td width="10%">数量</td>
					<td width="15%">总价</td>
					<td width="15%">购买日期</td>
					<td width="15%">状态</td> 
				</tr>
					<tr><td colspan="7"><div class="ui divider"></div><td></tr>
			<c:forEach var="o" items="${sessionScope.orderslist }" varStatus="status">
			
					<tr height="50px" align="center">
						<td width="15%"> ${o.orderid }</td>
						
						<td colspan="3">
						<table width="100%"  >
						<c:forEach var="oi" items="${o.orderitem }" varStatus="status1">
						<tr align="center" height="30px"><td width="48%">${oi.book.bookname}</td>
						<td width="29%">${oi.book.price}</td>
						<td >${oi.ordercount}</td></tr>
						</c:forEach>
						</table>
			                 </td>
							
						<td width="15%">${o.totalprice}</td>
						<td width="15%">${o.buydate}</td>
						<td width="15%">${o.orderstate}</td>
					</tr>
					<tr><td colspan="7"><div class="ui divider"></div><td></tr>
					
				</c:forEach>
			</table>
</td></tr></table>


</div>
<div id="footer">
</div>
</div>








</body>
</html>
