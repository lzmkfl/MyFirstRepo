<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
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
        <li><a href="#" class="am-icon-home">财务管理</a></li>
        <li><a href="#">追加押金</a></li>
        <li class="am-active">内容</li>
    </ol>
    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 追加押金
            </div>
        </div>
        <div class="tpl-block">
            <div class="am-g">
                <div class="tpl-form-body tpl-form-line">
                    <form class="am-form tpl-form-line-form">
                        <div class="am-form-group">
                            <label for="user-name" class="am-u-sm-3 am-form-label">顾客姓名 <span class="tpl-form-line-small-title">Title</span></label>
                            <div class="am-u-sm-9">
                                <input type="text" class="tpl-form-input" id="user-name" placeholder="请输入顾客姓名" />
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-roomId" class="am-u-sm-3 am-form-label">入住房间 <span class="tpl-form-line-small-title">Title</span></label>
                            <div class="am-u-sm-9">
                                <input type="text" class="tpl-form-input" id="user-roomId" placeholder="请输入房间号" />
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-phone" class="am-u-sm-3 am-form-label">房间种类 <span class="tpl-form-line-small-title">Author</span></label>
                            <div class="am-u-sm-9">
                                <select data-am-selected="{searchBox: 1}">
                                    <option>--请选择--</option>
                                    <option value="option1">普通客房</option>
                                    <option value="option2">高级客房</option>
                                    <option value="option3">VIP客房</option>
                                    <option value="option4">总统套房</option>
                                </select>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-bookDate" class="am-u-sm-3 am-form-label">预定房间截止日 <span class="tpl-form-line-small-title">Time</span></label>
                            <div class="am-u-sm-9">
                                <input type="text" class="am-form-field tpl-form-no-bg" placeholder="预定时间" data-am-datepicker="" readonly />
                                <small>预定时间为必填</small>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-intro" class="am-u-sm-3 am-form-label">押金追加与否</label>
                            <div class="am-u-sm-9">
                                <div class="tpl-switch">
                                    <input type="checkbox" class="ios-switch bigswitch tpl-switch-btn" checked />
                                    <div class="tpl-switch-btn-view">
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-intro" class="am-u-sm-3 am-form-label">备注</label>
                            <div class="am-u-sm-9">
                                <textarea class="" rows="3" id="user-intro" placeholder="备注内容"></textarea>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <button type="button" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
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