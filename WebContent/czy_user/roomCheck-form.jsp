<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="/HotelManagement/czy_user/">
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css" />
<link rel="stylesheet" href="../assets/css/app.css" />
<script src="../assets/js/echarts.min.js"></script>
</head>

<body style="overflow: hidden;">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">客房管理</div>
		</div>
		<div class="tpl-block ">
			<div class="am-g tpl-amazeui-form">
				<div class="am-u-sm-12 am-u-md-9">
					<form class="am-form am-form-horizontal" method="post" action="../AlterRoomDServlet">
						<div class="am-form-group">
						<input type="hidden" name="rdId" value="${roomDetail.rdId }">
						<input type="hidden" name="rId" value="${roomDetail.rId }">
							<label for="roomId" class="am-u-sm-3 am-form-label">房间号</label>
							<div class="am-u-sm-9">
								<input type="text" id="roomId" placeholder="房间号" name="rNo" value="${roomDetail.rNo }"/>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">房间类别</label>
                           
							<div class="am-u-sm-9">
								<select name="type" >
								   <option value="${roomDetail.type }">${roomDetail.type }</option>
									<option value="总统套房">总统套房</option>
									<option value="标准间">标准间</option>
									<option value="外景房">外景房</option>
									<option value="商务房">商务房</option>
									<option value="高级行政房">高级行政房</option>
								</select> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">房间状态</label>
							<div class="am-u-sm-9">
								<select name="state" >
								 <option value="${roomDetail.state }">${roomDetail.state }</option>
									<option value="闲置">闲置</option>
									<option value="已预订">已预订</option>
									<option value="已入住">已入住</option>
								</select>
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">备注
								/ Else</label>
							<div class="am-u-sm-9">
								<textarea class="" rows="5" id="user-intro"
									placeholder="备注 / Else" name="remarks">${roomDetail.remarks}</textarea>
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