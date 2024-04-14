<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/12/2024
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form product</h1>
<form action="/products?action=add" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name">
    <label for="price">Price</label>
    <input type="text" id="price" name="price">
    <label for="quantity">Quantity</label>
    <input type="text" id="quantity" name="quantity">
    <label for="cId">Category</label>
    <select name="cId" id="cId">
        <c:forEach items="${categories}" var="c">
            <option value="${c.getId()}">${c.getName()}</option>
        </c:forEach>
    </select>
    <button type="submit">Create</button>
</form>
</body>
</html>
