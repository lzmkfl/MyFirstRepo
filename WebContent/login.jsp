<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function register() {
		location.href = "register.jsp";
	}
	function alertPwd() {
		alert("123");
		location.href = "gly_user/pwdAlert.jsp";
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>登录</title>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png" />
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
<link rel="stylesheet" href="assets/css/app.css" />
</head>
<body data-type="login">
	<span>${result}</span>
	<div class="am-g myapp-login">
		<div class="myapp-login-logo-block  tpl-login-max">
			<div class="myapp-login-logo-text">
				<div class="myapp-login-logo-text">
					Hotel Manage<span> System</span> <i class="am-icon-skyatlas"></i>

				</div>
			</div>

			<div class="login-font">
				<i> 酒店管理</i> <span> 系统</span>
			</div>
			<div class="am-u-sm-10 login-am-center">
				<form class="am-form" method="post" action="LoginServlet">
					<fieldset>
						<div class="am-form-group">
							<input type="text" class="" id="doc-ipt-email-1"
								placeholder="输入您的用户名" name="userName">
						</div>
						<div class="am-form-group">
							<input type="password" class="" id="doc-ipt-pwd-1"
								placeholder="输入个人密码" style="border-radius: 0" name="pwd">
						</div>
						<div class="am-form-group">
							<select id="doc-ipt-kind-1"
								style="border-radius: 0 0 6px 6px; font-size: 12px; text-indent: 10px;" name="role">
								<option value="0">选择登录身份</option>
								<option value="2">管理员</option>
								<option value="3">操作员</option>
								<option value="1">普通用户</option>
							</select>
						</div>
						<p>
							<button type="submit" class="am-btn am-btn-default">登录</button>
						</p>
						<p>
							<button type="button" class="am-btn am-btn-default"
								onclick="register()">注册</button>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>