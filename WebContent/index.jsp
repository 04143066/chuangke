<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="fonts/favicon.ico">

    <title>首页</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/ie-emulation-modes-warning.js"></script>
    <link href="css/index.css" rel="stylesheet">
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
                 <li  class="active"><a href="#">首页</a></li>
                 <li><a href="showPersonList">人才市场</a></li>
                 <li><a href="showZhaobiaoList">招标市场</a></li>
                 <li><a href="youxiu.jsp">优秀作品</a></li>
                 <li><a href="fileterWriteBlog">写博客</a></li>
                 <li><a href="fileterSendValidation">发布需求</a></li>
                 <li><a href="showHouse">我的空间</a></li>
              </ul>
              <c:choose>
			<c:when test="${empty sessionScope.userid}">
			<ul class="nav navbar-nav navbar-right">
                <li ><a href="login.jsp">登录</a></li>
                <li ><a href="register.jsp">注册</a></li>
              </ul> 
		</c:when>
		<c:otherwise>
			
			  <ul class="nav navbar-nav navbar-right">
                <li ><a href="#">${sessionScope.username},欢迎您！</a></li>
              </ul> 
			
		</c:otherwise>
	</c:choose>
                           
            </div>
          </div>
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <!-- <img class="first-slide" src="#" alt="First slide"> -->
          <div class="container">
            <div class="carousel-caption">
              <h1>每天都是618</h1>
              <p>爱特爱会品牌设计，logo设计1000元起.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">了解</a></p>
            </div>
          </div>
        </div>
        <div class="item">
         <!--  <img class="second-slide" src="#" alt="Second slide"> -->
          <div class="container">
            <div class="carousel-caption">
              <h1>最美青年</h1>
              <p>5月4日，是青年人的节日，用青春去改变，用热情去挥洒，可能有人会说青春有挥霍，但是却不能否定青春的激情与创造。恰逢五四青年节，</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">了解</a></p>
            </div>
          </div>
        </div>
        <div class="item">
         <!--  <img class="third-slide" src="#" alt="Third slide"> -->
          <div class="container">
            <div class="carousel-caption">
              <h1>企业宗旨</h1>
              <p>做最受客户尊重的O2O软件方案供应商，为客户提供最优质的服务</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="image/1.jpg" alt="Generic placeholder image" width="140" height="140">
          <h3><a class="btn btn-default" href="#" role="button">攀沿不止&raquo;</a></h3>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="image/2.jpg" alt="Generic placeholder image" width="140" height="140">
          <h3><a class="btn btn-default" href="#" role="button">永不止步 &raquo;</a></h3>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="image/3.jpg" alt="Generic placeholder image" width="140" height="140">
          <h3><a class="btn btn-default" href="#" role="button">心向辉煌 &raquo;</a></h3>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">网站功能. <span class="text-muted"></span></h2>
          <p class="lead"> 创客网是服务众包平台，由ALLICETEAM小组创办于2016年，服务交易品类涵盖创意设计、网站建设、网络营销、文案策划、生活服务等多种行业。创客网有百万服务商为企业、公共机构和个人提供定制化的解决方案，将创意、智慧、技能转化为商业价值和社会价值。.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="image/5.jpg" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">核心价值. <span class="text-muted"></span></h2>
          <p class="lead">对于买家来说，把需要解决的问题放在猪八戒网上，通过悬赏模式可以获得多种方案，可以选到百里挑一的作品；通过速配模式，可以寻找到能力精准匹配的服务商来提供服务。总而言之，企业机构和个人可以在猪八戒网获得低成本、高效益的服务。
对于服务商来说，无论是个人还是机构企业，都可以在猪八戒网上做自己喜欢或擅长的工作，足不出户找到目标客户，挣得真金白银。而且工作环境更加自由，工作时间自己掌控。可以说，猪八戒网也是一个人才成长平台。许多服务商通过在猪八戒网上做任务，不仅锻炼了专业技能以及客户沟通技巧，同时也加深了对行业市场的了解，积累了客户资源.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="image/6.jpg"alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">成员介绍 <span class="text-muted"></span></h2>
          <p class="lead">ALLICETEAM小组，创客网创始人。成员包括负责人刘瑞阳，成员豆青，王谢，邹雄鑫，仲娟婷，胡之林，依托猪八戒网这个新媒体平台，致力于创意和营销领域的研究和实践，创建“中国百强商业网站“.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="image/6.jpg"alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->

      <div class="service-section" id="service">
        <div class="container">

    <div class="service-grids">
              <div class="col-md-4 service-grid">
                  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                <h4>技术支持</h4>
                <span> </span>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
              </div>
              <div class="col-md-4 service-grid">
                <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                <h4>建议交流</h4>
                <span> </span>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
              </div>
              <div class="col-md-4 service-grid">
                <span class="glyphicon glyphicon-signal" aria-hidden="true"></span>
                <h4>网络维护</h4>
                <span> </span>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
              </div>
              <div class="clearfix"> </div>
            </div>
          </div>
        </div>
      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


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
</html>
