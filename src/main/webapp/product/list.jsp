<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/12/2024
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Product</h1>
<a href="/products?action=addGet"><button>Add new product</button></a>
<a href="/categories"><button>Categories</button></a>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${products}" var="p" varStatus="ps">
        <tr>
            <td>${ps.count}</td>
            <td>${p.getName()}</td>
            <td>${p.getPrice()}</td>
            <td>${p.getQuantity()}</td>
            <td>${p.getCategory().getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
