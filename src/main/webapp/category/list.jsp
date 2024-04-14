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
<h1>List Category</h1>
<a href="/categories?action=addGet"><button>Add new category</button></a>
<a href="/products"><button>Products</button></a>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${categories}" var="c" varStatus="cs">
        <tr>
            <td>${cs.count}</td>
            <td>${c.getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
