<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/14
  Time: 1:20
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
<h1>向Session保存数据</h1>
<%
    session.setAttribute("aaa","AAA");
%>
</body>
</html>
