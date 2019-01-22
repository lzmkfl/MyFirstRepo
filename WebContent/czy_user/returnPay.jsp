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
	function checkout() {
		var cuId = document.getElementById("cuId").value;
		var ciId = document.getElementById("ciId").value;
		var rId = document.getElementById("rId").value;
		var rNo = document.getElementById("rNo").value;
		location.href = "../CheckOutServlet?cuId=" + cuId + "&ciId=" + ciId
				+ "&rId=" + rId + "&rNo=" + rNo;
	}
</script>
</head>

<body style="overflow: hidden;">
	<div class="tpl-content-page-title">酒店管理系统</div>
	<ol class="am-breadcrumb">
		<li><a href="#" class="am-icon-home">财务管理</a></li>
		<li><a href="#">退宿结款</a></li>
		<li class="am-active">内容</li>
	</ol>
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				<span class="am-icon-code"></span> 列表
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-form-group">
						<select>
							<option value="option1">所有类别</option>
							<option value="option2">普通客房</option>
							<option value="option3">高级客房</option>
							<option value="option3">VIP客房</option>
							<option value="option4">总统套房</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field"> <span
							class="am-input-group-btn">
							<button
								class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
								type="button"></button>
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
									<th class="table-check"><input type="checkbox"
										class="tpl-table-fz-check"></th>
									<th class="table-id">ID</th>
									<th class="table-title">顾客姓名</th>
									<th class="table-type">房间号</th>
									<th class="table-author am-hide-sm-only">房间类型</th>
									<th class="table-date am-hide-sm-only">备注</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="crt">

									<input id="cuId" value="${crt.cuId }" type="hidden" />

									<input id="rId" value="${crt.rId }" type="hidden" />
									<input id="ciId" value="${crt.ciId }" type="hidden" />

									<input id="rNo" value="${crt.rNo }" type="hidden" />
									<input id="totalprice" value="${crt.totalprice }" type="hidden" />
									<tr>
										<td><input type="checkbox"></td>
										<td>${crt.ciId}</td>
										<td>${crt.cuName }</td>
										<td>${crt.rNo }</td>
										<td class="am-hide-sm-only">${crt.type }</td>
										<td class="am-hide-sm-only">${crt.remarks }</td>
										<td>
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<button
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														onclick="checkout()">
														<span class="am-icon-pencil-square-o"></span> 退宿结账
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
	<script src="../assets/js/amazeui.min.js"></script>
	<script src="../assets/js/iscroll.js"></script>
	<script src="../assets/js/app.js"></script>
</body>

</html>