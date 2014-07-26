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
                    <a href="${pageContext.servletContext.contextPath}/mainpage"><strong>MainPage</strong></a>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/admin"><strong>Administrating</strong></a>
                    </li>
                </sec:authorize>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                </li>
            </ul>
            <br>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form class="form-horizontal" role="form"
                          action="${pageContext.servletContext.contextPath}/book/findbook" method="post">
                        <h3>Find Book </h3>

                        <div class="form-group col-md-6">
                            <label for="findBook" class="control-label"> Enter Book Name</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="findBook" name="bookName"
                                       required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary" name="action" value="findBook">Find
                                </button>
                            </div>
                        </div>
                    </form>
                    <br/>

                    <form class="form-horizontal" role="form"
                          action="${pageContext.servletContext.contextPath}/book/findbook/description" method="post">
                        <div class="form-group col-md-6">
                            <label for="findBookDescr" class="control-label"> Enter Book Description</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="findBookDescr" name="bookDescription"
                                       required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary" name="action" value="findBookDescr">Find
                                </button>
                            </div>
                        </div>
                    </form>

                    <br/>

                    <c:forEach var="book" items="${bookList}">

                        <div class="row clearfix">
                            <div class="col-md-2 column">
                                <br>
                                <img src="${pageContext.servletContext.contextPath}/image/${book.id}" height="200"
                                     width="125"/>
                            </div>
                            <div class="col-md-10=column">
                                <div class="jumbotron">
                                    <h2>
                                            ${book.name}
                                    </h2>

                                    <p>
                                            ${book.description}
                                    </p>

                                    <p>
                                        <a class="btn btn-primary btn-large"
                                           href="${pageContext.servletContext.contextPath}/book/show/${book.id}">Look</a>
                                    </p>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
