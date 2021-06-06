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
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">医生管理</a></li>
        <li>医生列表</li>
    </ul>
</div>
<form class="form-inline">

    <div class="row alert alert-info" style="margin:0px; padding:3px;">
        <a class="btn btn-danger" href="/user/delete2?id=${sessionScope.userinfo.id}">注销用户</a>
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
                        <a class="btn btn-success btn-xs" href="/user/showqrcode?username=${bean.username}">详情</a>
                    </th>
                </tr>

            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
