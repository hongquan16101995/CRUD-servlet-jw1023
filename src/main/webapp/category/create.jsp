<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/12/2024
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form category</h1>
<form action="/categories?action=add" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name">
    <button type="submit">Create</button>
</form>
</body>
</html>
