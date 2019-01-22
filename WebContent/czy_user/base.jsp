<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<base href="/HotelManagement/">
<title>Hotel Manaege</title>
<link rel="icon" type="image/png" href="assets/i/favicon.png" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
<link rel="stylesheet" href="assets/css/app.css" />
<script src="assets/js/echarts.min.js"></script>
</head>

<body>
    <span>${result}</span>
	<header class="am-topbar am-topbar-inverse admin-header">
	<div class="am-topbar-brand">
		<a href="javascript:;" class="tpl-logo"> <img
			src="assets/img/logo.png" alt="" />
		</a>
	</div>
	<div
		class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right"></div>
	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>
	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="tpl-header-list-user-nick">操作员</span><span
					class="tpl-header-list-user-ico"> <img
						src="assets/img/user01.png" /></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a id="pwd"><span class="am-icon-cog"></span> 修改密码</a></li>
					<li><a href="ExitServlet"><span
							class="am-icon-sign-out tpl-header-list-ico-out-size"></span>
							退出登录</a></li>
				</ul>
			</li>
		</ul>
	</div>
	</header>
	<div class="tpl-page-container tpl-page-header-fixed">

		<div class="tpl-left-nav tpl-left-nav-hover">
			<div class="tpl-left-nav-title">Hotel系统</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="czy_user/index.jsp"
						target="main" class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-home"></i> <span>首页</span>
					</a></li>

					<li class="tpl-left-nav-item"><a href="SelectRoomDServlet"
						target="main" class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>客房管理</span>
					</a></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>住宿管理</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a href="czy_user/livingWrite.jsp" target="main"> <i
									class="am-icon-angle-right"></i> <span>住宿登记</span>
							</a> <a href="czy_user/changeWrite.jsp" target="main"> <i
									class="am-icon-angle-right"></i> <span>调房登记</span>
							</a> <a href="SelectCIServlet" target="main"> <i
									class="am-icon-angle-right"></i> <span>住宿查询</span>
							</a> <a href="SelectAcountServlet" target="main"> <i
									class="am-icon-angle-right"></i> <span>账单查询</span>
							</a></li>
						</ul></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-bar-chart"></i> <span>消费品管理</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a href="czy_user/resumeAdd.jsp" target="main"> <i
									class="am-icon-angle-right"></i> <span>增加消费品</span>
							</a> <a href="czy_user/resumeCheck.jsp" target="main"> <i
									class="am-icon-angle-right"></i> <span>查找消费品</span>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>账务管理</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a href="czy_user/addPay.jsp" target="main"> <i
									class="am-icon-angle-right"></i> <span>追加押金</span>
							</a> <a href="SelectThreeServlet" target="main"> <i
									class="am-icon-angle-right"></i> <span>退宿结账</span>
							</a> 
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="tpl-content-wrapper">
			<iframe src="czy_user/index.jsp" name="main" scrolling="no"
				frameborder="0" height="1300px" width="100%"></iframe>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script>
		$('#pwd').on('click', function() {
			layer.open({
				type : 2,
				title : '修改密码',
				maxmin : true,
				area : [ '800px', '500px' ],
				content : 'czy_user/pwdAlert.jsp'
			});
		});
	</script>
	<script src="assets/js/layer/layer.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>

</html>