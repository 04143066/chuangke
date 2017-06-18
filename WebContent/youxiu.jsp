<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>优秀作品</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/youxiu.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <link rel="icon" href="../fonts/favicon.ico">
    <link href='image/favicon.ico' rel='icon' type='image/x-icon'/>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-inverse navbar-static-top">
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
                    <ul class="nav navbar-nav ">
                         <li><a href="index.jsp">首页</a></li>
               			 <li><a href="showPersonList">人才市场</a></li>
                		 <li><a href="showZhaobiaoList">招标市场</a></li>
                 		 <li class="active"><a href="#">优秀作品</a></li>
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
<div class="container-fluid conten">
    <div class="media container">
        <div class="media-left media-bottom">
            <a href="#">
                <img class="media-object img-rounded" src="image/14.jpg" alt="...">
            </a>
        </div>
        <div class="media-body">
            <p>** 完全背包问题 **<br> 有n个重量和价值分别为wi，vi的物品，从这些物品中挑选出总重量不超过W的物品，
            	每种物品可以挑选多件，求所有挑选方案中价值总和的最大值。 与01背包大同小异，只是现在每件物品可以
            	选择任意多件了，那么每个物体就需要多次考虑，既然要多次考虑，那么就需要一个新参数控制每次考虑的情况。
            	 那么看看这次的情况吧，已经不能按照01背包那样简单的动规了，但是有一点很清楚，我们可以按照01背包的动
            	 规思想：限定重量，求在该限定重量下可以得到的最大价值。 这次的规律也不难，只需要分两种情况： ①：没有可
            	 挑选的物品种类时，直接return 0； ②：如果可以挑选这种物品，就把挑选的次数枚举出来并求最大值就好了；
            	  这里有个我没有列出的条件是重量不能超过W，所以每次挑选时，都要判断这个物品加上后总重量会不会超过W，
            	  如果超过W，那就跳过这种情况，并且这个物品就不需要再加更多次了，因为再加依然会超过W。由于每次都要判断
            	  重量是否超过W，所以我们在01背包的基础上再加一层循环，判断总重量是否超过W就好了。
            </p>


        </div>
    </div>
    <div class="media container conten">
        <div class="media-left media-bottom">
            <a href="#">
                <img class="media-object img-rounded" src="image/d3_1.jpg" alt="...">
            </a>
        </div>
        <div class="media-body">
        	<p><br><br><br>
        	第一卷 标书范本 投 标 书 建设单位：[建设单位名称 ] 1、根据已收到的招标编号为[招标文件编号 ] 的[工程名称 ] 
        	工程的招标文 件，遵照《工程建设施工招标投标管理办法》的规定，我单位经考察现场和研究上述工程招标文件的投标
        	须知、合同条件、技术规范、图纸、工程量清单和其他有关文件后，我方愿以人民币[总造价人民币大写 ] 元的总价，
        	按上述合同条件、技术规范、图纸、工程量清单的条件承包上述工程的施工、竣工和保修。 2、一旦我方中标，我方保证
        	在[ ] 年[ ] 月[ ] 日开工，[ ] 年 [ ] 月[ ] 日竣工，即[施工日历天 ] 天(日历日)内竣工并移交整个工程。
        	 3、如果我方中标，我方将按照规定提交上述总价5%的银行保函或上述总价 10%的由具有独立法人资格的经济实体企业
        	 出具的履约担保书，做为履约保证金，共同地和分别地承担责任。 4、我方同意所递交的投标文件在“投标须知”第11条
        	 规定的投标有效期内 有效，在此期间内我方的投标有可能中标，我方将受此约束。 5、除非另外达成协议并生效，你方的
        	 中标通知书和本投标文件将构成约束 我们双方的合同。 6、我方金额为人民币[投标保证金人民币大写 ] 元的投标保证金
        	 与本投标书 同时递交。 投标单位：[投标单位名称（盖章）] 单位地址：[投标单位地址] 法定代表人：[（签字）、
        	 （盖章）] 邮政编码：[邮政编码] 电话：[电话号码] 传真：[传真] 开户银行名称：[开户银行名称] 银行账号
        	 ：[银行帐号] 开户行地址：[开户行地址] 下载文档到电脑，查找使用更方便 1下载券 6681人已下载 下载 还剩
        	 15页未读，继续阅读.
        	</p>
        </div>
    </div>
    <div class="media container conten">
        <div class="media-left media-bottom">
            <a href="#">
                <img class="media-object img-rounded" src="image/d4_2.jpg" alt="...">
            </a>
        </div>
        <div class="media-body">
      	   <br><br><br>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
			Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.

        </div>
    </div>
    <div class="media container conten">
        <div class="media-left media-bottom">
            <a href="#">
                <img class="media-object img-rounded" src="image/10_4.jpg" alt="...">
            </a>
        </div>
        <div class="media-body">
       		<br><br><br>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras
            purus
            odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
            Donec lacinia congue felis in faucibus.


        </div>
    </div>
</div>
<div class="foot container-fluid">
    <div class="service-section" id="service">
        <div class="container">

            <div class="service-grids">
                <div class="col-md-4 service-grid">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    <h4>技术支持</h4>
                    <span> </span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages
                        containing of Letraset sheets</p>
                </div>
                <div class="col-md-4 service-grid">
                    <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                    <h4>建议交流</h4>
                    <span> </span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages
                        containing of Letraset sheets</p>
                </div>
                <div class="col-md-4 service-grid">
                    <span class="glyphicon glyphicon-signal" aria-hidden="true"></span>
                    <h4>网络维护</h4>
                    <span> </span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages
                        containing of Letraset sheets</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
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
</html>