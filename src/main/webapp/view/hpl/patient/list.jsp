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
        <li><a href="#">病人管理</a></li>
        <li>查询病人</li>
    </ul>
</div>
<form class="form-inline" action="/patient/getone" method="get">
    <div class="row alert alert-info" style="margin:0px; padding:3px;" >

        <div class="form-group">
            <label class="" for="patient">病人名字：</label>
            <input type="text" name="name" class="form-control" id="patient" placeholder="请输入病人名字">
        </div>

        <input type="submit" class="btn btn-danger" value="查询"/>
        <a  class="btn btn-success"  href="/patient/backadd">添加病人</a>

    </div>
    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证</th>
                <th>状态</th>
            </tr>
            <c:forEach items="${list}" var="bean">
                <tr>
                    <td>${bean.id}</td>
                    <td>${bean.name}</td>
                    <td>${bean.sex}</td>
                    <td>${bean.idcard}</td>
                    <td>${bean.outt}</td>
                    <th>
                        <a class="btn btn-success btn-xs" href="/patient/edit?id=${bean.id}">修改</a>

                        <c:if test="${bean.outt!='出院'}">
                            <a class="btn btn-danger btn-xs" href="/patient/out?id=${bean.id}">出院</a>
                        </c:if>

                        <a class="btn btn-primary btn-xs" href="/patient/history?id=${bean.id}">病例</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
