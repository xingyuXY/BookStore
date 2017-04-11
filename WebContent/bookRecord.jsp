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
	border: 1px solid #808080
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
					&nbsp;&nbsp;&nbsp;<a href="invalidate.action">退出</a></td>
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
			<div class="addaddress"><br/>
				<p class="h1">添加缺书留言</p><br/>
				<form action="insertbookrecord.action" method="post">
					<table width="60%" height="350px" class="table">
						<tr align="center">
							<td>
								<table width="70%" height="300px">
									<tr>
										<td align="center">图书：</td>
										<td><input type="text" name="bookrecordname" size="30"/></td>
									</tr>
									<tr>
										<td align="center">作者：</td>
										<td><input type="text" name="bookrecordauthor" size="30"/></td>
									</tr>
									<tr>
										<td align="center">描述：</td>
										<td><textarea name="bookrecorddescn" rows="3" cols="30" ></textarea></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><button
												class="ui orange button">确定</button></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					</form>
			</div>
			



		</div>
	</div>
	<div id="footer"></div>









</body>
</html>
