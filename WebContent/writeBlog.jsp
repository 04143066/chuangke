<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>写博客</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/fabuxuqiu.css">
<script language="javascript" type="text/javascript"> 
       
	function test() {

		var blog_title = document.getElementById("blog_title");
		if (blog_title.value == "") {
			alert("必须输入标题!");
			blog_title.focus();
			return;
		}

		var blog_title = document.getElementById("blog_title");
		if (blog_title.value == "") {
			alert("必须输入标题!");
			blog_title.focus();
			return;
		}

		var blog_text = document.getElementById("blog_text");
		if (blog_text.value == "") {
			alert("必须输入摘要!");
			blog_title.focus();
			return;
		}

		var blog_neirong = document.getElementById("blog_neirong");
		if (blog_neirong.value == "") {
			alert("必须输入标题!");
			blog_neirong.focus();
			return;
		}

		//setTimeout("javascript:location.href='gerenkongjian.html'", 5000); 
		Writeblog_form.submit();
	}
</script>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container">

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
					<a class="navbar-brand" href="#">创客网</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav "> 
                        <li><a href="index.jsp">首页</a></li>
               			 <li><a href="showPersonList">人才市场</a></li>
                		<li><a href="showZhaobiaoList">招标市场</a></li>
               			 <li><a href="youxiu.jsp">优秀作品</a></li>
               			<li class="active"><a href="#">写博客</a></li>
                 		<li><a href="fileterSendValidation">发布需求</a></li>
              		   <li><a href="showHouse">我的空间</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="login.html">退出登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>

	<div class="contact-section" id="contact">
		<div class="container">
			<h3>技术博客</h3>
			<div class="contact-details">
				<form name="Writeblog_form" action="WriteBlog" method="post">

					<div class="col-md-6 contact-left">
						<input id="blog_title" name="blog_name" type="text" class="text" value="标题 *"> <input
							id="blog_tags" name="blog_tags" type="text" class="text" value="描述 *"> <input
							type="checkbox" name="vehicle" value="1" />网站开发 <input
							type="checkbox" name="vehicle" value="2" />设计与广告 <input
							type="checkbox" name="vehicle" value="4" />营销推广 <input
							type="checkbox" name="vehicle" value="8" />电路设计
					</div>
					<div class="col-md-7 contact-right">
						<textarea id="blog_neirong" name="blog_text" value="博客内容">博客内容*</textarea>
						<button type="submit" class="btn btn-primary" data-toggle="modal"
							data-target="#myModal" >提交</button>

						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">5秒后自动跳转到博客页面</div>
								</div>
							</div>
						</div>

					</div>
			</div>
			<div class="clearfix"></div>
			</form>
		</div>
	</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
