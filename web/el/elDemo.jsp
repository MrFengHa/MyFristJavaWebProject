<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/17
  Time: 11:45
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
        pageContext.setAttribute("xxx","pageContext_XXX");
        request.setAttribute("xxx","request_XXX");
        session.setAttribute("xxx","session_XXX");
        application.setAttribute("xxx","application_XXX");
    %>
${xxx}
</body>
</html>
