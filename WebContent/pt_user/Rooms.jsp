<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<base href="/HotelManagement/pt_user/">
<link rel="icon" type="image/png" href="images/favicon.png">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<script type="text/javascript" src="js/jquery.jqtransform.js"></script>
</head>
<body id="page4">
	<div class="bg1">
		<div class="bg2">
			<div class="main">
				<!-- header -->
				<header>
				<h1>
					<a href="index.html" id="logo">LoungeHotel</a>
				</h1>
				</header>
				<nav>
				<ul id="menu">
					<li><a href="index.html">关于我们</a></li>
					<li><a href="Services.html">服务内容</a></li>
					<li class="last active"><a href="RoomShowServlet">房间展示</a></li>
				</ul>
				</nav>
				<!-- header end -->
				<!-- content -->
				<article id="content">
				<div class="box1">
					<div class="wrapper">
						<h2>
							<img src="images/title_marker1.jpg" alt="">房间展示
						</h2>
						<table border="1"
							style="border-collapse: collapse; border-spacing: 0; border: 1px solid #FFFFFF;"
							width="100%">
							<tr
								style="background: #e5efeb; color: #000000; border-bottom-width: 0; text-align: center; height: 2.2rem;">
								<td>ID</td>
								<td>图片</td>
								<td>类型</td>
								<td>详细信息</td>
								<td>价格(一晚)</td>
								<td>床</td>
								<td>剩余数量</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${list }" var="room">
								<tr
									style="background: #e5efeb; text-align: center; height: 2.2rem;">
									<td class="pad_bot3"><img src="images/${room.r_image }"
										width="120px" height="100px"></td>
									<td>${room.rId }</td>
									<td>${room.type }</td>
									<td>${room.description }</td>
									<td>${room.day_price }</td>
									<td>${room.bedCount }</td>
									<td>${room.rCount }</td>
									<td><a class="button2 book"   href="../LocationServlet?day_price=${room.day_price }&rId=${room.rId}&type=${room.type}">预定</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				</article>
				<!--content end-->
			</div>
		</div>
	</div>
	</div>
	<div class="main">
		<!-- footer -->
		<footer>
		<div class="col2">
			Lounge Hotel &copy; 版权所有
			<nav>
			<ul id="footer_menu">
				<li><a href="index.html">关于我们</a></li>
				<li><a href="Services.html">服务内容<a></li>
				<li class="last active"><a href="Rooms.html">房间展示</a></li>
			</ul>
			</nav>
		</div>
		<div class="col1 pad_left1">
			<ul id="icons">
				<li><a href="#" class="normaltip" title="Linkedin"><img
						src="images/icon1.jpg" alt=""></a></li>
				<li><a href="#" class="normaltip" title="Facebook"><img
						src="images/icon2.jpg" alt=""></a></li>
				<li><a href="#" class="normaltip" title="Picasa"><img
						src="images/icon3.jpg" alt=""></a></li>
				<li><a href="#" class="normaltip" title="Twitter"><img
						src="images/icon4.jpg" alt=""></a></li>
			</ul>
		</div>
		<!-- {%FOOTER_LINK} --> </footer>
		<!-- footer end -->
	</div>
	<script src="../assets/js/jquery.min.js"></script>
	<script>
	</script>
	<script src="../assets/js/layer/layer.js"></script>
</body>
</html>