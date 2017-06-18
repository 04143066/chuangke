<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/resign.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function refresh() {
		var img = document.getElementById("img_validation_code")
		img.src = "ValidationCode?" + Math.random();
	}
	function checkLogin() {
		
		 var user_name = document.getElementById("inputUsername");
		if (user_name.value == "") {
			alert("必须输入用户名!");
			user_name.focus();
			return;
		}
		
		var user_passwd = document.getElementById("inputPassword");
		if (user_passwd.value == "") {
			alert("必须输入密码!");
			user_passwd.focus();
			return;
		} 

		var user_age = document.getElementById("inputAge");
		if (user_age.value == "") {
			alert("必须输入年龄!");
			user_age.focus();
			return;
		} 

		var user_birthday = document.getElementById("inputBirthday");
		if (user_age.value == "") {
			alert("必须输入生日!");
			user_birthday.focus();
			return;
		} 

		var user_tell = document.getElementById("inputTell");
		if (user_tell.value == "") {
			alert("必须输入电话号码!");
			user_tell.focus();
			return;
		} 

		var validation_code = document.getElementById("validation_code");
		if (validation_code.value == "") {
			alert("验证码必须输入！");
			validation_code.focus();
			return;
		}
		
		var user_profile = document.getElementById("inputProfile");
		if (user_profile.value == "") {
			alert("必须输入个人简介!");
			user_profile.focus();
			return;
		} 
		
		var user_group = document.getElementsByName("user_group");
		if (user_group.value == "") {
			alert("至少选一项技能!");
			user_group.focus();
			return;
		}		
		register_form.submit();
	}
</script>
<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
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
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container-fluid content">

    <form name="register_form" class="form-signin" action="DBservlet" method="post">
        <h2 class="form-signin-heading">注册</h2>
        <label for="inputUsername" class="sr-only">username</label>
        <input type="text" name="user_name" id="inputUsername" class="form-control" placeholder="姓名" required autofocus><br>
        <label for="inputSex" class="sr-only">sex</label>
        <input name="user_sex" type="radio" value="1" checked>男
        <input name="user_sex" type="radio" value="0">女
        <label for="inputAge" class="sr-only">sex</label>
        <input type="text" name="user_age" id="inputAge" class="form-control" placeholder="年龄" required>
        <label for="inputName" class="sr-only">name</label>
        <input type="password" name="user_passwd" id="inputPassword" class="form-control" placeholder="密码" required>
        <label for="inputTell" class="sr-only">sex</label>
        <input type="text" name="user_tell" id="inputTell" class="form-control" placeholder="电话" required>
        <label for="inputBirthday" class="sr-only">birthday</label>
        <input type="date" name="user_birthday" id="inputBirthday" class="form-control" placeholder="出生日期" required>
         <span>技能展示</span>
         <div class="checkbox">
          <label>
            <input name="user_group" type="checkbox" value="1">网站开发
          </label>
          <label>
            <input name="user_group" type="checkbox" value="2">设计与广告
          </label>
          <label>
            <input name="user_group" type="checkbox" value="4">营销推广
          </label>
          <label>
            <input name="user_group" type="checkbox" value="8">电路设计
          </label>
        
        <label for="inputProfile" class="sr-only">sex</label>
        <input name="user_profile" type="text" id="inputProfile" class="form-control" placeholder="个人简介" required>
        <div class="name_list font_space float_left">验证码：</div>
			<div class="input_list1 font_space float_left">
				<img id="img_validation_code" src="ValidationCode"
					style="width: 80px; height: 30px;" /> <input type="text"
					id="validation_code" name="validationCode"
					style="width: 60px; margin-top: 2px" size="30" maxlength="30" /> <input
					id="yanzhengma" name="validationCode" type="button" value="刷新" onclick="refresh()" /> &nbsp;&nbsp;<font
					color="#FF0000">${requestScope.codeError}</font>
		</div><br>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="checkLogin()">注  册</button>
    </form>

</div> <!-- /container -->
<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>