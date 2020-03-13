<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/13
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>

<h1>获取Cookie</h1>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies
        ) {
            out.write(cookie.getName() + "=" + cookie.getValue() + "<br/>");
        }
    }
%>
</body>
</html>
