<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/resign.css" rel="stylesheet">
    <link href='image/favicon.ico' rel='icon' type='image/x-icon'/>
</head>
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
                 <li><a href="fileterWriteBlog">写博客</a></li>
                 <li><a href="fileterSendValidation">发布需求</a></li>
                <li><a href="showHouse">我的空间</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container content xiugai">
      <h3 class="text-center">修改信息</h3>
     <form name="register_form" class="form-signin" action="changeziliao" method="post">
        <label for="inputUsername" class="sr-only">username</label>
        <input value="${user.uname }" type="text" name="user_name" id="inputUsername" class="form-control" placeholder="姓名" required autofocus><br>
        <label for="inputSex" class="sr-only">sex</label>
        <input  name="user_sex" type="radio" value="1" checked>男
        <input name="user_sex" type="radio" value="0">女
        <label for="inputAge" class="sr-only">sex</label>
        <input value="${user.uage }"type="text" name="user_age" id="inputAge" class="form-control" placeholder="年龄" required>
        <label for="inputName" class="sr-only">name</label>
        <input value="${user.upasswd }"type="password" name="user_passwd" id="inputPassword" class="form-control" placeholder="密码" required>
        <label for="inputTell" class="sr-only">sex</label>
        <input value="${user.utell }"type="text" name="user_tell" id="inputTell" class="form-control" placeholder="电话" required>
        <label for="inputBirthday" class="sr-only">birthday</label>
        <input value="${user.ubirthday }" type="date" name="user_birthday" id="inputBirthday" class="form-control" placeholder="出生日期" required>
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
        </div>
        <label for="inputProfile" class="sr-only">sex</label>
        <input value="${user.uprofile }" name="user_profile" type="text" id="inputProfile" class="form-control" placeholder="个人简介" required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >提 交</button>
    </form>

</div> <!-- /container -->
<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com">AllianceTeam</a> by <a href="https://twitter.com/mdo">@mdo</a>.
    </p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>