<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>

<form action="/containers/${user.id}" method="post">
    <button type="submit" class="btn btn-default">add</button>
</form>
<c:forEach var="container" items="${containers}">
    <h1>${container.id}</h1>
</c:forEach>

</body>
</html>