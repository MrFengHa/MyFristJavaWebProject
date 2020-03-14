<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/14
  Time: 20:02
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
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            username = cookie.getValue();
        }
        if (cookie.getName().equals("password")) {
            password = cookie.getValue();
        }
    }
%>
<form action="/MyFristJavaWebProject/LoginVCServlet" method="post">
    姓名：<input type="text" name="username" value="<%=username%>"/><br/>
    密码：<input type="password" name="password" value="<%=password%>"/><br/>
    验证码:<input type=" text" name="verifyCode" size="3"/><img src="/MyFristJavaWebProject/VerifyCodeServlet"
                                                             onclick="changeCode(this);"><br/>
    <input type="submit" value="登陆"/>
</form>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
        out.write("<h1 style='color: red'>" + error + "<h1>");
    }

%>

<script type="text/javascript">
    function changeCode(obj) {

        obj.src = "/MyFristJavaWebProject/VerifyCodeServlet?a="+new Date();
    }
</script>
</body>
</html>
