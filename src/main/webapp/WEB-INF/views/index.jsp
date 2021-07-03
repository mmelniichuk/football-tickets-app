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
    <h1 class="table_dark">Hello, ${name}</h1>
    <table class="table_dark">
        <tr>
            <th>Redirect to</th>
        </tr>
        <tr><td><a class="bottom" href="${pageContext.request.contextPath}/games/">Display All Games</a></td></tr>
        <tr><td><a class="bottom" href="${pageContext.request.contextPath}/matches">Display All Matches</a></td></tr>
        <tr><td><a class="bottom" href="${pageContext.request.contextPath}/orders/">Display My Orders</a></td></tr>
        <tr><td><a class="bottom" href="${pageContext.request.contextPath}/shopping-carts/by-user">Move To Shopping Cart</a></td></tr>
    </table>
</body>
</html>
