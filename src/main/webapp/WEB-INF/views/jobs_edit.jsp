<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/23
  Time: 22:40
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
            <a href="jobs.html">职位管理</a>
        </li>
        <li class="active">发布职位</li>
    </ul>
</div>
<!--添加-->
<form action="/job/update" method="post">
    <input id="id" name="id" type="hidden">
    <input id="htmlurl" name="htmlurl" type="hidden">
    <div class="form-group">
        <label for="title">工作职位</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="工作职位">
    </div>
    <div class="form-group">
        <label for="address">工作地点</label>
        <select id="address" name="address_id" class="form-control">
        </select>
    </div>
    <div class="form-group">
        <label for="jobnum">招聘人数</label>
        <input type="number" class="form-control" id="jobnum" name="jobnum" placeholder="招聘人数" />
    </div>
    <div class="form-group">
        <label for="treatment">薪资待遇</label>
        <input type="text" class="form-control" id="treatment" name="treatment" placeholder="薪资待遇">
    </div>
    <div class="form-group">
        <label for="describe">职位描述</label>
        <div id="describe">
        </div>
        <input type="hidden" id="txtDescribe" name="describes" />
    </div>
    <div class="form-group">
        <label for="require">任职要求</label>
        <div id="require">
        </div>
        <input type="hidden" id="txtRequire" name="requires" />
    </div>
    <div id="pt" class="form-group">
        <label for="positiontype">职位类型:</label>
        <label class="radio-inline">
            <input type="radio" name="positionType" id="positiontype" value="true" checked="checked">全职
        </label>
        <label class="radio-inline">
            <input type="radio" name="positionType" id="positiontype" value="false">兼职
        </label>
    </div>
    <div id="en" class="form-group">
        <label for="isenabled">是否启用:</label>
        <label class="radio-inline">
            <input type="radio" name="enabled" id="isenabled" value="true" checked="checked">是
        </label>
        <label class="radio-inline">
            <input type="radio" name="enabled" id="isenabled" value="false">否
        </label>
    </div>
    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
        <a class="btn btn-large" data-edit="bold"><i class="icon-bold"></i></a>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">修改职位</button>
    </div>
</form>
</body>
<script type="text/javascript" src="/js/wangEditor.min.js"></script>
<script type="text/javascript">
    //初始化富文本框
    var E = window.wangEditor;
    //职位描述
    var editor = new E('#describe');
    //职位描述
    var $txtDescribe = $('#txtDescribe');
    //职位描述中的信息同步到隐藏域
    editor.customConfig.onchange = function(html) {
        $txtDescribe.val(html);
    }
    editor.create();
    // 初始化 textarea 的值
    $txtDescribe.val(editor.txt.html());
    //任职要求
    var editor2 = new E('#require');
    //任职要求
    var $txtRequire = $('#txtRequire');
    //职位描述中的信息同步到隐藏域
    editor2.customConfig.onchange = function(html) {
        $txtRequire.val(html);
    }
    editor2.create();
    // 初始化 textarea 的值
    $txtRequire.val(editor2.txt.html());

    //修改数据展示
    $(function () {
        (function getPicture() {
            var id = location.href.split("?")[1];
            var addid;
            $.ajax({
                url:"/job/findOne?"+id,
                type:"post",
                success:function (data) {
                    console.debug(data)
                    addid = data.address_id;
                    $("#title").val(data.title);
                    $("#jobnum").val(data.jobnum);
                    $("#treatment").val(data.treatment);
                    editor.txt.html(data.describes);
                    editor.change();
                    editor2.txt.html(data.requires);
                    editor2.change();
                    if(data.positionType==true){
                        $("#pt>label>input:radio[value='true']").attr({checked:"true"});
                    }else {
                        $("#pt>label>input:radio[value='false']").attr({checked:"false"});
                    }
                    if(data.enabled==true){
                        $("#en>label>input:radio[value='true']").attr({checked:"true"});
                    }else {
                        $("#en>label>input:radio[value='false']").attr({checked:"false"});
                    }
                    $("#id").attr({value:id.split("=")[1]});
                    $("#htmlurl").attr({value:data.htmlurl});
                    $("#describe").focus();
                    $.ajax({
                        url:"/address/findAll",
                        type:"get",
                        success:function (data) {
                            for (var i=0; i<data.length; i++){
                                $("#address").append(
                                    "<option value='"+data[i].id+"'>"+data[i].address+"</option>"
                                )
                            }
                            console.debug(addid);
                            $("#address").val(addid);
                        }
                    });
                }
            });
        })();
    })
</script>

</html>
