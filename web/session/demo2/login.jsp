<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/14
  Time: 1:36
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
<h1>登陆页面</h1>

<form  action="/MyFristJavaWebProject/LoginServlet" method="post">
    姓名：<input type="text" name="username"/>
    密码：<input type="password" name="password"/>
    <input type="submit" value="登陆"/>
</form>
<%
    String error =(String)request.getAttribute("error");
    if (error!=null){
        out.write("<h1 style='color: red'>"+error+"<h1>");
    }

%>
</body>
</html>
