<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/kwicks-1.5.1.pack.js"></script>
<script type="text/javascript" src="js/atooltip.jquery.js"></script>
</head>
<body id="page1">
	<span>${result }</span>
	<div class="bg1">
		<div class="bg2">
			<div class="main">
				<!-- header -->
				<header>
				<h1>
					<a href="index.jsp" id="logo">LoungeHotel</a>
				</h1>
				</header>
				<nav>
				<ul id="menu">
					<li class="active"><a href="index.jsp">关于我们</a></li>
					<li><a href="Services.jsp">服务内容</a></li>
					<li class="last"><a href="../RoomShowServlet">房间展示</a></li>
				</ul>
				</nav>
				<!-- header end -->
				<!-- content -->
				<article id="content"> <span>${result}</span>
				<div class="box1">
					<div class="wrapper">
						<form action="#" id="form1">
							<img src="images/img2.jpg">
						</form>
						<div class="kwicks-wrapper marg_bot1">
							<ul class="kwicks horizontal">
								<li><img src="images/img1.jpg" alt=""></li>
								<li><img src="images/img2.jpg" alt=""></li>
								<li><img src="images/img3.jpg" alt=""></li>
								<li><img src="images/img4.jpg" alt=""></li>
							</ul>
						</div>
					</div>
					<div class="pad">
						<div class="line1">
							<div class="wrapper line2">
								<div class="col1">
									<h2>
										<img src="images/title_marker1.jpg" alt="">酒店介绍
									</h2>
									<p class="pad_bot1">自动化智能管理酒店是由实力雄厚的星尚.严格按照四星级标准改建装修的豪华商务型酒店。酒店位于怀化市商业区核心地段——迎丰中路99号，驱车至火车站5分钟车程，芷江机场20分钟车程，地理位置优越，交通极为便利。
									</p>
									<a href="#" class="color1">更多...</a>
								</div>
								<div class="col1 pad_left1">
									<h2>
										<img src="images/title_marker2.jpg" alt="">酒店设施
									</h2>
									<p class="pad_bot1">酒店主楼14层，裙楼8层，内设大型停车场，共有车位100个。客房拥有豪华套房及高级客房等110间/套，所有客房均由名家设计，布置完善细致，设施齐备高档，风格典雅温馨，环境舒适自由；均设有中央空调、冷热饮设备、私人保险箱，电话留言系统、卫星闭路电视、国际国内直拨电话，多媒体宽带网络、迷你吧、电子门匙系统等，令起居倍感愉悦。</p>
									<a href="#" class="color1">更多...</a>
								</div>
								<div class="col1 pad_left1">
									<h2>
										<img src="images/title_marker3.jpg" alt="">酒店特色
									</h2>
									<p class="pad_bot1">酒店餐厅共有餐位800个；其中高档别致的豪华包厢17间，极具人性化的设计风格，可迎合客人的不同需求和自由选择，能为客人提供正宗鱼翅燕窝、鲍参翅肚、珍贵海鲜等。所有珍馐美食均由名师主理，让阁下全方位品味中西饮食文化精粹，倍感轻松惬意。</p>
									<a href="#" class="color1">更多...</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				</article>
				<!--content end-->
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
				<li class="active"><a href="index.jsp">关于我们</a></li>
				<li><a href="Services.jsp">服务内容</a></li>
				<li class="last"><a href="Rooms.jsp">房间展示</a></li>
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
	<script>
		$(document).ready(function() {
			$('.kwicks').kwicks({
				max : 500,
				spacing : 0,
				event : 'mouseover'
			});

		})
	</script>
</body>
</html>