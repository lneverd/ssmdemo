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

    <script src="../../../js/jquery.ajaxupload.js"></script>
    <link rel="stylesheet" href="../../../layer/theme/default/layer.css"/>
    <script src="../../../layer/layer.js"></script>

</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">病人管理</a></li>
        <li>添加病人</li>
    </ul>
</div>

<form action="/patient/add" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">病人姓名</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="name" class="form-control input-sm"
                           placeholder="请输入病人姓名"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">身份证号</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="idcard" class="form-control input-sm"
                           placeholder="请输入病人身份证号"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">性别</label>
                <div class="col-sm-9">
                    <select class="form-control" name="sex">
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="age" class="form-control input-sm"
                           placeholder="请输入病人年龄"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">费用</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="money" class="form-control input-sm"
                           placeholder="请输入费用"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">选择医生</label>
                <div class="col-sm-4">
                    <select name="uid" class="form-control input-sm">
                        <c:forEach items="${type}" var="bean">
                            <option value="${bean.id}">${bean.username}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="/patient/getlist">返回病人列表</a>
        </div>
    </div>
</form>

</body>
</html>
