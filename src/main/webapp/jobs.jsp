<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/27
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!--导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!-- 导航上Logo和目录显示 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#index-navbar" aria-expanded="false">
                <span class="sr-only">导航目录</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:void(0);">源码物流校园招聘网</a>
        </div>

        <!-- 导航上其他按钮-->
        <div class="collapse navbar-collapse navbar-right" id="index-navbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="index.html">首页</a>
                </li>
                <li>
                    <a href="about.html">走进源码</a>
                </li>
                <li>
                    <a href="talents.html">人才发展</a>
                </li>
                <li>
                    <a href="javascript:void(0);">职位列表</a>
                </li>
                <li>
                    <a href="qa.html">Q&A</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--职位搜索-->
<div class="container" style="border: 1px solid #dcdcdc;padding-top: 30px;padding-bottom: 30px;margin-top: 60px;">
			<span>
				<img src="imgs/join_us_search.jpg" alt="">
			</span>
    <div class="row" style="padding-top: 30px;">
        <form class="form-inline" action="/show/jobs">
            <input name="currentPage" type="hidden" value="1">
            <div class="form-group col-md-3">
                <label for="title">职位名称</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="职位名称">
            </div>
            <div id="worktime" class="form-group col-md-3" style="padding-top: 5px;">
                <label for="workingTime">工作时间:</label>
                <label class="radio-inline">
                    <input type="radio" name="workingTime" id="workingTime" value="1"> 全部
                </label>
                <label class="radio-inline">
                    <input type="radio" name="workingTime" id="workingTime" value="2"> 全职
                </label>
                <label class="radio-inline">
                    <input type="radio" name="workingTime" id="workingTime" value="3"> 兼职
                </label>
            </div>
            <button id="sub" type="submit" class="btn btn-default">搜索职位</button>
        </form>
    </div>
</div>
<!--职位列表-->
<div class="container job-table">
			<span>
				<img src="/imgs/index_title_zw.jpg" alt="">
				<img src="/imgs/index_title_more.jpg" alt="">
			</span>
    <table id="jobs" class="table table-hover">
        <tr>
            <th class="hidden-sm">编号</th>
            <th>工作职位</th>
            <th>地点</th>
            <th>人数</th>
            <th>薪资待遇</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
    </table>
    <!--分页-->
    <nav class="navbar-right">
        <ul class="pagination" id="paging">
        </ul>
    </nav>
</div>
<!--友情链接  手机端的时候，就隐藏掉-->
<div class="container hidden-xs hidden-sm" id="footer-link">
    <img src="/imgs/index_link_img.jpg" alt="" class="out-border-left">
    <a href="" class="out-border-left">源码时代官网</a>
    <a href="" class="out-border-left">BootStrap官网</a>
</div>
<!--底部-->
<div class="container-fluid footer-common">
    <p>
        <a href="javascript:void(0);" class="out-border-left">招聘首页</a>
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
    function getCondition(){
        var conditions="currentPage=1&title=false&workingTime=1";
        if (location.href.split("?")[1]!=null){
            conditions = location.href.split("?")[1];
            var currentPage = conditions.split("&")[0];
            currentPage = currentPage?currentPage:"currentPage=1";
            var title = decodeURIComponent(conditions.split("&")[1].split("=")[1]);
            if (title == null|| title.trim().length==0) {
                title="title=false";
            }else {
                title = "title="+title.trim();
            }
            var workingTime = conditions.split("&")[2];
            if (conditions == null) {
                return currentPage;
            }else {
                return currentPage+"&"+title+"&"+workingTime;
            }
        } else {
            return conditions;
        }
    }
    var conditions={
        title:function () {
            console.debug(getCondition().split("&")[1])
            return getCondition().split("&")[1]
        },
        workingTime:function () {
            return getCondition().split("&")[2]
        }
    };
    function getList() {
        $.ajax({
            type: "post",
            url: "/job/page?"+getCondition(),
            success: function (data) {
                // console.debug(data.list)
                for (var i = 0; i < data.list.length; i++) {
                    $("#jobs").append('<tr>' +
                        '<th>' + data.list[i].id + '</th>' +
                        "<th>"+data.list[i].title+"</th>" +
                        '<th>' + data.list[i].address + '</th>' +
                        "<th>"+data.list[i].jobnum+"</th>" +
                        "<th>"+data.list[i].treatment+"</th>" +
                        "<th>"+data.list[i].inputdate+"</th>"+
                        "<th><a href='"+data.list[i].htmlurl+"'>职位详情</a></th>"
                    )
                }
                //分页菜单
                $("#paging").append(
                    "<li><span>当前第"+data.currentPage+"页</span></li>"+
                    "<li><a href='/show/jobs?currentPage=1&title=false'><span aria-hidden='true'>首页</span></a> </li>"+
                    "<li><a href='/show/jobs?currentPage="+data.prePage+"&"+conditions.title()+"&"+conditions.workingTime()+"' aria-label='上一页'><span aria-hidden='true'>上一页</span></a> </li>"+
                    "<li></li><li><a href='/show/jobs?currentPage="+data.nextPage+"&"+conditions.title()+"&"+conditions.workingTime()+"' aria-label='下一页'><span aria-hidden='true'>下一页</span></a></li>"+
                    "<li><a href='/show/jobs?currentPage="+data.lastPage+"&"+conditions.title()+"&"+conditions.workingTime()+"' aria-label='尾页'><span aria-hidden='true'>尾页</span></a></li>"+
                    "<li><span>总页数：共"+data.totalPage+"页</span><span>总数据：共"+data.totalData+"条</span></li>"
                )
            }
        })
    };
    $(function () {
        getList();
        var con = getCondition();
        worktime = con.split("&")[2].split("=")[1];
        console.debug(worktime);
        if (worktime == 1) {
            $("#worktime>label>input").eq(0).attr("checked",true)
        }else if (worktime == 2) {
            $("#worktime>label>input").eq(1).attr("checked",true)
        }else if (worktime == 3) {
            $("#worktime>label>input").eq(2).attr("checked",true)
        }
        if (con.split("&")[1].split("=")[1]!='false'){
            $("#title").val(con.split("&")[1].split("=")[1])
        }
    });
</script>
</html>
