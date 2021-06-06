<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/3
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二维码</title>
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
                text: "http://106.14.252.11:8001/file/file/logo/%E5%B0%8F%E6%9D%9C.jpg",
                width: 128, //生成的二维码的宽度
                height: 128, //生成的二维码的高度
                colorDark: "#000000", // 生成的二维码的深色部分
                colorLight: "#ffffff", //生成二维码的浅色部分
                correctLevel: QRCode.CorrectLevel.H
            });
        };

        function download() {
            var img = document.getElementById("qrcode").getElementsByTagName("img")[0];
            var canvas = document.createElement("canvas");
            canvas.width = img.width;
            canvas.height = img.height;
            canvas.getContext("2d").drawImage(img, 0, 0);
            var url = canvas.toDataURL("image/png");
            var a = document.getElementById("download");
            a.setAttribute("href", url);
            a.click();
        }
    </script>
</head>
<body>
<div>
    <div id="qrcode"></div>
    <a href="/file/一寸照片.jpg" id="download" download="二维码.png"></a>
    <button class="btn-success" onclick="download()">下载二维码</button>
</div>
</body>
</html>
