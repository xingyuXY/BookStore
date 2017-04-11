<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						&nbsp;&nbsp;&nbsp;<a href="bookrecord.action">我的留言</a>
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

		<div id="center">
			<table height="35px" width="90%" border="0" bgcolor="#99FFFF">
				<tr>
					<td width="15%"><a href="allbook.action">查看全部图书</a></td>
					<td width="15%"><a href="secondhandBook.action">查看二手书</a></td>
					<td width="15%"><a href="sellcount.action">销量从高到低</a></td>
					<td width="15%"><a href="dprice.action">价格从高到低</a></td>
					<td width="15%"><a href="aprice.action">价格从低到高</a></td>
					<td></td>
			</table>
			<br /> <br />
			<c:forEach var="b" items="${sessionScope.bookInfo }"
				varStatus="status">

				<table height="240px" width="80%">
					<tr>
						<td rowspan="5" width="240px"><img
								src="${b.picture }" height="240px" width="200px" /></td>
						<td><p font-size="20px"><strong>${b.bookname}</strong></p></h3></td>
					</tr>
					<tr>
						<td>作者:${b.author}&nbsp;&nbsp;&nbsp;&nbsp;
						            出版社:${b.descn1 }&nbsp;&nbsp;&nbsp;&nbsp;
						           出版时间:${b.publishdate}</td>
					</tr>
					<tr>
						<td>销量:${b.sellcount}&nbsp;&nbsp;&nbsp;&nbsp;
						           库存:${b.inventory }</td>

					</tr>
					<tr>
						<td><p class="h1">￥${b.price}</p>
						</td></tr>
						<tr>
						<td>
							<a href="addcart.action?bookid=${b.bookid}">
							<button class="ui orange button">加入购物车</button></a>
						</td>
					</tr>
				</table>

				<div class="ui divider"></div>
				<br />

			
			<table width="80%" >
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${b.descn2}<br/><br/></td></tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${b.descn3 }<br/><br/></td></tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${b.descn4 }</td></tr>
			</table>

      </c:forEach>


		</div>
		<div id="footer"></div>
	</div>








</body>
</html>
