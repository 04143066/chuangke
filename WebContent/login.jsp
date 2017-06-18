<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script type="text/javascript">
	function refresh() {
		var img = document.getElementById("img_validation_code")
		img.src = "ValidationCode?" + Math.random();
	}
	function checkLogin() {
		
		 var inputEmail = document.getElementById("inputEmail");
		if (inputEmail.value == "") {
			alert("必须输入用户名!");
			inputEmail.focus();
			return;
		}
		
		var user_passwd = document.getElementById("inputPassword");
		if (user_passwd.value == "") {
			alert("必须输入密码!");
			user_passwd.focus();
			return;
		} 
		
		var validation_code = document.getElementById("validation_code");
		if (validation_code.value == "") {
			alert("验证码必须输入!");
			validation_code.focus();
			return;
		}		
		form_login.submit();
	}
</script>
</head>
<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
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
			<ul class="nav navbar-nav">
				 <li><a href="index.jsp">首页</a></li>
                <li><a href="showPersonList">人才市场</a></li>
                <li><a href="showZhaobiaoList">招标市场</a></li>
                <li><a href="youxiu.jsp">优秀作品</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<div class="container-fluid content">

		<form name="form_login" class="form-signin" action="Login"
			method="post">
			<h2 class="form-signin-heading">登录</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				name="user_name" type="text" id="inputEmail" class="form-control"
				placeholder="用户名" required autofocus> &nbsp;&nbsp;<font
				color="#FF0000">${requestScope.userError}</font> <label
				for="inputPassword" class="sr-only">Password</label> <br>
			<input type="password" name="user_passwd" id="inputPassword"
				class="form-control" placeholder="密码" required>&nbsp;&nbsp;
			<font color="#FF0000">${requestScope.passwordError}</font>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<div class="name_list font_space float_left">验证码：</div>
			<div class="input_list1 font_space float_left">
				<img id="img_validation_code" src="ValidationCode"
					style="width: 80px; height: 30px;" /> <input type="text"
					id="validation_code" name="validation_code"
					style="width: 60px; margin-top: 2px" size="30" maxlength="30" /> <input
					type="button" value="刷新" onclick="refresh()" /> &nbsp;&nbsp;<font
					color="#FF0000">${requestScope.codeError}</font>
			</div>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="button"
				onclick="checkLogin()">登 录</button>
		</form>
		<form  class="form-signin" action="register.jsp"
			method="post">
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				>注册</button>
		</form>
	</div>
	<!-- /container -->
	<footer class="blog-footer">
	<p>
		Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
		by <a href="https://twitter.com/mdo">@mdo</a>.
	</p>
	<p>
		<a href="#">Back to top</a>
	</p>
	</footer>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>