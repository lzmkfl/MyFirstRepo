<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>DateBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script>
		function disable(){
			$('#dd').datebox('disable');
		}
		function enable(){
			$('#dd').datebox('enable');
		}
	</script>
</head>
<body>
	<h2>DateBox</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Allow you to select date in your form.</div>
	</div>
	
	<div style="margin:10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="disable()">Disable</a>
		<a href="#" class="easyui-linkbutton" onclick="enable()">Enable</a>
	</div>
	<input id="dd" class="easyui-datebox" required="required"></input>
</body>
</html>