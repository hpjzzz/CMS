<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 20:23
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
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css"/>
    <!--引入bootstrap样式文档-->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <style>
        .tableA {
            margin-right: 15px;
        }
    </style>
</head>

<body>
<div class="breadcrumbs" id="breadcrumbs">
    <!-- 面包屑导航 -->
    <ul class="breadcrumb">
        <li>
            <a href="javascript:void(0);">Home</a>
        </li>
        <li class="active">轮播管理</li>
    </ul>
</div>
<!--职位列表-->
<div class="container job-table">
    <div>
        <a href="main_add.html" class="btn-default tableA"><span class="glyphicon glyphicon-plus"
                                                                 aria-hidden="true">添加</span></a>
    </div>

    <table id="list1" class="table table-hover">
        <tr>
            <th width="50px">编号</th>
            <th>存储地址</th>
            <th>简述</th>
            <th>是否启用</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        <%--<tr>--%>
        <%--<th>#1</th>--%>
        <%--<th>储备干部</th>--%>
        <%--<th>这是一个孤独的程序员</th>--%>
        <%--<th><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></th>--%>
        <%--<th>[2018-08-01]</th>--%>

        <%--<th>--%>
        <%--<a href="/jump/main_add" class="btn-default tableA"><span class="glyphicon glyphicon-pencil"--%>
        <%--aria-hidden="true">修改</span></a>--%>
        <%--&lt;%&ndash;<a href="" class="btn-default tableA"><span class="glyphicon glyphicon-trash"&ndash;%&gt;--%>
        <%--&lt;%&ndash;aria-hidden="true">删除</span></a>&ndash;%&gt;--%>
        <%--</th>--%>
        <%--</tr>--%>
    </table>
    <!--分页-->
    <nav class="navbar-right">
        <ul class="pagination" id="paging">
            <%--<li>--%>
                <%--<span>当前第1页</span>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#">--%>
                    <%--<span aria-hidden="true">首页</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#" aria-label="上一页">--%>
                    <%--<span aria-hidden="true">上一页</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>

            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#" aria-label="下一页">--%>
                    <%--<span aria-hidden="true">下一页</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#" aria-label="尾页">--%>
                    <%--<span aria-hidden="true">尾页</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<span>总页数：共10页</span>--%>
                <%--<span>总数据：共50条</span>--%>
            <%--</li>--%>
        </ul>
    </nav>
</div>
<div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
    <a class="btn btn-large" data-edit="bold"><i class="icon-bold"></i></a>
</div>
</body>
<script>
    var pageNum = location.href.split("?")[1];
    pageNum = pageNum?pageNum:"currentPage=1";
    console.debug(pageNum?pageNum:"currentPage=1")
    function add() {
        window.location.href = "http://www.baidu.com";
    }

    (function getList() {
        $.ajax({
            type: "GET",
            url: "/pic/page?"+pageNum,
            success: function (data) {
                // console.debug(data.list)
                for (var i = 0; i < data.list.length; i++) {
                    if (data.list[i].enabled == true) {
                        data.list[i].enabled = "glyphicon glyphicon-ok";
                    } else {
                        data.list[i].enabled = "glyphicon glyphicon-remove";
                    }
                    $("#list1").append('<tr>' +
                        '<th>' + data.list[i].id + '</th>' +
                        "<th><img alt='测试' src='" + data.list[i].storePath + "_small.jpg'/></th>" +
                        '<th>' + data.list[i].intro + '</th>' +
                        "<th><span class='" + data.list[i].enabled + "' aria-hidden='true'></span></th>" +
                        '<th>' + data.list[i].inputDate + '</th>' +
                        "<th><a href='/jump/main_edit?id=" + data.list[i].id + "' class='btn-default tableA'><span class='glyphicon glyphicon-pencil'aria-hidden='true'>修改</span></a></th>" +
                        "<th><a href='/pic/download?storePath=" + data.list[i].storePath + "' class='btn-default tableA'><span class='glyphicon glyphicon-pencil'aria-hidden='true'>下载</span></a></th>"
                    )
                }
                //分页菜单
                $("#paging").append(
                    "<li><span>当前第"+data.currentPage+"页</span></li>"+
                    "<li><a href='/jump/main'><span aria-hidden='true'>首页</span></a> </li>"+
                    "<li><a href='/jump/main?currentPage="+data.prePage+"' aria-label='上一页'><span aria-hidden='true'>上一页</span></a> </li>"+
                    "<li></li><li><a href='/jump/main?currentPage="+data.nextPage+"' aria-label='下一页'><span aria-hidden='true'>下一页</span></a></li>"+
                    "<li><a href='/jump/main?currentPage="+data.lastPage+"' aria-label='尾页'><span aria-hidden='true'>尾页</span></a></li>"+
                    "<li><span>总页数：共"+data.totalPage+"页</span><span>总数据：共"+data.totalData+"条</span></li>"
                )
            }
        })
    })();
</script>

</html>
