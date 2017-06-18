<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>发布需求</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/fabuxuqiu.css">>
  </head>
  <body>
   <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">创客网</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav ">               
                 <li><a href="index.jsp">首页</a></li>
                <li><a href="showPersonList">人才市场</a></li>
                <li><a href="showZhaobiaoList">招标市场</a></li>
                <li><a href="youxiu.jsp">优秀作品</a></li>
                 <li><a href="fileterWriteBlog">写博客</a></li>
                <li class="active"><a href="#">发布需求</a></li>
                <li><a href="showHouse">我的空间</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li ><a href="login.html">退出登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
   
<div class="contact-section" id="contact">
        <div class="container">
          <h3>描述需求</h3>
           <div class="contact-details">
       <form action="PublishTender" method="Post">
         <div class="col-md-6 contact-left">
           <input name="vname" type="text" class="text" value="项目名称 *" >
           <input name="vmoney"  type="text" class="text" value="项目报价 *" >
          <input name="vprofile"  type="text" class="text" value="招标摘要"  > 
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
         <div class="col-md-6 contact-right">
           <textarea  name="vtext" value="项目详细描述" >项目详细描述 *</textarea>
           <input type="submit" value="提交"/>
         </div>
         <div class="clearfix"> </div>
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
