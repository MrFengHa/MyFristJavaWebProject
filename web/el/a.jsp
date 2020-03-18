<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/3/17
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="elDemo.domain.Employee" %>
<%@ page import="elDemo.domain.Address" %>
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
    Address address = new Address();
    address.setCity("北京");
    address.setStreet("通州区");

    Employee employee = new Employee();
    employee.setName("三宝");
    employee.setSalary(1200);
    employee.setAddress(address);
    request.setAttribute("employee",employee);
%>
${employee.getName}
</body>
</html>
