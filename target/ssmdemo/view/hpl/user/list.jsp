<%--
  Created by IntelliJ IDEA.
  User: xiaow
  Date: 2021/6/3
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script src="../../../js/qrcode.min.js"></script>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>
</head>

<body>
<style>
    .popover {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1060;
        display: none;
        max-width: 150px;
        max-height: 150px;
        padding: 0px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 14px;
        font-style: normal;
        font-weight: 400;
        line-height: 1.42857143;
        text-align: left;
        text-align: start;
        text-decoration: none;
        text-shadow: none;
        text-transform: none;
        letter-spacing: normal;
        word-break: normal;
        word-spacing: normal;
        word-wrap: normal;
        white-space: normal;
        background-color: #fff;
        -webkit-background-clip: padding-box;
        background-clip: padding-box;
        border: none;
        border: none;
        border-radius: 0px;
        -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        box-shadow: none;
        line-break: auto;
        overflow: hidden;
    }
</style>
<script>
    var qrcode;
    function sleep(delay) {   //delay:传入等待秒数
        var start = (new Date()).getTime();  //获取函数刚开始秒数
        while ((new Date()).getTime() - start < delay) {   //当当前时间减去函数刚开始时间小于等待秒数时，循环一直进行
            continue;
        }
    }


    window.onload = function () {
        var that = $('.detailinfo');
        that.popover({
            trigger: 'hover',
            html: true,
            content: "<iframe allowtransparency='yes' src='/user/showqrcode?username="+that.attr('value')+"'  scrolling='no' frameborder='no' border='0' marginwidth='0' marginheight='0'/>"
        });
    }


</script>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">医生管理</a></li>
        <li>医生列表</li>
    </ul>
</div>
<form class="form-inline">
    <div class="row alert alert-info" style="margin:0px; padding:3px;">
        <a class="btn btn-success" href="/user/add">添加医生</a>
        <a class="btn btn-success" href="/user/excelExport">导出医生数据</a>
    </div>
    <div class="row alert alert-info" style="margin:0px; padding:3px;">
        <%--        <a class="btn btn-success" href="javascript:window.history.back()">返回上一级</a>--%>

    </div>
    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>编号</th>
                <th>昵称</th>
                <th>真实姓名</th>
                <th>介绍</th>
                <th>等级</th>
                <th>头像</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${userlist}" var="bean">
                <tr>
                    <td>${bean.id}</td>
                    <td>${bean.username}</td>
                    <td>${bean.realname}</td>
                    <td>${bean.introduce}</td>
                    <td>${bean.level1}</td>
                    <td><img src="${bean.avatar}" style="width: 50px"></td>
                    <th>
                        <a class="btn btn-success btn-xs" href="/user/add?id=${bean.id}">修改</a>
                        <a class="btn btn-success btn-xs" href="/user/delete?id=${bean.id}">删除</a>
                        <a class="detailinfo" class="btn btn-success btn-xs" value="${bean.username}">详情</a>
                    </th>
                </tr>

            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
