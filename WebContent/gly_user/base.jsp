<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="/HotelManagement/gly_user/">
    <title>Hotel Manaege</title>
    <link rel="icon" type="image/png" href="../assets/i/favicon.png">
    <link rel="stylesheet" href="../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../assets/css/admin.css" />
    <link rel="stylesheet" href="../assets/css/app.css" />
    <script src="../assets/js/echarts.min.js"></script>
</head>

<body>


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="../assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">用户</span><span class="tpl-header-list-user-ico"> <img src="../assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a id="pwd" href="pwdALert.jsp"><span class="am-icon-cog"></span> 修改密码</a></li>
                        <li><a href="ExitServlet"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span> 退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </header>
    <div class="tpl-page-container tpl-page-header-fixed">

        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                Hotel系统
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="index.jsp" target="main" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-bar-chart"></i>
                            <span>关于我们</span>
                        </a>
                    </li>
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>员工管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="employAdd.jsp" target="main">
                                    <i class="am-icon-angle-right"></i>
                                    <span>增加员工</span>
                                </a>

                                <a href="../SelectEmpServlet" target="main">
                                    <i class="am-icon-angle-right"></i>
                                    <span>员工列表</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="tpl-content-wrapper">
            <iframe src="index.jsp" name="main" scrolling="no" frameborder="0" height="1000px" width="100%"></iframe>
        </div>
    </div>
    <script src="../assets/js/jquery.min.js"></script>
    <script>
        $('#pwd').on('click', function(){
          layer.open({
            type: 2,
            title: '修改密码',
            maxmin: true,
            area: ['800px', '500px'],
            content: 'pwdAlert.html'
          });
        });
    </script>
    <script src="../assets/js/layer/layer.js"></script>
    <script src="../assets/js/amazeui.min.js"></script>
    <script src="../assets/js/app.js"></script>
</body>

</html>