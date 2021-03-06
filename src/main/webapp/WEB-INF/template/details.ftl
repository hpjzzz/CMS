<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>源码物流校招</title>
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css" />
    <!--引入bootstrap样式文档-->
    <link rel="stylesheet" href="/css/bootstrap.min.css" />

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/commons.css" />
</head>

<body>
<!--职位列表-->
<div id="tvalue">
    <input type="hidden" id="ttitle" value="${title}">
    <input type="hidden" id="tdescribes" value="${describes}">
    <input type="hidden" id="trequires" value="${requires}">
</div>
<div class="container nav-next-element" style="border: 1px solid #dcdcdc;padding-top: 30px;padding-bottom: 30px;">
			<span>
				<img src="/imgs/join_us_title.jpg" alt="">
			</span>
    <!--职位名称-->
    <div class="col-md-offset-1" style="padding-top: 30px;">
        <img src="/imgs/join_us_icon.jpg" style="float: left;margin-right: 30px;" />
        <h3 id="title"></h3>
    </div>
    <!--职位描述-->
    <div class="col-md-offset-1" style="padding-top: 36px;">
        <h4 style="float: left;margin-right: 30px;">职位描述：</h4>
        <p id="describes" style="float: left;font-size: 12px;color: #575656;line-height: 40px;"></p>
        <div style="clear: both;"></div>
    </div>
    <!--任职要求-->
    <div class="col-md-offset-1" style="padding-top: 36px;">
        <h4 style="float: left;margin-right: 30px;">任职要求：</h4>
        <p id="requires" style="float: left;font-size: 12px;color: #575656;line-height: 40px;"></p>
        <div style="clear: both;"></div>
    </div>
</div>
<!--底部-->
<div class="container-fluid footer-common">
    <p>
        <a href="index.html" class="out-border-left">招聘首页</a>
        <a href="about.html" class="out-border-left">走进源码</a>
        <a href="talents.html" class="out-border-left">人才发展</a>
        <a href="join_us_info.html" class="out-border-left">职位列表</a>
        <a href="qa.html" class="out-border-left">Q&A</a>
    </p>
    <p>企业邮箱：test@test688.com </p>
    <p>电话热线：4000-888-888 传真：020-3333-3333</p>
    <p>公司地址:四川省成都市高新区府城大道西段399号天府新谷1号楼6F</p>
    <p>源码物流版权所有 Copyright © 2018 jobs.digitalchina.ourats.com All rights reserved.蜀ICP备18080118号-1</p>
</div>
</body>
<script>
    // $(function () {
    //     var id = location.href.split("?")[1];
    //     $.ajax({
    //         url:"/job/findOne?"+id,
    //         type:"post",
    //         success:function (data) {
    //             console.debug($("#title"))
    //             $("#title").append(data.title);
    //             $("#describes").append(data.describes);
    //             $("#requires").append(data.requires);
    //         }
    //     })
    // })
    $(function () {
        var tit = $("#ttitle").val();
        var dec = $("#tdescribes").val();
        var requ = $("#trequires").val();
        $("#title").append(tit);
        $("#describes").append(dec);
        $("#requires").append(requ);
        }
    )();
</script>
</html>