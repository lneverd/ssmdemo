<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/1
  Time: 9:07
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
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">药品管理</a></li>
        <li>查询药品</li>
    </ul>
</div>
<form class="form-inline" action="/category/getone" method="get">
    <div class="row alert alert-info" style="margin:0px; padding:3px;" >

        <div class="form-group">
            <label class="" for="category">药品类别名字：</label>
            <input type="text" name="category" class="form-control" id="category" placeholder="请输入药品类别名字">
        </div>

        <input type="submit" class="btn btn-danger" value="查询"/>
        <a  class="btn btn-success"  href="/view/hpl/category/add.jsp">添加药品类别</a>

    </div>
    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>编号</th>
                <th>药品类别</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="bean">
            <tr>
            <td>${bean.id}</td>
            <td>${bean.category}</td>
            <th>
                <a href="/medicine/getlist?cid=${bean.id}">药品</a>
                <a href="/category/edit?id=${bean.id}">修改</a>
                <a href="/category/delete?id=${bean.id}">删除</a>

            </th>
        </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
