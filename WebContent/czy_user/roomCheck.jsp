<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="/HotelManagement/czy_user/">
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css" />
<link rel="stylesheet" href="../assets/css/app.css" />
<script src="../assets/js/echarts.min.js"></script>
<script type="text/javascript">
    function dele(rdId) {
		location.href = "../DeleRoomDServlet?rdId="+rdId
	}
    function selectByThree() {
		var type = document.getElementById("type").value;
		var state = document.getElementById("state").value;
		var rNo = document.getElementById("rNo").value;
		location.href="../SelectByTServlet?type="+type+"&state="+state+"&rNo="+rNo;
	}
    </script>
</head>

<body style="overflow: hidden;">
	<span>${result}</span>
	<div class="tpl-content-page-title">酒店管理系统</div>
	<ol class="am-breadcrumb">
		<li><a href="#" class="am-icon-home">客房管理</a></li>
		<li class="am-active">内容</li>
	</ol>
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				<span class="am-icon-code"></span>客房管理
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button id="newadd" type="button"
								class="am-btn am-btn-default am-btn-success">
								<span class="am-icon-plus"></span> 新增
							</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-form-group">
						<select id="type">
							<option value="">所有类别</option>
							<option value="总统套房">总统套房</option>
							<option value="标准间">标准间</option>
							<option value="外景房">外景房</option>
							<option value="商务房">商务房</option>
							<option value="高级行政房">高级行政房</option>
							<option value="单人间">单人间</option>
						</select> 
						<select id="state">
							<option value="">所有状态</option>
							<option value="闲置">闲置</option>
							<option value="已预订">已预订</option>
							<option value="已入住">已入住</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">

						<input type="text" class="am-form-field" placeholder="请输入房间号"
							id="rNo"> <span class="am-input-group-btn">
							<button
								class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
								type="button" onclick="selectByThree()"></button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="am-g">
			<div class="am-u-sm-12">
				<form class="am-form">
					<table class="am-table am-table-striped am-table-hover table-main">
						<thead>
							<tr>
								<th class="table-check"><input type="checkbox"
									class="tpl-table-fz-check"></th>
								<th class="table-id">ID</th>
								<th class="table-title">房间号</th>
								<th class="table-type">房间类别</th>
								<th class="table-author am-hide-sm-only">状态</th>
								<th class="table-date am-hide-sm-only">备注</th>
								<th class="table-set">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ list }" var="roomD">
								<input id="rdId" value="${roomD.rdId }" type="hidden">
								<tr>
									<td><input type="checkbox"></td>
									<td>${roomD.rdId }</td>
									<td><a href="#">${roomD.rNo }</a></td>
									<td>${roomD.type }</td>
									<td class="am-hide-sm-only">${roomD.state }</td>
									<td class="am-hide-sm-only">${roomD.remarks }</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button type="button"
													class="am-btn am-btn-default am-btn-xs am-text-secondary alert">
													<span class="am-icon-pencil-square-o"></span>修改
												</button>
												<button type="button"
													class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
													onclick="dele(${roomD.rdId})">
													<span class="am-icon-trash-o"></span> 删除
												</button>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="am-cf">
						<div class="am-fr">
							<ul class="am-pagination tpl-pagination">
								<c:if test="${page>1 }">
									<li><a href="../ManagePageServlet?page=${up }">«</a></li>
								</c:if>
								<c:forEach var="i" begin="1" end="${countAll }" step="1">
									<li><a href="#">${i}</a></li>
								</c:forEach>
								<c:if test="${page < countAll }">
									<li><a href="../ManagePageServlet?page=${next }">»</a></li>
								</c:if>

							</ul>
						</div>
					</div>
					<hr>
				</form>
			</div>
		</div>

		<div class="tpl-alert"></div>
	</div>
	<script src="../assets/js/jquery.min.js"></script>
	<script>
        $('.alert').on('click', function(){
        	var rdId = document.getElementById("rdId").value;
          layer.open({
            type: 2,
            title: '修改',
            maxmin: true,
            area: ['800px', '500px'],
            content: '../DetailServlet?rdId='+rdId
          });
        });
        $('#newadd').on('click', function(){
        	var rdId = document.getElementById("rdId").value;
          layer.open({
            type: 2,
            title: '新增',
            maxmin: true,
            area: ['800px', '500px'],
            content: 'roomCheck-form2.jsp'
          });
        });
    </script>
	<script src="../assets/js/layer/layer.js"></script>
	<script src="../assets/js/amazeui.min.js"></script>
	<script src="../assets/js/iscroll.js"></script>
	<script src="../assets/js/app.js"></script>
</body>

</html>