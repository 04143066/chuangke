<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href='image/favicon.ico' rel='icon' type='image/x-icon' />
<title>首页</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>
<body>
	<div class="navbar-wrapper navbar-fixed-top">
		<div class="container-fluid">
			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">创客网</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav ">
						<li><a href="index.jsp">首页</a></li>
                		<li><a href="showPersonList">人才市场</a></li>
                		<li><a href="showZhaobiaoList">招标市场</a></li>
               			 <li><a href="youxiu.jsp">优秀作品</a></li>
                		 <li><a href="fileterWriteBlog">写博客</a></li>
                 		<li><a href="fileterSendValidation">发布需求</a></li>
                		<li><a href="showHouse">我的空间</a></li>
					</ul>

				</div>
			</div>
			</nav>

		</div>
	</div>
	<div class="container"
		style="margin-top: 80px; background-color: #9CA69D">
		<h3 class="text-center">需求描述</h3>
		<hr>
		<div class="row">
			<div class="col-xs-4">
				<h4>项目名称</h4>
				<p><strong>${validation.vname }${validation.vid }</strong></p><br><br>
				<h4>项目摘要</h4>
				<p><strong>${validation.vprofile }</strong></p><br><br>
				<h4>项目状态</h4>
				<c:if test="${validation.vstate=='0'}">
					<strong>无人投标</strong>&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${validation.vtenderee == user.uid}">
						<a class="btn btn-default" href="deleteValidation?validationId=${validation.vid }">删除招标信息</a>
					</c:if>
					<c:if test="${validation.vtenderee != user.uid}">
						<a class="btn btn-default" href="tendValidation?validationId=${validation.vid }">投标</a>
					</c:if>
				</c:if>
				<c:if test="${validation.vstate=='1'}">
					<strong>已投标</strong>&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${validation.vtenderee == user.uid}">
						<a class="btn btn-default" href="agreeValidation?validationId=${validation.vid }">达成协议</a>
						&nbsp;&nbsp;&nbsp;<a class="btn btn-default" href="showHouse?userId=${validation.vtenderer }">查看投标人</a>
					</c:if>
				</c:if>
				<c:if test="${validation.vstate=='2'}">
					<strong>项目进行中</strong>&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${validation.vtenderee == user.uid}">
						<a class="btn btn-default" href="endValidation?validationId=${validation.vid }">结束项目</a>
					</c:if>
				</c:if>
				<c:if test="${validation.vstate=='3'}">
					<strong>项目交接完成</strong>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<br><br>
				
				<%-- ${validation.vstate }<br/> --%>
				<h4>项目酬金</h4>
				<p><strong>${validation.vmoney }</strong></p><br><br>
			</div>
			<div class="col-xs-8 text-center">
				<h4>标书详细信息</h4>
				<p>${validation.vtext }</p>
			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="js/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>