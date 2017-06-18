<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>招标市场</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/jiaoyi.css" rel="stylesheet">
    <link href='image/favicon.ico' rel='icon' type='image/x-icon'/>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">创客网</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav ">
                         <li><a href="index.jsp">首页</a></li>
               			 <li><a href="showPersonList">人才市场</a></li>
                		 <li class="active"><a href="#">招标市场</a></li>
                 		 <li><a href="youxiu.jsp">优秀作品</a></li>
                		  <li><a href="fileterWriteBlog">写博客</a></li>
                 		<li><a href="fileterSendValidation">发布需求</a></li>
               			 <li><a href="showHouse">我的空间</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="fuwu.html">服务大厅</a></li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>

<div class="row container center-block">
	<c:forEach items="${requestScope.validationList}" var="validation">
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail" style="width: 250px;height:350px" >
            <img src="image/d${validation.vid%18 }.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>${validation.vprofile },暂${validation.vid }定价格为<span style="color: red">${validation.vmoney }元</span>价格可详谈.</p>
                <a href="ShowValidation?validationId=${validation.vid }" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
    </c:forEach>
  <!--   <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d10.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款在线服务的家政网站,需要对数据的处理能力敏捷，主要风格以符合我们的理念，干净简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d11.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机园艺APP,主要功能有修剪和售卖，风格要清新,andiron和ios版暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d9.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款约骑行且交友手机APP,其中可以退出一系列活动，主要风格以中色系为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
</div>
<div class="row container center-block">
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d5.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d6.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d7.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>

    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d8.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
</div>
<div class="row container center-block">
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d9.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d10.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d11.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>

    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="image/d12.jpg"
                 alt="通用的占位符缩略图">
            <div class="caption">
                <p>想开发一款交友手机APP,主要风格以简约为主,暂定价格为<span style="color: red">5000元</span>价格可详谈.</p>
                <a href="../html/yiya.html" class="btn btn-primary btn-sm" role="button">
                    详细了解
                </a>
            </div>
        </div>
    </div> -->
</div>
<div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}"><a href="showZhaobiaoList?currentPage=1">首页</a> | 
	<a href="showZhaobiaoList?currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="showZhaobiaoList?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="showZhaobiaoList?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;&nbsp;&nbsp;
	当前为第${page.currentPage}页,共${page.totalPage}页
	</div>
<footer>
    <p><a href="#">Back to top</a></p>
    <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>

<!--<hr class="featurette-divider">-->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>