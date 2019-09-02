<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 0:33
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
        <li>
            <a href="main.html">轮播管理</a>
        </li>
        <li class="active">修改轮播</li>
    </ul>
</div>
<!--添加-->
<form action="/pic/update" method="post">
    <input id="id" type="hidden" name="id"/>
    <div class="form-group">
        <label for="isenabled">是否启用:</label>
        <label class="radio-inline">
            <input type="radio" name="enabled" id="isenabled" value="true" checked="true">是
        </label>
        <label class="radio-inline">
            <input type="radio" name="enabled" id="isenabled" value="false">否
        </label>
    </div>
    <div class="form-group">
        <label for="intro">轮播图简述</label>
        <div id="intro" name="aa">
        </div>
        <input type="hidden" id="txtIntro" name="intro" />
    </div>

    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
        <a class="btn btn-large" data-edit="bold"><i class="icon-bold"></i></a>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">修改轮播</button>
    </div>
</form>
</body>
<script type="text/javascript" src="/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#intro');
    var $text1 = $('#txtIntro');
    editor.customConfig.onchange = function(html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html);
    }
    editor.create();
    // 初始化 textarea 的值
    $text1.val(editor.txt.html());

    $(function () {
        (function getPicture() {
            var id = location.href.split("?")[1];
            $.ajax({
                url:"/pic/findOne?"+id,
                type:"post",
                success:function (data) {
                    if(data.enabled==true){
                        $("input:radio[value='true']").attr({checked:"true"});
                    }else {
                        $("input:radio[value='false']").attr({checked:"false"});
                    }
                    editor.txt.html(data.intro);
                    editor.change();
                    $("#id").attr({value:id.split("=")[1]})
                }
            })
        })();
    })
</script>

</html>
