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

.order table {
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
			<div class="h1">确认地址信息</div>
			<br /> 
			<table height="80px" width="80%" border="1" >
				<c:forEach var="b" items="${sessionScope.addresslist }"
					varStatus="status">
					<tr align="center">
						<td>${b.address }&nbsp;&nbsp; ${b.name}(收) &nbsp;&nbsp;电话： ${b.phone}</td>
						<td><a href="updateAddress.jsp">修改地址</a></td>
					</tr>
				</c:forEach>
			</table><br/><br/>
	
			<div class="h1">确认订单信息</div>
			<br/>

			<table width="80%" align="center" >
				<tr height="80px" align="center">
					<td colspan="2" width="40%">图书信息</td>
					<td width="15%">单价（元）</td>
					<td width="15%">数量</td>
					<td width="15%">金额（元）</td>
					<td width="15%">操作</td>
				</tr>
				<c:forEach var="cart" items="${sessionScope.cartlist}"
					varStatus="status">
					<tr height="80px" align="center">
						<td width="10%" align="right"><img src="${cart.book.picture}"
							height="70px" width="40px"></td>
						<td width="30%" align="left">书名：${cart.book.bookname}<br />作者：${cart.book.author}
						</td>
						<td>${cart.book.price}</td>
						<td>${cart.buycount}</td>
						<td>${cart.book.price*cart.buycount}</td>
						<td><a href="deletecart.action?cartid=${cart.cartid}">删除</a></td>
					</tr>
				</c:forEach>

				<tr height="35px">
					<td colspan="6" align="right"><h3>总价：${sessionScope.totalprice}元</h3></td>
				</tr>

			</table>
			<br/><br/>
			
			
				<div><a href="insertOrder.action?username=${sessionScope.loginname }">
				<button class="ui orange button">确定</button></a>
				</div>
			

			

			
						
			
		</div>
		<div id="footer"></div>
	</div>








</body>
</html>
