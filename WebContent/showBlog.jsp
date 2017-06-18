<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>博客页面</title>
    <link href="css/style1.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href='image/favicon.ico' rel='icon' type='image/x-icon'/>
</head>
<body>
<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <h1>博客展示</h1>
        </div>
    </div>
</div>
<div id="wrapper">
    <!-- end #header -->
    <div id="page">
        <div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">${blog.bname }</a>
							</h2>
							<p class="meta">
								<span class="date">发表时间:${blog.bdate }</span><span
									class="posted">作者: <a href="#">${user.uname }</a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
								<p>${blog.btext }</p>
								<p class="links">
									<a href="#" class="button">Read More</a>
								</p>
							</div>
						</div>
						<div class="post post-alt"></div>
						<div class="post"></div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div id="sidebar">
						<ul>
							<li>
								<h2>评论</h2>
								<div>
									<form method="post" action="sendReply">
										<div>
											<textarea name="rtext" cols="30" rows="3"></textarea>
											<br />
											<br /> <input type="hidden" name="blogId" value="${blog.bid}" />
											<input type="submit" value="提交" />
										</div>
									</form>
								</div>
								<div style="clear: both;">&nbsp;</div>
							</li>

							<li>
								<!-- <h4>
									评论人姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>评论时间</span>
								</h4>
								<h4>Mauris vitae nisl nec metus placerat perdiet est.
									Phasellus dapibus semper consectetuer hendrerit.</h4> --> 
									<c:forEach items="${requestScope.replyList}" var="reply">
										<span>${reply.uname }:&nbsp;</span><strong>${reply.rtext }</strong><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${reply.rdate }</span>
									
								</c:forEach>
								<br>
							</li>
							
						</ul>
						<ul>
						<div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}"><a href="showBlog?currentPage=1">首页</a> | 
	<a href="showBlog?currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="showBlog?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="showBlog?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	
	当前为第${page.currentPage}页,共${page.totalPage}页
	</div>
	</ul>
  </div>
  </div>
				
				
				<!-- end #sidebar -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
    </div>
    <!-- end #page -->
</div>
<div id="footer">
    <p>&copy; 2013 Sitename.com. | Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.
    </p>
</div>
<!-- end #footer -->
</body>
</html>
