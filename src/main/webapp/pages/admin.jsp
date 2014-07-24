<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <a href="./Administrating"><strong>Administrating</strong></a>
                </li>
                <li>
                    <a href="./logout">Logout</a>
                </li>
            </ul>
            <p></p>
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <div class="panel-group" id="panel-book">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-book"
                                   href="#panel-element-add-book">Add Book</a>
                            </div>
                            <div id="panel-element-add-book" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form" action="service/addbook" method="post" enctype="multipart/form-data">
                                        <h3>Add book</h3>
                                        <div class="form-group">
                                            <label for="bookName" class="col-sm-4 control-label"> Book Name </label>

                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" id="bookName" name="bookName" required="required"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="author" class="col-sm-4 control-label">Author</label>

                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" id="author" name="author" required="required"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="publisher" class="col-sm-4 control-label">Publisher</label>

                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" id="publisher" name="publisher" required="required"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description" class="col-sm-4 control-label">Description</label>

                                            <div class="col-sm-8">
                                                <textarea maxlength="500" rows="5"  class="form-control" id="description" name="description" required="required"> </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="book" class="col-sm-4 control-label">Book</label>

                                            <div class="col-sm-8">
                                                <input type="file" class="form-control" id="book" name="book" required="required"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="image" class="col-sm-4 control-label">Image</label>

                                            <div class="col-sm-8">
                                                <input type="file" class="form-control" id="image" name="image" required="required"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-primary" name="action" value="addBook">Add Book </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-book"
                                   href="#panel-element-delete-book">Delete Book</a>
                            </div>
                            <div id="panel-element-delete-book" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form" action="./service/deletebook" method="post">
                                        <h3>Delete Book </h3>
                                        <div class="form-group">
                                            <label for="deleteBook" class="col-sm-4 control-label">Delete Book </label>

                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" id="deleteBook" name="deleteBook" required="required"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-primary" name="action" value="deleteBook">Delete</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <p></p>
            <jsp:include page="showbooks.jsp"></jsp:include>

        </div>
    </div>
</div>
</body>
</html>
