<%--
  Created by IntelliJ IDEA.
  User: Adminstor
  Date: 2021-06-04
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <script src="../../../js/qrcode.min.js"></script>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>
    <title>qrcode</title>
</head>
<body>
<div id="qrcode" style="width: 600px;height: 600px;margin-left:2px;margin-top: 2px"></div>
</body>
    <script>
        var qrcode;
        window.onload = function () {
            qrcode = new QRCode(document.getElementById("qrcode"), {
                text: "http://192.168.5.235:8001/user/detail?username=${username}",
                width: 128, //生成的二维码的宽度
                height: 128, //生成的二维码的高度
                colorDark: "#000000", // 生成的二维码的深色部分
                colorLight: "#ffffff", //生成二维码的浅色部分
                correctLevel: QRCode.CorrectLevel.H
            });
            setTimeout(function (){
                var elementsByTagNameElement = document.getElementById("qrcode").getElementsByTagName('img')[0];
                var htmlCanvasElement = document.createElement('canvas');
                htmlCanvasElement.width=elementsByTagNameElement.width;
                htmlCanvasElement.height=elementsByTagNameElement.height;
                // 0，0 就是没有偏移 即在左上方开始绘制
                htmlCanvasElement.getContext('2d').drawImage(elementsByTagNameElement,0,0);
                var url = htmlCanvasElement.toDataURL('image/png');
                var a = document.getElementById("img-download");
            }, 100);

        }

        function download() {
            var elementsByTagNameElement = document.getElementById("qrcode").getElementsByTagName('img')[0];
            var htmlCanvasElement = document.createElement('canvas');
            htmlCanvasElement.width=elementsByTagNameElement.width;
            htmlCanvasElement.height=elementsByTagNameElement.height;
            // 0，0 就是没有偏移 即在左上方开始绘制
            htmlCanvasElement.getContext('2d').drawImage(elementsByTagNameElement,0,0);
            var url = htmlCanvasElement.toDataURL('image/png');
            var a = document.getElementById("img-download");
            console.log(url);
            // a.setAttribute("href",url);
            // a.click();
        }
    </script>
</html>
