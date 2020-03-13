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
<h1>保存Cookie</h1>
<%
    Cookie cookie1 = new Cookie("aaa","AAA");
    Cookie cookie2 = new Cookie("bbb","BBB");
    response.addCookie(cookie1);
    response.addCookie(cookie2);
%>
</body>
</html>
