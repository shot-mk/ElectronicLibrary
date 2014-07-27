<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-condensed table-bordered table-hover">
    <thead>
    <tr>
        <th>
            Id
        </th>
        <th>
            Title
        </th>
        <th>
            Info
        </th>
        <th>
            Delete
        </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>
                    ${book.id}
            </td>
            <td>
                    ${book.name}
            </td>
            <td>
                <c:set var="id" value="${book.id}"/>
                <a id="modal-${id}" href="#modal-container-${id}" role="button" class="btn" data-toggle="modal"><span
                        class="glyphicon glyphicon-info-sign"></span></a>

                <div class="modal fade" id="modal-container-${id}" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                                <h4 class="modal-title" id="myModalLabel${id}">
                                    # ${book.name}
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div align="left">
                                    <p><img src="image/${book.id}"/></p> <br>

                                    <p><strong>Description : </strong> ${book.description}</p>

                                    <p><strong>Author : </strong> ${book.author}</p>

                                    <p><strong>Publisher : </strong> ${book.publisher} </p><br>

                                    <h2> File :</h2>

                                    <p><strong>Format : </strong> ${book.format} </p>

                                    <p><strong>Size : </strong> ${book.size} bytes </p>

                                    <p><strong>File Name : </strong> ${book.filename} </p>

                                    <h2> Tags :</h2>

                                    <p><c:forEach var="tag" items="${book.tags}">${tag.tag} </c:forEach></p>


                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <form action="service/deletebook" method="post">
                    <input class="hidden" name="deleteBook" value="${book.id}"/>
                    <button type="submit" class="btn btn-sm btn-default" name="action" value="deleteBook"><span
                            class="glyphicon glyphicon-trash"></span></button>
                </form>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
