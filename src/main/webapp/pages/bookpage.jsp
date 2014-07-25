<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Electronic Library
                    <small> The easiest way to get the book.</small>
                </h1>
            </div>
            <ul class="nav nav-tabs nav-justified">
                <li class="active">
                    <a href="./mainpage"><strong>MainPage</strong></a>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li>
                        <a href="./admin"><strong>Administrating</strong></a>
                    </li>
                </sec:authorize>
                <li>
                    <a href="./logout">Logout</a>
                </li>
            </ul>
            <br>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-2"></div>
                        <div class="col-md-2 column">
                            <h3>
                                ${book.name}
                            </h3>
                            <img alt="400x300" src="../../image/${book.id}" class="img-thumbnail"/>

                            <p><br> File info : </p>

                            <p>File name : ${book.filename}</p>

                            <p>File size : ${book.size} bytes</p>
                            <a href="../upload/${book.id}" class="btn btn-lg btn-info" type="button">Upload</a>
                        </div>
                        <div class="col-md-8 column">
                            <br><br><br>

                            <p>${book.description}</p>

                            <p>Author : ${book.author}</p>

                            <p>Publisher : ${book.publisher}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
