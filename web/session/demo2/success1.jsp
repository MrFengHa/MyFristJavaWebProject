<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/14
  Time: 2:08
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
<%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    if (username == null) {
        request.setAttribute("error", "您没有登录，请您登录");
        request.getRequestDispatcher("/session/demo2/login.jsp").forward(request, response);
    } else {
        out.write("username:" + username + "<br/>");
        out.write("password:" + password);
    }
%>
</body>
</html>
