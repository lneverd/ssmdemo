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
        <li>入院病例</li>
    </ul>
</div>
<form class="form-inline" action="/patient/getone" method="get">
    <div class="row alert alert-info" style="margin:0px; padding:3px;" >

        <a  class="btn btn-success"  href="/pnum/out?id=${list[0].id}">导出病例</a>

    </div>
    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>身份证</th>
                <th>费用</th>
                <th>主治医师</th>
                <th>状态</th>
                <th>时间</th>
            </tr>
            <c:forEach items="${list}" var="bean">
                <tr>
                    <td>${bean.nid}</td>
                    <td>${bean.name}</td>
                    <td>${bean.sex}</td>
                    <td>${bean.age}</td>
                    <td>${bean.idcard}</td>
                    <td>${bean.money}</td>
                    <td>${bean.username}</td>
                    <td>${bean.identification}</td>
                    <td>${bean.ctime}</td>
                    <th>
                        <c:if test="${bean.identification=='目前'}">
                            <a class="btn btn-success btn-xs" href="/pnum/makedrug?nid=${bean.nid}">开药</a>
                        </c:if>
                        <a class="btn btn-success btn-xs" href="/pnum/drugresult?nid=${bean.nid}">历史</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
