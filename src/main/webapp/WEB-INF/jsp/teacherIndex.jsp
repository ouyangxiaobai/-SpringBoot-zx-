<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>教师 自主学习平台ForFuture</title>
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

<body style="background-image: url('images/2.jpg');font-size: 19px;">
   <!--  系统banner start-->
	<div class="row" style="margin-top: 30px;">
		<div class="col-lg-8 banner1"  style="padding-left: 30px;">
            <div id="banner" class="logo"style="color: white">
                自主学习平台管理系统
            </div>
            <%--<a href="#" target="_blank">--%>
                <%--<div class="logo" style="color:white;font-family: monospace;">--%>
                    <%--Design By 你的名字--%>
                <%--</div>--%>
            <%--</a>--%>
		</div>
		<div  class="col-lg-8 banner2">
		    <div class="userinfo">
		    	<a class="myInfo" style="font-weight:800;font-family: cursive;"></a>
		    </div>  
		</div>
	</div>
	<!--  系统banner end-->

    <div class="row">
        <div class="col-lg-12">
            <ul class="nav nav-tabs wk-nav-menu" id="wk-nav-menu" style="padding-left: 50px;">
            	<li role="presentation"><a id="leftNav">[教师：${sessionScope.user.name}]</a></li>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-searchCollegeFile">课程文件查询</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-createCollegeFile" >上传课程文件</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-searchCollegeVideo" >课程视频查询</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-createCollegeVideo" >上传课程视频</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-createDiscuss" >新增讨论</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-searchDiscuss" >话题查询</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-createTask" >添加作业</a></li>--%>
                <%--<li role="presentation"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-searchTask">作业信息查询</a></li>--%>
                <li role="presentation" style="float:right;padding-right: 50px;"><a href="javascript:void(0);" class="wk-main-menu-item" id="wk-menu-panel-item-exit">注销登录</a></li>
            </ul>
        </div>
    </div>
    
    <div class="row" style="padding: 20px 50px 50px 50px;">
        <div class="col-lg-2" id="wk-menu-panel" style="display: none;">
            <div class="row">
                <div class="col-lg-12">
                    <%--<div class="panel panel-default wk-menu-panel-header">--%>
                        <%--<div class="panel-body wk-menu-panel-body">--%>
                           	 <%--[教师]管理面板--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-group wk-accordion-panel-group" id="accordion">
                        
                        <div class="panel panel-info wk-accordion-header">
                            <div class="panel-heading"> 
                                <a data-toggle="collapse" href="#BMenu" data-parent="#accordion">课程文件管理</a>
                            </div>
                             <div id="BMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-createCollegeVideo"> >&nbsp;&nbsp;上传课程视频</button>
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-searchCollegeVideo"> >&nbsp;&nbsp;查询上传的视频</button>
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-createCollegeFile"> >&nbsp;&nbsp;上传课程文档</button>
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-searchCollegeFile"> >&nbsp;&nbsp;查询上传的文档</button>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-info wk-accordion-header">
                            <div class="panel-heading">
                                <a data-toggle="collapse" href="#CMenu" data-parent="#accordion">讨论管理</a>
                            </div>
                           
                            <div id="CMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-createDiscuss"> >&nbsp;&nbsp;新增讨论</button>
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-searchDiscuss"> >&nbsp;&nbsp;讨论信息查询</button>
                                </div>
                            </div>

                        </div>
                        
                        <div class="panel panel-info wk-accordion-header">
                            <div class="panel-heading">
                                <a data-toggle="collapse" href="#DMenu" data-parent="#accordion">作业管理</a>
                            </div>
                            <div id="DMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-createTask"> >&nbsp;&nbsp;发布作业</button>
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-searchTask"> >&nbsp;&nbsp;作业信息查询</button>
                                    <!-- <button type="button" class="list-group-item" id="wk-menu-panel-item-searchTask"> >&nbsp;&nbsp;作业完成情况查询</button> -->
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-info wk-accordion-header">
                            <div class="panel-heading"> 
                                <a data-toggle="collapse" href="#EMenu" data-parent="#accordion">个人信息管理</a>
                            </div>
                            <div id="EMenu" class="panel-collapse collapse">    
                                <div class="list-group wk-accordion-list-group">
                                    <button type="button" class="list-group-item" id="wk-menu-panel-item-updateTeacherInfo"> >&nbsp;&nbsp;个人信息修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="rightTable" class="col-lg-10" style="padding:0px; width: 100%;">
            <iframe id="mainFrame" src="<%=basePath%>/searchNotice.html" width="100%" frameborder="0" onload="changeFrameHeight()">
                
            </iframe>

        </div>
    </div>
    
    <div class="modal fade" tabindex="-1" role="dialog" id="exitConfirm">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header wk-modal-header">
					<button class="close" type="button" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="confirmStyle">自主学习平台</h4>
					<h4>系统提示</h4>
				</div>
				<div class="modal-body">【注意】:您确定要退出系统！！</div>
				<div class="modal-footer wk-modal-footer">
					<button id="exitOK" type="submit"
						class="btn btn-default wk-btn" data-dismiss="modal">确定</button>
					<button type="button" class="btn btn-default wk-tool-btn"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

    <script>
        $(document).ready(function(){
            var flag=true;
            $("#rightTable").css("width", "84%");
            $("#rightTable").css("margin-left", "0px");
            $("#wk-menu-panel").css("width", "15%");
            $("#wk-menu-panel").css("display", "block");
            flag=false;
        });
    
        function changeFrameHeight() {
            var ifm= document.getElementById("mainFrame"); 
            ifm.height = document.documentElement.clientHeight - $("#wk-nav-menu").height() - $("#banner").height() - 9;
        }
        window.onresize=function(){  
             changeFrameHeight();  
        } 
        
        changeMenuPanelHeight();
        function changeMenuPanelHeight() {
            var panel= $("#wk-menu-panel"); 
            panel.height(document.documentElement.clientHeight - $("#wk-nav-menu").height() - $("#banner").height() - 3);
            
        }
        window.onresize=function(){  
             changeMenuPanelHeight();  
        } 
        
        
        $(".list-group-item").each(function() {
            $(this).on("click", function() {
                var url = "";
                var id = $(this).attr("id").substr(19, $(this).attr("id").length);
                
                $("#mainFrame").attr("src",  "<%=basePath%>" + id + ".html"); 
            });
        });

        $(".wk-main-menu-item").each(function() {
            $(this).on("click", function() {
                var url = "";
                var id = $(this).attr("id").substr(19, $(this).attr("id").length);
                if(id=="exit"){
                	//exit
                	$("#exitConfirm").modal();
                    $("#exitOK").on("click", function() {
                        location.href = "<%=basePath%>logout.html";
                    });
                }else{
	                url="<%=basePath%>" + id + ".html";
	                $("#mainFrame").attr("src",  url);  
                }
            });
        });

        $(".myInfo").each(function() {
            $(this).on("click", function() {
                $("#mainFrame").attr("src",  "<%=basePath%>" + "updateTeacherInfo.html");  
            });
        });
        
    </script>

</body>
</html>