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
		<div id="center" align="center">
			<div id="leftside" align="center">
				<p class="h1">图书种类</p>
				<s:action name="category"></s:action>
				<table width="200px" height="346px" class="table"><tr align="center"><td>
				<table width="150px" height="346px" >
					<c:forEach var="cat" items="${sessionScope.catelist }"
						varStatus="status">
						<tr>
							<td>
									<a class="linksize"
										href="categorybook.action?catid=${cat.catid}">
										${cat.category}</a>
								</td>
						</tr>
					</c:forEach>
				</table></td></tr>
				</table>

			</div>
			<div id="cen">
				<img src="images/index.jpg" width="560" height="390" />

				<!-- <br /> <br />
				<marquee height="300px" width="500px" bgcolor="#3399CC">
					<P align=left>
					<P align=center>
						<IMG src="images/1.png" width="369" height="200"> <IMG
							src="images/2.png" width="369" height="200"> <IMG
							src="images/1.png" width="369" height="200"> <IMG
							src="images/2.png" width="369" height="200"> <IMG
							src="images/1.png" width="369" height="200">
					</P>
				</marquee> -->
			</div>
			<div id="rightside">
				<table height="50%" width="90%">
					<tr>
						<td align="center">
							<div class="loginimg">
								<a href="login.jsp"><img src="images/1.png" width="150px"
									height="50px" /></a>
							</div>
							<div class="loginimg">
								<a href="register.jsp"><img src="images/2.png" width="150px"
									height="50px" /></a>
							</div>
						</td>
					</tr>
				</table>

				<table height="50%" width="90%" class="table">
					<tr>
						<td align="center">
							
								先验货后付款，交易更安全。 <br /> <br /> 以诚为本销售，质量有保障。 <br /> <br />
								精选优质图书，安心可信赖。 <br /> <br /> 循环购物送礼，购物更开心。

							
						</td>
					</tr>

				</table>
			</div>

			<div id="leftside2">
				<table border="1" height="450px" width="100%">
					<tr>
						<td align="center"><s:action name="topSellcountBook"></s:action>
							<br />
							<p class="h1">热销书推荐</p> <c:forEach var="b"
								items="${sessionScope.topSellcountBook}" varStatus="status">
										<table height="140px" width="500px"  >
						<tr>
							<td rowspan="4" width="140px"><a href="bookInfo.action?bookid=${b.bookid}"><img
									src="${b.picture }" height="140px" width="100px" /></a></td>
							<td >${b.bookname}</td>
						</tr>
						<tr>
							<td>${b.author}&nbsp;著；</td>
						</tr>
						<tr>
							<td>销量:${b.sellcount}</td>
			
						</tr>
						<tr>
							<td>￥${b.price}&nbsp;&nbsp; 
							<a href="addcart.action?bookid=${b.bookid}">
							<button class="ui orange button">加入购物车</button></a></td>
						</tr>
					</table>
				
					<div class="ui divider"></div>
							</c:forEach></td>
					</tr>
				</table>
			</div>
			<div id="rightside2">
				<table border="1" height="450px" width="100%">
					<tr>
						<td align="center"><br />
							<p class="h1">二手书推荐</p> <s:action name="topSecondhandBook"></s:action>
							<c:forEach var="b" items="${sessionScope.topSecondhandBook}"
								varStatus="status">
								<table height="140px" width="500px" >
						<tr>
							<td rowspan="4" width="140px"><a href="bookInfo.action?bookid=${b.bookid}"><img
									src="${b.picture }" height="140px" width="100px" /></a></td>
							<td >${b.bookname}</td>
						</tr>
						<tr>
							<td>${b.author}&nbsp;著；</td>
						</tr>
						<tr>
							<td>销量:${b.sellcount}</td>
			
						</tr>
						<tr>
							<td>￥${b.price}&nbsp;&nbsp;
							<a href="addcart.action?bookid=${b.bookid}">
							<button class="ui orange button">加入购物车</button></a></td>
						</tr>
					</table>
				
					<div class="ui divider"></div>
							</c:forEach></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">
			<table width="100%" border="0">
				<tr align="center">
					<td width="25%"><br />购物指南 <br /> 免费注册 <br /> 会员介绍 <br />
						购物流程 <br /> 联系客服 <br /></td>
					<td width="25%">支付方式 <br /> 在线支付 <br /> 货到付款 <br /> 支付宝 <br />
					</td>
					<td width="25%">配送方式 <br /> 省内外快递邮寄 <br /> 自行取货
					</td>
					<td>售后服务 <br /> 售后政策 <br /> 退/换货服务 <br />
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>

</html>





