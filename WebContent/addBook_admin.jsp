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
<script type="text/javascript" src="js/semantic.min.js">
</script>
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
				
				<br />

				<p class="h1">添加图书</p>
				<form action="insertbookadmin.action" method="post">
					<table width="70%" height="750px" class="table">
						<tr align="center">
							<td>
								<table width="80%" height="700px">
									<tr>
										<td align="center">书名：</td>
										<td><input type="text" name="bookname" size="40" /></td>
									</tr>
									<tr>
										<td align="center">作者：</td>
										<td><input type="text" name="author" size="40" /></td>
									</tr>
									<tr>
										<td align="center">价格：</td>
										<td><input type="text" name="price" size="40" /></td>
									</tr>
									<tr>
										<td align="center">库存：</td>
										<td><input type="text" name="inventory" size="40" /></td>
									</tr>
									<tr>
										<td align="center">出版社：</td>
										<td><input type="text" name="descn1" size="40" /></td>
									</tr>
									<tr>
										<td align="center">出版时间：</td>
										<td><input type="text" name="publishdate" size="40" /></td>
									</tr>
									 <tr>
										<td align="center">是否二手书：</td>
										<td><select name="secondhandbook" width="20px">
												<option>是</option>
												<option>否</option>
										</select></td>
									</tr>
									<tr>
										<td align="center">类型：</td>
										<td><select name="bookcategory">
												<c:forEach var="cate" items="${sessionScope.catelist}"
													varStatus="status">
													<option>${cate.category}</option>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td align="center">照片：</td>
										<td>
										<input type="file" id="picture" name="picture" size="40"/>
	
									</tr>
									<tr>
										<td align="center">描述：</td>
										<td><textarea name="descn2" rows="3" cols="40"></textarea></td>
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
			<div id="footer"></div>
		</div>
</body>
</html>
