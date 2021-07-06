<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Football service</title>
</head>
<body>
<form method="post" id="redirect"></form>
<h1 class="table_dark">Hello, admin!</h1>
<table class="table_dark">
    <tr>
        <th>Redirect to</th>
    </tr>
    <tr><td><a class="bottom" href="${pageContext.request.contextPath}/games/">Add New Game</a></td></tr>
    <tr><td><a class="bottom" href="${pageContext.request.contextPath}/matches">Add New Match</a></td></tr>
    <tr><td><a class="bottom" href="${pageContext.request.contextPath}/matches/*">Update Match</a></td></tr>
    <tr><td><a class="bottom" href="${pageContext.request.contextPath}/matches/*">Delete Match</a></td></tr>
    <tr><td><a class="bottom" href="${pageContext.request.contextPath}/stadiums">Add New Stadium</a></td></tr>
</table>
</body>
</html>
