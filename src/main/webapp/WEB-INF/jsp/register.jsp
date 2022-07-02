<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自主学习平台</title>
<link rel="shortcut icon"	href="https://8.url.cn/edu/edu_modules/edu-ui/img/nohash/favicon.ico">
	
<script type="text/javascript" src="lib/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="css/wukong-ui.css" />
</head>

<body class="logonBody">
    <div class="register">
	<div class="ad">java自主学习平台</div>
    <div class="top">注册</div>
	<form action="<%=basePath%>addStudent.html" method="POST">
		<div class="panel-body">
			<div class="row">
				<div class="form-inline">
					<div class="form-group reg">
						<div class="input-group">
							学生姓名:<input required="required" name="name" type="text" style="height:25px;"
								class="form-control wk-normal-input" placeholder="请输入学生姓名" />
						</div>
					</div>

					<div class="form-group reg">
						<div class="input-group">
							学生学号:<input required="required" name="num" type="text" style="height:25px;"
								class="form-control wk-normal-input" placeholder="请输入学生学号" />
						</div>
					</div>
					<div class="form-group reg">
						所属学院:<select class="selectpicker" name="collegeId" style="height:25px;">
							<c:forEach items="${colleges}" var="var">
								<option value="${var.id}">${var.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-inline">
					<div class="form-group reg">
						<div class="input-group">
							联系电话:<input required="required" name="telphone" type="tel" style="height:25px;" pattern="^(0|86|17951)?(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{8}"
								class="form-control wk-normal-input" placeholder="请输入联系电话" />
						</div>
					</div>
					<div class="form-group reg" >
						<div class="input-group">
							身份证号:<input required="required" name="idCardNo" type="text" style="height:25px;" pattern="^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$"
								class="form-control wk-normal-input" placeholder="请输入身份证号" />
						</div>
					</div>
					<div class="form-group reg">
						学生性别: <select style="height:25px;"
							class="selectpicker" name="gender">
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</div>
				</div>
				<div class="form-inline">
					<div class="form-group reg">
						<div class="input-group">
							登录账户:<input required="required" id="account" name="account" type="text" style="height:25px;"   pattern="^[0-9a-zA-Z]\S{4,9}$"
								class="form-control wk-normal-input" onblur="checkUserName()" placeholder="请输入登录账户（5-10位数字，字母）" />
						</div>
						<span id="checkResult" style="color: red;"></span>
					</div>
					<div class="form-group reg">
						<div class="input-group">
							登录密码: <input required="required" name="password" type="password" style="height:25px;"
								class="form-control wk-normal-input" placeholder="请输入登录密码" />
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel-footer wk-panel-footer">
			<button type="submit" id="registerBtn" class="btn btn-default wk-btn" style="height:25px;font-size:18px;">注册</button>
		</div>
	</form>
	</div>

	<script type="text/javascript">
		function checkUserName(){
			var account = $("#account").val();
			console.log(account);
			$.ajax({
				type:"get",
				url:"<%=basePath%>checkName.html",
				data:{account:account},
				dataType:"json",
				success:function (data) {
					console.log(data);
					console.log(data.result);
					if (data.result == "success" ){
						$("#registerBtn").attr("disabled",false);
						$("#checkResult").html(null);
					}else{
						$("#registerBtn").attr("disabled",true);
						$("#checkResult").html("用户名已占用");
					}
				},
				error:function () {
					console.log("请求失败！");
				}
			});
		}
	</script>
</body>
</html>
