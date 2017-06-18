<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人空间</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script src="js/ie-emulation-modes-warning.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='image/favicon.ico' rel='icon' type='image/x-icon' />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Skills Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
<script src="js/jquery-1.11.1.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
<script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
        });
    </script>
<!---End-smoth-scrolling---->

</head>
<body>
	<div class="navbar-wrapper">
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
						<li class="active"><a href="#">我的空间</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="prechangeziliao?userId=${user.uid }">修改资料</a></li>
						<li><a href="tuichu">退出登录</a></li>
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>
	<div class="header-section">
		<div class="container" style="margin-left: 60px">
			<form>
				<img src="image/p1.png"
					onclick="document.querySelector('#fileInput').click()" /> <input
					type="file" id="fileInput" name="file" multiple size="200"
					style="display: none">
			</form>
		</div>
	</div>
	<div class="study-section">
		<div class="container">
			<div class="study-grids">
				<div class="col-md-7 study-grid">
					<h3>博客展示</h3>
					<div class="study1">
						<c:forEach items="${requestScope.blogList }" var="blog">
							<p>
								<a class="成果一" href="showBlog?blogId=${blog.bid}">${blog.bname}</a><label>${blog.bdate}</label>
							</p>
						</c:forEach>
						<p>&nbsp;</p>
						<div align="center">
							<c:choose>
								<c:when test="${page.hasPrePage}">
									<a href="showHouse?currentPage=1&userId=${user.uid}">首页</a> | 
	<a href="showHouse?currentPage=${page.currentPage -1 }&userId=${user.uid}">上一页</a>
								</c:when>
								<c:otherwise>
			首页 | 上一页
		</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${page.hasNextPage}">
									<a href="showHouse?currentPage=${page.currentPage + 1 }&userId=${user.uid}">下一页</a> | 
	<a href="showHouse?currentPage=${page.totalPage }&userId=${user.uid}">尾页</a>
								</c:when>
								<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
							</c:choose>
							&nbsp;&nbsp;&nbsp;&nbsp;
							当前为第${page.currentPage}页,共${page.totalPage}页
						</div>
					</div>
				</div>

				<div class="col-md-5 study-grid">
				     <h3>个人资料</h3>
				     <p>姓名:&nbsp;<strong>${user.uname }</strong></p>
				     <p>年龄:&nbsp;<strong>${user.uage }</strong></p>
				     <p>电话号码:&nbsp;<strong>${user.utell }</strong></p>
				     <p>个人简介:&nbsp;<strong>${user.uprofile }</strong></p>
				     
				    <hr>
					<h3>
						&nbsp;&nbsp;项目列表<span></span>
					</h3><br>
					<h4>招标项目</h4>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							已完成项目 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<c:forEach items="${requestScope.validationsList}" var="validation">
								<li><a href="ShowValidation?validationId=${validation.vid }">${validation.vname }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							正在进行 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<c:forEach items="${requestScope.validationsLis}" var="validatio">
								<li><a href="ShowValidation?validationId=${validatio.vid }">${validatio.vname }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							无人投标 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<c:forEach items="${requestScope.validationsLi}" var="validati">
								<li><a href="ShowValidation?validationId=${validati.vid }">${validati.vname }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							已投标 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<c:forEach items="${requestScope.validationsList1}" var="validation">
								<li><a href="ShowValidation?validationId=${validation.vid }">${validation.vname }</a></li>
							</c:forEach>
						</ul>
					</div>
					<hr>
					<h4>投标项目</h4>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							已完成项目 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">咿呀母婴网站</a></li>
							<li><a href="#">果蔬鲜网站</a></li>
							<li><a href="#">轻聊app</a></li>
							<li><a href="#">淘货网站</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							正在进行 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">咿呀母婴网站</a></li>
							<li><a href="#">果蔬鲜网站</a></li>
							<li><a href="#">轻聊app</a></li>
							<li><a href="#">淘货网站</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button"
							class="btn btn-default dropdown-toggle btn-lg"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							未完成 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">咿呀母婴网站</a></li>
							<li><a href="#">果蔬鲜网站</a></li>
							<li><a href="#">轻聊app</a></li>
							<li><a href="#">淘货网站</a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	</div>
	<!--end-map-section-->
	<!--start-footer-section-->
	<div class="footer-section">
		<div class="container">
			<div class="footer-top">
				<p>
					&copy; 2015 <span>Welcome</span> All rights reserved | Design by <a
						href="http://w3layouts.com">创客团队</a>
				</p>
			</div>
			<script type="text/javascript">
            $(document).ready(function () {

//                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
			<a href="#" id="toTop" style="display: block;"> <span
				id="toTopHover" style="opacity: 1;"> </span></a>
		</div>
	</div>
	<!--end-footer-section-->

	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="js/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
