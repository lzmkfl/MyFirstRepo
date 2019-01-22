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
<script type="text/javascript" src="js/atooltip.jquery.js"></script>

<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>
<body id="page5">
	<div class="bg1">
		<div class="bg2">
			<article id="content">
			<div class="box1">
				<div class="wrapper">
					<div class="col2 pad">
						<h2>
							<img src="images/title_marker1.jpg" alt="">预定信息填写
						</h2>
						<form id="ContactForm" method="get" action="../ReserveServlet">
						<input type="hidden" name="cuId" value="${cuId }"/>
							<div>
								<input type="hidden" name="rId" value="${rId }">
								<div class="wrapper">
									<input type="text" name="reCuName" class="input" /> 姓名:
								</div>
								<div class="select">
									性别: <input type="radio" name="sex" value="男" class="radio" />男
									<input type="radio" name="sex" value="女" class="radio" />女
								</div>
								<div class="wrapper">
									<input type="text" name="idNum" class="input" /> 身份证号:
								</div>
								<div class="wrapper">
									入住日期:&nbsp&nbsp<input id="dd" class="easyui-datebox input"
										required="required" name="checkInDate"></input>
								</div>
								<div class="wrapper">
									离开日期:&nbsp&nbsp<input id="dd" class="easyui-datebox input"
										required="required" name="leaveDate"></input>
								</div>
								<div class="wrapper">
									价格（一晚）:&nbsp&nbsp<input value="${day_price }" name="day_price" />
								</div>
								<div class="wrapper">
									房间类型:&nbsp&nbsp<input value="${type }" name="type" />
								</div>
								<div class="textarea_box">
									<textarea name="remarks" cols="1" rows="1"></textarea>
									备注:
								</div>
								<a class="button2"
									onClick="document.getElementById('ContactForm').submit()">提交</a>
								<a href="#" class="button2"
									onClick="document.getElementById('ContactForm').reset()">清空</a>
							</div>
						</form>
					</div>
				</div>

			</div>
			</article>
		</div>
	</div>

</body>
</html>