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
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">药品类别管理</a></li>
        <li>修改药品信息</li>
    </ul>
</div>

<form action="/medicine/update" class="form-horizontal" method="post">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                    <input type="text" readonly="readonly" name="id" class="form-control input-sm" value="${bean.id}"/>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品名称</label>
                <div class="col-sm-9">
                    <input type="text" value="${bean.medicine}" name="medicine" class="form-control input-sm" placeholder="${bean.medicine}"/>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品单价</label>
                <div class="col-sm-9">
                    <input type="text" value="${bean.price}" name="price" class="form-control input-sm" placeholder="${bean.price}"/>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品库存</label>
                <div class="col-sm-9">
                    <input type="text" value="${bean.num}" name="num" class="form-control input-sm" placeholder="${bean.num}"/>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品图片地址</label>
                <div class="col-sm-9">
                    <input type="text" readonly="readonly" value="${bean.logo}" name="logo" class="form-control input-sm"/>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品类别</label>
                <div class="col-sm-4">
                    <select name="cid" class="form-control input-sm">
                        <c:forEach items="${type}" var="bean">
                            <option value="${bean.id}">${bean.category}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="submit" class="btn btn-success" value="修改"/>
        </div>
    </div>
</form>

</body>
</html>
