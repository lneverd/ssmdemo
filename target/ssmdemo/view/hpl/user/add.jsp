<%--
  Created by IntelliJ IDEA.
  User: xiaow
  Date: 2021/6/1
  Time: 10:11
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
    <script src="/js/jquery.ajaxupload.js"></script>
    <link rel="stylesheet" href="/layer/theme/default/layer.css"/>
    <script src="/layer/layer.js"></script>
</head>

<body>
<script type="text/javascript">
    $(function() {
        $.ajaxUploadSettings.name = "file";
        var loading = null;
        $('#upload-image').ajaxUploadPrompt({
            url: 'http://106.14.252.11:8001/aop/upload?path=/file/logo',
            beforeSend: function () {
                loading = layer.load(1);
            },
            success: function (data) {
                if (loading) {
                    layer.close(loading);
                }
                $("#img-xiaow").attr("src", "http://106.14.252.11:8001/file/file/logo/"+data.data);
                $("#logo").attr({"value": "http://106.14.252.11:8001/file/file/logo/"+data.data});
            },
            error: function () {
                if (loading) {
                    layer.close(loading);
                }
                alert('上传失败');
            }
        });
    });
</script>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="/view/hpl/category/list.jsp">医生管理</a></li>
        <c:if test="${empty user.id}">
            <li>添加医生</li>
        </c:if>
        <c:if test="${not empty user.id}">
            <li>更新医生信息</li>
        </c:if>
    </ul>
</div>

<form action="/user/add" method="post" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <input type="hidden" name="id" value="${user.id}"/>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">昵称</label>
                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control input-sm" value="${user.username}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">真实姓名</label>
                <div class="col-sm-9">
                    <input type="text" name="realname" class="form-control input-sm" value="${user.realname}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">个人介绍</label>
                <div class="col-sm-9">
                    <textarea name="introduce" class="form-control input-sm" value="${user.introduce}">

                    </textarea>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">等级</label>
                <div class="col-sm-9">
                    <input type="text" name="level1" class="form-control input-sm" value="${user.level1}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                    <input type="password" name="password" class="form-control input-sm" value="${user.password}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">照片</label>
                <div class="col-sm-9">
                    <input type="hidden" name="avatar" id="logo" class="form-control input-sm" placeholder="输入logo"/>
                    <img src="${user.avatar}" style="display: block;width: 100px" id="img-xiaow">
                    <div class="btn btn-success" id="upload-image">上传照片</div>
                </div>
            </div>
        </div>
    </div>
<%--    <div class="row">--%>
<%--        <div class="col-sm-5">--%>
<%--            <div class="form-group">--%>
<%--                <label class="col-sm-3 control-label">真实姓名</label>--%>
<%--                <div class="col-sm-9">--%>
<%--                    <select name="sex" class="form-control input-sm" >--%>
<%--                        <option value="男">男</option>--%>
<%--                        <option value="女">女</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="保存"/>
        </div>
    </div>
</form>

</body>
</html>
