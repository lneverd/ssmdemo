<%--
  Created by IntelliJ IDEA.
  User: Adminstor
  Date: 2021-06-04
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Animated Profile Card | CodingNepal</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/a076d05399.js"></script>
</head>
<body>
<div class="container">
    <div class="image">
        <img src="${avatar}">
    </div>
    <div class="content">
        <div class="info">
            <h2>${realname}</h2><br>
            <span>${username}</span><br>
            <span>${userlevel1}</span><br>
            <span>${introduce}</span>
        </div>

    </div>
    <%--<ul>
        <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
        <li><a href="#"><span class="fab fa-wechat"></span></a></li>
        <li><a href="#"><span class="fab fa-instagram"></span></a></li>
        <li><a href="#"><span class="fab fa-github"></span></a></li>
        <li><a href="#"><span class="fab fa-youtube"></span></a></li>
    </ul>--%>
</div>
</body>

</body>
</html>
