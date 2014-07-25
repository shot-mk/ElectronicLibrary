<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="head.jsp"/>
</head>

<body>

<div class="container" style="width: 300px;">
    <form action="register/reguser" method="post">
        <h2 class="form-signin-heading">Enter registration information</h2>
        <input type="text" class="form-control" name="login" placeholder="Login" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form>
</div>

</body>
</html>