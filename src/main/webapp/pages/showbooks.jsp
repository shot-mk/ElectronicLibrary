
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
                ${book.getId()}
            </td>
            <td>
                ${book.getName()}
            </td>
            <td>
                <a id="modal-600072" href="#modal-container-600072" role="button" class="btn" data-toggle="modal"><span
                        class="glyphicon glyphicon-info-sign"></span></a>

                <div class="modal fade" id="modal-container-600072" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    # ${book.getName()}
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div align="left">
                                    <p><strong>Short description : </strong> ${book.getDescription()}</p>

                                    <p><strong>Author : </strong> ${book.getAuthor()}</p>

                                    <p><strong>Publisher : </strong> ${book.getPublisher()} </p>
                                    <h> File :</h>
                                    <p><strong>Format : </strong> ${book.getFormat()} </p>

                                    <p><strong>Size : </strong> ${book.getSize()} </p>

                                    <p><strong>File Name : </strong> ${book.getFilename()} </p>

                                    <p><img src="service/image/${book.getId()}"/></p>

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
                <input class="hidden" name="deleteBook" value="${book.getId()}"/>
                    <button type="submit" class="btn btn-sm btn-default" name="action" value="deleteBook"><span class="glyphicon glyphicon-trash"></span></button>
                </form>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
