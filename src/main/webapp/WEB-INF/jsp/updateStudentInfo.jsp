<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>个人信息-自主学习平台ForFuture</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="ForFuture Group、ForFuturn News,ForFuture Share,ForFuture Shopping" />
	<meta name="keywords" content="自主学习平台，知识共享!共祝教育事业！  ganquanzhong" />
	<meta name="author" content="ganquanzhong.top" />
	<link rel="shortcut icon"	href="https://8.url.cn/edu/edu_modules/edu-ui/img/nohash/favicon.ico">
			
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >
	<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/wukong-ui.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap-select.min.css">
	<script type="text/javascript" src="lib/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-select.min.js"></script>

</head>

<body>
	<div class="row">
		<div class="col-lg-12">
			<ul class="breadcrumb wk-breadcrumb">  
				<li><a href="javascript:void(0);">自主学习平台</a></li>
				<li><a href="javascript:void(0);">信息管理</a></li>
				<li><a href="javascript:void(0);">个人信息</a></li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default wk-panel ">
				<div class="panel-heading">编辑个人信息  [${sessionScope.user.name}]</div>
				<form action="<%=basePath%>editStudentInfo/${student.id}.html" method="POST">
					<div class="panel-body">
						<div class="row">
							<div class="form-inline">
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">学生姓名:
									</label>
									<div class="input-group">
										<input required="required" name="name" type="text"
											class="form-control wk-normal-input" value="${student.name}"
											placeholder="请输入学生姓名" />
									</div>
								</div>

								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">学生学号:
									</label>
									<div class="input-group">
										<input required="required" name="num" type="text"
											class="form-control wk-normal-input" value="${student.num}"
											placeholder="请输入学生学号" />
									</div>
								</div>
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">所属学院:
									</label> <select class="selectpicker" name="collegeId">
										<c:forEach items="${colleges}" var="var">
											<c:choose>
								          		<c:when test="${var.id == student.collegeId}">
								          			<option value="${var.id}" selected="selected">${var.name}</option>
								          		</c:when>
								          		<c:otherwise>
								          			<option value="${var.id}" >${var.name}</option>
								          		</c:otherwise>
								          	</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-inline">
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">联系电话:
									</label>
									<div class="input-group">
										<input required="required" name="telphone" type="text" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
											class="form-control wk-normal-input"  value="${student.telphone}"
											placeholder="请输入联系电话"  />
									</div>
								</div>
								<div class="form-group">
									<label for="filePath" class="control-label wk-filed-label">身份证号:
									</label>
									<div class="input-group">
										<input required="required" name="idCardNo" type="text"
											class="form-control wk-normal-input"  value="${student.idCardNo}"
											placeholder="请输入身份证号" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label wk-filed-label">学生性别: </label> <select
										class="selectpicker" name="gender">
										<c:choose>
							          		<c:when test="${student.gender == 0}">
							          			<option value="0" selected="selected">男</option>
							          			<option value="1" >女</option>
							          		</c:when>
							          		<c:otherwise>
							          			<option value="1" selected="selected">女</option>
							          			<option value="0" >男</option>
							          		</c:otherwise>
							          	</c:choose>
									</select>
								</div>
							</div>
							<div class="form-inline">
								<div class="form-group">
									<label class="control-label wk-filed-label">登录账户: </label>
									<div class="input-group">
										<input required="required" name="account" type="text"
											class="form-control wk-normal-input" value="${student.account}"
											placeholder="请输入登录账户" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label wk-filed-label">登录密码: </label>
									<div class="input-group">
										<input required="required" name="password" type="password"
											class="form-control wk-normal-input" value="${student.password}"
											placeholder="请输入登录密码" />
									</div>
								</div>
							</div>

						</div>
					</div>

					<div class="panel-footer wk-panel-footer">
						<button type="submit" class="btn btn-default wk-btn">修&nbsp;&nbsp;改</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>