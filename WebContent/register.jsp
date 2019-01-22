<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录</title>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
<link rel="stylesheet" href="assets/css/app.css" />
</head>
<style>
span {
	color: #FF0000;
	font-size: 12px
}
</style>
<script type="text/javascript">
//用户名
 function YHMonblus(){
        var username=document.getElementById("userName");
       // var reN =/^\d{6,18}$/;
        var re = /^[a-zA-Z_]{6,18}$/;
        if(username.value==""){
            document.getElementById('div1').innerText="请输入用户名";
        }
        else if(username.value.length < 6 ||username.value.length > 18){
            console.log(username.value);
            document.getElementById('div1').innerText="格式错误,长度应为6-18个字符";
        }
        else if(!re.test(username.value)){

            document.getElementById('div1').innerText="格式错误,只能包含英文字母和下划线";
        }
        else {
            document.getElementById('div1').innerText ="";
            
        }
    }
    function YHMonfocu(){
            document.getElementById('div1').innerText ="";
    }
//密码
function MMonblus(){
          var password=document.getElementById("pwd1");
          var re = /^(?=.*\d)(?=.*[a-zA-Z])[\da-zA-Z]{6,}$/;
         // var reg=/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/;

        if(password.value==""){
        document.getElementById('div2').innerText="请输入密码";
        }
          else if(password.value.length < 6){
             document.getElementById('div2').innerText="格式错误,,密码长度至少为6位";
         }

         else if(!re.test(password.value)){
             document.getElementById('div2').innerText="格式错误,必须包含英文字母大小写和数字";
        }
         else {
        document.getElementById('div2').innerText ="";
        }
}
    function MMonfocu(){
        document.getElementById('div2').innerText ="";
    }
//  确认密码
    function QRMMonblus(){
        var password=document.getElementById("pwd1");
        var confirmPassword=document.getElementById("pwd2");
        if(confirmPassword.value==""){
            document.getElementById('div3').innerText="请输入确认密码";
        }
        else if(password.value != confirmPassword.value){
            document.getElementById('div3').innerText="两次密码输入不一致";
        }
        else {
            document.getElementById('div3').innerText ="";
        }
    }
    function QRMMonfocu(){
        document.getElementById('div3').innerText ="";
    }

</script>
<body>

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
				<form class="am-form" method="post" action="RegisterServlet">

					<div class="am-form-group">
						<input type="text" id="userName" placeholder="输入用户名呗"
							onfocus="YHMonfocu()" onblur="YHMonblus()" name="userName"> 
							<span id="div1"></span>
					</div>

					<div class="am-form-group">
						<input type="password" class="" id="pwd1"
							placeholder="设置个密码呗" style="border-radius: 0"
							onfocus="MMonfocu()" onblur="MMonblus()" name="pwd1"> <span id="div2"></span>
					</div>
					<div class="am-form-group">
						<input type="password" class="" id="pwd2"
							placeholder="确认下密码呗" style="border-radius: 0"
							onfocus="QRMMonfocu()" onblur="QRMMonblus()" name="pwd2"> <span
							id="div3"> </span>
					</div>
					<div class="am-form-group">
						<select id="doc-ipt-kind-1"
							style="border-radius: 0 0 6px 6px; font-size: 12px; text-indent: 10px;" name="role">
							<option value="0">选择注册身份</option>
							<option value="2">管理员</option>
							<option value="3">操作员</option>
							<option value="1">普通用户</option>
						</select> <span id="div4"> </span>
					</div>
					<br />
					<div>
						<p>
							<button type="submit" class="am-btn am-btn-default">注册</button>
						</p>
					</div>



				</form>
			</div>
		</div>
	</div>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>