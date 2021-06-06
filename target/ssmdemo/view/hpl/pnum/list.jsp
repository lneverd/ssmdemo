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
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <script src="../../../js/qrcode.min.js"></script>
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
        <li>药品详情</li>
    </ul>
</div>
<form class="form-inline" action="" method="get">

    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>药品</th>
                <th>单价</th>
                <th>数量</th>
                <th>图片</th>
                <th>类别名称</th>
                <th>花费</th>
            </tr>
            <c:forEach items="${list}" var="bean">
                <tr>
                    <td>${bean.medicine}</td>
                    <td>${bean.price}</td>
                    <td>${bean.counts}</td>
                    <td><img src="${bean.logo}" id="img-zhuang" style="width: 50px;height:50px"></td>
                    <td>${bean.category}</td>
                    <td>${bean.money}</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><p class="form-control-static" style="color: #DD0000">${allmoney}</p></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
