<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
   
    <link rel="stylesheet" href="../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../assets/css/admin.css" />
    <link rel="stylesheet" href="../assets/css/app.css" />
    <script src="../assets/js/echarts.min.js"></script>
</head>

<body style="overflow: hidden;">
    <div class="tpl-content-page-title">
        酒店管理系统
    </div>
    <ol class="am-breadcrumb">
        <li><a href="#" class="am-icon-home">员工管理</a></li>
        <li><a href="#">增加员工</a></li>
        <li class="am-active">内容</li>
    </ol>
    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 增加员工
            </div>
        </div>
        <div class="tpl-block ">
            <div class="am-g tpl-amazeui-form">
                <div class="am-u-sm-12 am-u-md-9">
                    <form class="am-form am-form-horizontal" method="post" action="../AddEmployeeServlet">
                        <div class="am-form-group">
                            <label for="emp-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="emp-name" placeholder="姓名 / Name" name="eName"/>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="emp-sex" class="am-u-sm-3 am-form-label">性别 / Sex</label>
                            <div class="am-u-sm-9">
                                <input type="radio" value="male"  checked="checked" name="sex"/>男&nbsp
                                <input type="radio" value="female"  name="sex"/>女
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="emp-age" class="am-u-sm-3 am-form-label">年龄 / Age</label>
                            <div class="am-u-sm-9">
                                <input type="number" id="emp-age" placeholder="年龄 / Age" name="age"/>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="emp-job" class="am-u-sm-3 am-form-label">职务 / Job</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="emp-job" placeholder="职务 / Job" name="duty"/>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="emp-intro" class="am-u-sm-3 am-form-label">工作经验 / Experience</label>
                            <div class="am-u-sm-9">
                                <textarea class="" rows="5" id="emp-intro" placeholder="工作经验 / Experience" name="experience"></textarea>
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