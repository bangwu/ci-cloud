<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%@include file="../header.jsp"%>
<table class="table table-hover">
    <thead>
        <tr>
            <td>Container ID</td>
            <td>Name</td>
            <td>Image</td>
            <td>Command</td>
            <td>Created</td>
            <td>Status</td>
            <td>Port</td>
            <td>Host Port</td>
            <td>Jenkins</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="container" items="${containers}">
            <tr>
                <td>${container.id}</td>
                <td>${container.name}</td>
                <td>${container.image}</td>
                <td>${container.command}</td>
                <td>${container.created}</td>
                <td>${container.status}</td>
                <td>${container.port}</td>
                <td>${container.hostPort}</td>
                <td><a href="http://localhost:${container.hostPort}" target="_blank">my Jenkins</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>