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
    <script>
        //js的main函数
        var qrcode;
        window.onload = function () {
            qrcode = new QRCode(document.getElementById("qrcode"), {
                text: "",
                width: 128, //生成的二维码的宽度
                height: 128, //生成的二维码的高度
                colorDark: "#000000", // 生成的二维码的深色部分
                colorLight: "#ffffff", //生成二维码的浅色部分
                correctLevel: QRCode.CorrectLevel.H
            });
        };

        function download(qrcodeurl,qrcodename) {
            alert("来到这里");
            qrcode.clear();
            alert(qrcodeurl);
            qrcode.makeCode(qrcodeurl);
            //延时100ms加载
            setTimeout(function () {
                alert(qrcodeurl);
                var img = document.getElementById("qrcode").getElementsByTagName("img")[0];
                var canvas = document.createElement("canvas");
                canvas.width = img.width;
                canvas.height = img.height;
                canvas.getContext("2d").drawImage(img, 0, 0);
                var url = canvas.toDataURL("image/png");
                var a = document.getElementById("download");
                a.setAttribute("download",qrcodename);

                a.setAttribute("href", url);
                a.click();
            },1000);
        }
    </script>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">药品管理</a></li>
        <li>查询药品</li>
    </ul>
</div>
<form class="form-inline" action="/medicine/getone" method="get">
    <div class="row alert alert-info" style="margin:0px; padding:3px;" >

        <div class="form-group">
            <label class="" for="medicine">药品名字：</label>
            <input type="text" name="medicine" class="form-control" id="medicine" placeholder="请输入药品名字">
        </div>

        <input type="submit" class="btn btn-danger" value="查询"/>
        <a  class="btn btn-success"  href="/medicine/backadd">添加药品</a>

    </div>
    <div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>编号</th>
                <th>药品</th>
                <th>单价</th>
                <th>剩余数量</th>
                <th>图片</th>
                <th>类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="bean">
                <tr>
                    <td>${bean.id}</td>
                    <td>${bean.medicine}</td>
                    <td>${bean.price}</td>
                    <td>${bean.num}</td>
                    <td><img src="${bean.logo}" id="img-zhuang" style="width: 50px;height:50px"></td>
                    <td>${bean.category}</td>
                    <th>
                        <a href="/medicine/edit?id=${bean.id}">修改</a>
                        <a href="javascript:download('http://192.168.179.235:8001${bean.logo}','${bean.medicine}')">详情</a>
                        <a href="/medicine/delete?id=${bean.id}">删除</a>

                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 下载二维码 -->
    <div id="qrcode" style="display: none"></div>
    <a href="" id="download" download=""></a>
</form>
</body>
</html>
