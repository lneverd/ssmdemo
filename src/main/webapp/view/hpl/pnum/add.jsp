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

        function change(obj) {
            var index = obj.selectedIndex;
            var s = obj.options[index].value;
            var ss = obj.options[index].text;
            var nid = document.getElementById("nid").innerHTML;
            window.location.href = "/pnum/makedrugMe?id=" + s+"&nid="+nid;
        }

        function changeMe(obj) {
            var num = obj.value;

            var medicine = document.getElementById("medicine");
            var index = medicine.selectedIndex;
            var idme = medicine.options[index].value;
            var nameme = medicine.options[index].text;

            var chtext = document.getElementById("choose");
            chtext.innerHTML = nameme.concat("x").concat(num);

            var allmoney = document.getElementById("allmoney");

            var addmoney = nameme.replace(/[^0-9.]/ig, "");

            allmoney.innerHTML =parseFloat(addmoney) * parseInt(num);
        }

        function addmore() {
            var nid=document.getElementById("nid").innerHTML;

            var medicine = document.getElementById("medicine");
            var index = medicine.selectedIndex;
            var idme = medicine.options[index].value;

            var num = document.getElementById("num").value;
            window.location.href ="/pnum/drugSave?nid="+nid+"&mid="+idme+"&num="+num;
        }

        function result() {
            var nid=document.getElementById("nid").innerHTML;
            window.location.href = "/pnum/drugresult?nid=" + nid;
        }
    </script>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">病人管理</a></li>
        <li>开药</li>
    </ul>
</div>

<form action="" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">病例号：</label>
                <div class="col-sm-9">
                    <p id="nid" class="form-control-static">${nid}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品类别</label>
                <div class="col-sm-4">
                    <select name="cid" class="form-control input-sm" onchange="change(this)">
                        <option>-请选择-</option>
                        <c:forEach items="${type}" var="bean">
                            <c:if test="${selected==bean.id}">
                                <option value="${bean.id}" selected="selected">${bean.category}</option>
                            </c:if>
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
                <label class="col-sm-3 control-label">药品</label>
                <div class="col-sm-4">
                    <select id="medicine" name="cid" class="form-control input-sm">
                        <option>-请选择-</option>
                        <c:forEach items="${medicine}" var="bean">
                            <option value="${bean.id}">${bean.medicine.concat("(").concat(bean.price).concat("元)")}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">药品数量</label>
                <div class="col-sm-9">
                    <input required="required" id="num" type="text" name="count" class="form-control input-sm" placeholder="请输入药品数量"
                           onchange="changeMe(this)"/>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">已选药品</label>
                <div class="col-sm-9">
                    <p id="choose" class="form-control-static">${mediall}</p>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">总金额</label>
                <div class="col-sm-9">
                    <p id="allmoney" class="form-control-static">${money}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="button" onclick="addmore()" class="btn btn-success" value="添加"/>
            <input type="button" onclick="result()" class="btn btn-success" value="结算"/>
        </div>
    </div>
</form>

</body>
</html>
