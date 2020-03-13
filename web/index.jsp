<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/10
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>

<!--jsp指令，也是一种特殊的标签-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();//获取项目名
  String BasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <!--向页面输出-->
    <base href="<%=BasePath%>"/>
    <title>jsp</title>
  </head>
  <body>
  <!--是相对于<base>中的链接-->
  <a href="login.html">跳转到login.html</a>
  <%
    int a = 10;
  %>
  <%
    out.print(a);
  %>
  <%=a%>
  </body>
</html>
