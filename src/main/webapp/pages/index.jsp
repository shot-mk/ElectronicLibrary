<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>ElectronicLibrary.com</h1>

        <p class="lead">ElectronicLibrary - this service let you to search, and upload books.</p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Log In</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>You are : <sec:authentication property="principal.username"/></p>
            <sec:authorize access="hasRole('ADMIN')">
                <p><a class="btn btn-lg btn-success" href="<c:url value="/admin" />" role="button">Enter</a></p>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <p><a class="btn btn-lg btn-success" href="<c:url value="/mainpage" />" role="button">Enter</a></p>
            </sec:authorize>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Log out</a></p>
        </sec:authorize>
        <p><a class="btn btn-lg btn-success" href="<c:url value="/register" />" role="button">Register</a></p>

    </div>

    <div class="footer">
        <p>&copy; shot-mk 2014</p>
    </div>

</div>
</body>
</html>
