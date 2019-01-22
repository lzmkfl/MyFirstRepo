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
        <li><a href="#" class="am-icon-home">消费品管理</a></li>
        <li><a href="#">查找f消费品</a></li>
        <li class="am-active">内容</li>
    </ol>
    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 消费品管理
            </div>
        </div>
        <div class="tpl-block">
            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button id="newadd" type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-3">
                    <div class="am-form-group">
                        <select data-am-selected="{btnSize: 'sm'}">
                            <option value="option1">所有类别</option>
                            <option value="option2">饮品类</option>
                            <option value="option3">主食类</option>
                            <option value="option3">服务类</option>
                            <option value="option4">其他</option>
                        </select>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-3">
                    <div class="am-input-group am-input-group-sm">
                        <input type="text" class="am-form-field" />
                        <span class="am-input-group-btn">
                            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
                        </span>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                                <tr>
                                    <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                    <th class="table-id">ID</th>
                                    <th class="table-title">品名</th>
                                    <th class="table-type">消费类别</th>
                                    <th class="table-author am-hide-sm-only">消费金额</th>
                                    <th class="table-set">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1</td>
                                    <td><a href="#">拉菲</a></td>
                                    <td>饮品类</td>
                                    <td class="am-hide-sm-only">3000</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary alert"><span class="am-icon-pencil-square-o"></span>修改</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="am-cf">
                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination">
                                    <li class="am-disabled"><a href="#">«</a></li>
                                    <li class="am-active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
            </div>
        </div>
        <div class="tpl-alert"></div>
    </div>
    <script src="../assets/js/jquery.min.js"></script>
    <script>
        $('.alert').on('click', function(){
          layer.open({
            type: 2,
            title: '修改',
            maxmin: true,
            area: ['800px', '500px'],
            content: 'resumeCheck-form.html'
          });
        });
        $('#newadd').on('click', function(){
          layer.open({
            type: 2,
            title: '新增',
            maxmin: true,
            area: ['800px', '500px'],
            content: 'resumeCheck-form.html'
          });
        });
    </script>
    <script src="../assets/js/layer/layer.js"></script>
    <script src="../assets/js/amazeui.min.js"></script>
    <script src="../assets/js/iscroll.js"></script>
    <script src="../assets/js/app.js"></script>
</body>

</html>