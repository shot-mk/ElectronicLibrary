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
                            <a href="../download/${book.id}" class="btn btn-lg btn-info" type="button">Upload</a>
                        </div>
                        <div class="col-md-8 column">
                            <br><br><br>

                            <p>${book.description}</p>

                            <p>Author : ${book.author}</p>

                            <p>Publisher : ${book.publisher}</p>

                            <p>Tags : </p>
                            <c:forEach var="tag" items="${book.tags}">
                                <a href="${pageContext.servletContext.contextPath}/book/findbook/tag/${tag.tag}">${tag.tag}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <br/>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" action="../addcomment" method="post">

                        <div class="form-group">
                            <label for="comment">Enter your comment</label>
                            <textarea maxlength="500" rows="5" class="form-control" id="comment" name="comment"
                                      required="required"> </textarea>
                            <input class="hidden" name="user"
                                   value="<sec:authentication property="principal.username"/>"/>
                            <input class="hidden" name="bookId" value="${book.id}"/>
                            <input class="hidden" name="parentId" value="0"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
            <br/>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <jsp:include page="comment.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
