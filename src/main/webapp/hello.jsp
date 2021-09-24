<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 24.09.2021
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <jsp:useBean id="ub" scope="request" type="com.example.demo5.UserBean"/>
    <h1>Hello ${ub.name}!</h1>
    <h2>Your age: ${ub.age}</h2>
    <h2>${ub.description}</h2>
</body>
</html>
