<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传1</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpLoadServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"/><br/>
    照&nbsp&nbsp&nbsp&nbsp片:<input type="file" name="file"/><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>
