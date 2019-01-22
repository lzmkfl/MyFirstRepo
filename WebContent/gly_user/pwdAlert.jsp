<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css" />
<link rel="stylesheet" href="../assets/css/app.css" />
<script src="../assets/js/echarts.min.js"></script>
<script type="text/javascript">
	var xmlhttp;
	function checkOldPwd() {
		xmlhttp = null;
		var oldPwd = document.getElementById("old-pwd").value;
		if (window.XMLHttpRequest) {// code for all new browsers
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {// code for IE5 and IE6
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp != null) {
			xmlhttp.onreadystatechange = state_Change;
			xmlhttp.open("POST", "../CheckOPServlet?oldPwd=" + oldPwd, true);
			xmlhttp.send(null);
		} else {
			alert("Your browser does not support XMLHTTP.");
		}

	}
	function state_Change() {
		if (xmlhttp.readyState == 4) {// 4 = "loaded"
			if (xmlhttp.status == 200) {// 200 = OK
				//     ...our code here...
				//     将回调信息显示在页面中
				var result = document.getElementById("result");
				result.innerHTML = xmlhttp.responseText;
			} else {
				alert("Problem retrieving XML data");
			}
		}
	}
	function MMonblus() {
		var password = document.getElementById("pwd1");
		var re = /^(?=.*\d)(?=.*[a-zA-Z])[\da-zA-Z]{6,}$/;
		// var reg=/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/;

		if (password.value == "") {
			document.getElementById('div2').innerText = "请输入密码";
		} else if (password.value.length < 6) {
			document.getElementById('div2').innerText = "格式错误,,密码长度至少为6位";
		}

		else if (!re.test(password.value)) {
			document.getElementById('div2').innerText = "格式错误,必须包含英文字母大小写和数字";
		} else {
			document.getElementById('div2').innerText = "";
		}
	}
	function MMonfocu() {
		document.getElementById('div2').innerText = "";
	}
	//确认密码
	function QRMMonblus() {
		var password = document.getElementById("pwd1");
		var confirmPassword = document.getElementById("pwd2");
		if (confirmPassword.value == "") {
			document.getElementById('div3').innerText = "请输入确认密码";
		} else if (password.value != confirmPassword.value) {
			document.getElementById('div3').innerText = "两次密码输入不一致";
		} else {
			document.getElementById('div3').innerText = "";
		}
	}
	function QRMMonfocu() {
		document.getElementById('div3').innerText = "";
	}
</script>
</head>

<body style="overflow: hidden;">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">修改密码</div>
		</div>
		<div class="tpl-block ">
			<div class="am-g tpl-amazeui-form">
				<div class="am-u-sm-12 am-u-md-9">
					<form class="am-form am-form-horizontal" method="post" action="../UpdatePwdServlet">
						<div class="am-form-group">
							<label for="old-pwd" class="am-u-sm-3 am-form-label">原密码</label>
							<div class="am-u-sm-9">
								<input type="password" id="old-pwd" placeholder="原密码"
									onblur="checkOldPwd()" />
							</div>
						</div>
						<div class="am-form-group">
							<label for="new-pwd" class="am-u-sm-3 am-form-label">新密码</label>
							<div class="am-u-sm-9">
								<input type="password"  placeholder="新密码" onfocus="MMonfocu()" onblur="MMonblus()" id="pwd1" name="newPwd"/>
							</div>
						</div>
						<div class="am-form-group">
							<label for="renew-pwd" class="am-u-sm-3 am-form-label">确认新密码</label>
							<div class="am-u-sm-9">
								<input type="password" placeholder="确认新密码" onfocus="QRMMonfocu()" onblur="QRMMonblus()" id="pwd2"/>
							</div>
						</div>
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button type="submit" class="am-btn am-btn-primary">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="tpl-alert"></div>
	</div>
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/amazeui.min.js"></script>
	<script src="../assets/js/iscroll.js"></script>
	<script src="../assets/js/app.js"></script>
</body>
</html>