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


    <script type="text/javascript">
        $(function () {
            $.ajaxUploadSettings.name = "file";
            var loading = null;
            $('#upload-image').ajaxUploadPrompt({
                url: '/medicine/logo',
                beforeSend: function () {
                    loading = layer.load(1);
                },
                success: function (data) {
                    if (loading) {
                        layer.close(loading);
                    }
                    $("#img-zhuang").width(70);
                    $("#img-zhuang").attr("src", data);
                    $("#img-zhuang").prev().val(data);
                    $("#img-logo").val(data);
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
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">药品管理</a></li>
        <li>添加药品</li>
    </ul>
</div>

<form action="/medicine/add" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品名字</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="medicine" class="form-control input-sm" placeholder="请输入药品名称"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品价格</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="price" class="form-control input-sm" placeholder="请输入药品价格"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品数量</label>
                <div class="col-sm-9">
                    <input type="text" required="required" name="num" class="form-control input-sm" placeholder="请输入药品数量"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
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
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品照片</label>
                <div class="col-sm-9">
                    <input id="img-logo" type="hidden" name="logo" class="form-control input-sm" placeholder="输入logo"/>
                    <div class="btn btn-success" id="upload-image">上传照片</div>
                    <img src="" id="img-zhuang" style="display: block">
                </div>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <input type="submit" class="btn btn-success" value="保存"/>
                <a class="btn btn-warning" href="/medicine/getlist">返回药品列表</a>
            </div>
        </div>
</form>

</body>
</html>
