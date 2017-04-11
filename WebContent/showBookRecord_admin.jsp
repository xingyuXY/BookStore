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
		<table width="80%" height="40px" align="center">
			<tr>
				<td align="left">Hi，${sessionScope.loginname }，欢迎来到一品书屋</td>
				<td align="right"><a href="invalidate.action">退出</a></td>
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
					<input type="text" name="bookname" placeholder="请输入要查询的用户名">
					<button class="ui orange button">搜索</button>
				</div>
			</form>
		</div>

		<div id="center" align="center">
		
			<table height="35px" width="90%" border="0" bgcolor="FF8C00">
				<tr>
					<td width="10%"><a href="signonadmin.action">管理用户</a></td>
					<td width="10%"><a href="bookadmin.action">管理图书</a></td>
					<td width="10%"><a href="showordersadmin.action">管理订单</a></td>
					<td width="10%"><a href="showbookrecord.action">管理留言</a></td>
					<td></td>
				</tr>
			</table>
			<br>
			<br>
			<table width="90%" class="table">
				<tr align="center">
					<td><br />
						<table width="90%">
							<tr align="center">
							    <td height="40px" width="10%">编号</td>
								<td width="20%">书名</td>
								<td width="15%">作者</td>
								<td width="25%">描述</td>
								<td width="15%">日期</td>
								<td width="10%">用户名</td>
							</tr>
						</table>
						<div class="ui divider"></div> <c:forEach var="b"
							items="${sessionScope.bookrecordlist}" varStatus="status">
							<table width="90%">
								<tr align="center">
								   <td height="30px" width="10%">${b.recordid}</td>
									<td  width="20%">${b.bookrecordname}</td>
									<td width="15%">${b.bookrecordauthor}</td>
									<td width="25%">${b.bookrecorddescn}</td>
									<td width="15%">${b.recorddate}</td>
									<td width="10%">${b.signon.username}</td>
								</tr>
							</table>
							<div class="ui divider"></div>
						</c:forEach> <br /></td>
				</tr>
			</table>	<br />
			<table border="0" align="center" width="300px">
			<tr>
				<td width="25%"><a href="showbookrecord.action?flag=up">上一页</a></td>
				<td width="25%"><a href="showbookrecord.action?flag=down"> 下一页 </a></td>
				<td width="25%">第 ${sessionScope.pageNo } 页</td>
				<td width="25%">共 ${sessionScope.countPage} 页</td>
			</tr>
		</table>
	
		</div> 
		
		<div id="footer"></div>
	</div>








</body>
</html>
