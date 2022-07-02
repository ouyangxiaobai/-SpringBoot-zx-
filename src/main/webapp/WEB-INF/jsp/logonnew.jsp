<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>登录 自主学习平台-ForFuture</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="ForFuture Group、ForFuturn News,ForFuture Share,ForFuture Shopping" />
<meta name="keywords" content="自主学习平台，知识共享!共祝教育事业！  ganquanzhong" />
<meta name="author" content="ganquanzhong.top" />
<link rel="shortcut icon"
	href="https://8.url.cn/edu/edu_modules/edu-ui/img/nohash/favicon.ico">

<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"	href="fonts/iconic/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>
	<div class="limiter" id="loginContainer">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<span style="    font-size: 66px;
    color: white;" class="login100-form-title p-b-49 loginTitle">自主学习平台系统</span>
			<div style="position: relative;" class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<!-- 登录form -->
				<form class="login100-form validate-form"
					action="<%=basePath%>userLogon.html" method="POST">
					<%--<span class="login100-form-title p-b-49 loginTitle">自主学习平台</span>--%>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名" >
						<span class="label-input100">用户名</span>
						<input class="input100"	type="text" name="account" placeholder="请输入用户名"	autocomplete="off" required="required">

					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span> 
						<input class="input100" type="password" name="password" placeholder="请输入密码" required="required"> 

					</div>

					
					<div style="margin-top:10px; float:left;">
						<span class="label-input100 label">角色</span>
						<div class="role">
							<select name="role">
								<option value="2">学生</option>
								<option value="1">教师</option>
								<option value="0">管理员</option>
							</select>
						</div>
					</div>
					
					<div  style="margin-top:10px;float:left;">
						<span class="label-input100">验证码</span> 
						<input type="text" name="verifyCode" placeholder="请输入验证码" required="required" style="width: 113px;font-size: 16px;text-align: center;"> 
						<img id="verifyCode" alt="验证码" :src="imagSrc" @click="changeCheckCode()" style="float:right;margin-left: 150px;width: 70px;"/>
					</div>
					<div class="flex-col-c p-t-25"></div>
					<div class="flex-col-c p-t-25"></div>
					<div class="flex-col-c p-t-25"></div>
					<div class="flex-col-c p-t-25"></div>

					<div style="text-align:left;">
						<a href="javascript:void(0);" class="txt2" style="color:red;font-weight:700;font-size:14px;">${info}</a>
					</div>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn" style="width: 49%">
							<div class="login100-form-bgbtn"></div>
							<button style="background:#04b0f5" class="login100-form-btn">登 录</button>
						</div>
						<div class="wrap-login100-form-btn" style="width: 49%" onclick="javascript:window.location.href='<%=basePath%>register.html'">
							<div class="login100-form-bgbtn"></div>
							<a href="" style="color: deepskyblue"><button style="background: rgb(44 222 53);" class="login100-form-btn">注册</button></a>

						</div>


					</div>
					<%--<div class="copyright">--%>
						<%--&lt;%&ndash;<a href="#" target="_blank"> ©2021 xxx 设计 </a></br>&ndash;%&gt;--%>
						<%--<a href="#" style="color:red;font-size:18px;">java自主学习平台</a>--%>
					<%--</div>--%>
				</form>
			</div>

		</div>
	</div>
	<div style="min-height: 30px;background-color: white" class="container-login100">
		<a href="#" style="color:black;font-size:18px;">© 2021 java自主学习平台. All rights reserved xxx</a>
	</div>
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>
	<script type="text/javascript" src="js/vue.min.js"></script>
	<script type="text/javascript" src="js/vue-resource.js"></script>
	<script type="text/javascript">
		var loginVue = new Vue({
			el : "#loginContainer",
			data : {
				imagSrc : "VerifyCode"//图片验证码
			},
			methods : {
				changeCheckCode : function() {
					var strs = this.imagSrc;
					this.imagSrc = strs + "?" + new Date();
				}
			}
		});
	</script>
</body>

</html>