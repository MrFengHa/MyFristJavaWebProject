<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/13
  Time: 18:14
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
    <form action="SumServlet" method="post">
        整数1：<input type="text" name="num1"/><br/>
        整数2：<input type="text" name="num2"/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
