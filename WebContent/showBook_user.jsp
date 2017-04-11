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

			<table height="35px" width="90%" border="0" bgcolor="#FF8C00">
				<tr>
					<td width="15%"><a href="showbook.action?type=1">查看全部图书</a></td>
					<td width="15%"><a href="secondhandBook.action">查看二手书</a></td>
					<td width="15%"><a href="showbook.action?type=2">销量从高到低</a></td>
					<td width="15%"><a href="showbook.action?type=3">价格从高到低</a></td>
					<td width="15%"><a href="showbook.action?type=4">价格从低到高</a></td>
					<td></td>
			</table>
			<br /> <br />
			<div class="leftside_showbook" align="center">
				<p class="h1">图书种类</p>

				<s:action name="category"></s:action>
				<%-- 	<s:action name="categoryCount"></s:action> --%>
				<table width="200px" height="400px" >
					<c:forEach var="cat" items="${sessionScope.catelist }"
						varStatus="status">

						<tr>
							<td>
									<a class="linksize"
										href="categorybook.action?catid=${cat.catid}">
										${cat.category} <%-- (${sessionScope.categoryCount}) --%>
									</a>
								</td>
						</tr>
					</c:forEach>

				</table>

			</div>
			<div id="rightside1" >
			<table  width="800px" align="center" class="table"><tr><td align="center"><br/>
				<c:forEach var="b" items="${sessionScope.ubooklist }"
					varStatus="status">
					
					<table height="140px" width="700px" >
						<tr>
							<td rowspan="4" width="140px"><a href="bookInfo.action?bookid=${b.bookid}"><img
									src="${b.picture }" height="140px" width="100px" /></a></td>
							<td >${b.bookname}
							<c:if test="${b.secondhand ==2}">
							<td width="100px"><p class="h1">(二手书)</p></td>
							
							</c:if>
							</td>
						</tr>
						<tr>
							<td>${b.author}&nbsp;著；&nbsp;/&nbsp;${b.descn1}</td>
						</tr>
						<tr>
							<td >销量:${b.sellcount}</td>
			
						</tr>
						<tr>
							<td >￥${b.price}&nbsp;&nbsp; 
							<a href="addcart.action?bookid=${b.bookid}">
							<button class="ui orange button">加入购物车</button></a></td>
						</tr>
					</table>
					<br />
					<div class="ui divider"></div>
				</c:forEach>
				<br />
				<br />
				<table border="0" align="center" width="300px">
					<tr>
						<td width="25%"><a href="showbook.action?flag=up">上一页</a></td>
						<td width="25%"><a href="showbook.action?flag=down"> 下一页 </a>
						</td>
						<td width="25%">第 ${sessionScope.pageNo } 页</td>
						<td width="25%">共 ${sessionScope.countPage} 页</td>
					</tr>

				</table>

     </td></tr></table>

			</div>

		</div>
		<div id="footer"></div>
	</div>








</body>
</html>
