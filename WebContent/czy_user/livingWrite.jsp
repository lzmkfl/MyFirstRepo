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
	function checkIdNum() {
		var IdNum = document.getElementById("idNum").value;
		if (IdNum.length != 18) {
			document.getElementById("div1").innerText = "身份证号必须为18位";
		} else{
			document.getElementById('div1').innerText = "";
		}
	}
	function MMonfocu() {
		document.getElementById('div1').innerText = "";
	}
	function checkPhoneNum(){
		var phoneNum = document.getElementById("phoneNum").value;
        var re = /^\d+$/;
		if(!re.test(phoneNum)){
			document.getElementById("div2").innerText = "电话号码中不能包含字母或其他字符，只能为数字";
		}else{
			document.getElementById("div2").innerText = "";
		}
		if(phoneNum.length != 11){
			document.getElementById("div2").innerText = "电话号码必须为11位";
		}else{
			document.getElementById("div2").innerText = "";
		}
	}
	function MMonfocu2() {
		document.getElementById('div2').innerText = "";
	}
	var xmlhttp;
	function selectRNo() {
		xmlhttp = null;
		var rNo = document.getElementById("rNo").value;
		if (window.XMLHttpRequest) {// code for all new browsers
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {// code for IE5 and IE6
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp != null) {
			xmlhttp.onreadystatechange = state_Change;
			xmlhttp.open("POST", "../SelectRNoServlet?rNo="+rNo, true);
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
</script>
</head>

<body style="overflow: hidden;">
	<div class="tpl-content-page-title">酒店管理系统</div>
	<ol class="am-breadcrumb">
		<li><a href="#" class="am-icon-home">住宿管理</a></li>
		<li><a href="#">住宿登记</a></li>
		<li class="am-active">内容</li>
	</ol>
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				<span class="am-icon-code"></span> 住宿登记
			</div>
		</div>
		<div class="tpl-block ">
			<div class="am-g tpl-amazeui-form">
				<div class="am-u-sm-12 am-u-md-9">
					<form class="am-form am-form-horizontal" method="post" action="../CheckInServlet">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">姓名
								/ Name</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-name" placeholder="姓名 / Name" name="cuName" />
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">身份证号/
								IDNum</label>
							<div class="am-u-sm-9">
								<input type="text" id="idNum" placeholder="输入身份证号 / IDNum" onfocus="MMonfocu()" onblur="checkIdNum()" name="idNum"/>
							</div>
							<div id="div1"></div>

						</div>
						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">电话
								/ Telephone</label>
							<div class="am-u-sm-9">
								<input type="tel" id="phoneNum"
									placeholder="输入电话号码 / Telephone" onfocus="MMonfocu2()" onblur="checkPhoneNum()" name="phoneNum"/>
							</div>
							<div id="div2"></div>
						</div>
						<div class="am-form-group">
							<label for="user-roomid" class="am-u-sm-3 am-form-label">房间号
								/ RoomId</label>
							<div class="am-u-sm-9">
								<input type="number" pattern="[0-9]*" id="rNo"
									placeholder="输入入住房间号" onblur="selectRNo()" name="rNo"/>
									<div id="result"></div>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">备注
								/ Else</label>
							<div class="am-u-sm-9">
								<textarea class="" rows="5" id="user-intro"
									placeholder="如有特殊需求，写明..." name="remarks"></textarea>
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