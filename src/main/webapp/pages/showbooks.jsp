
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            </td>
            <td>
                <form action="./admin/service/deletebook" method="post">
                    <input class="hidden" name="deleteBook" value="${book.getId()}"/>
                    <button type="submit" class="btn btn-sm btn-default" name="action" value="deleteBook"><span class="glyphicon glyphicon-trash"></span></button>
                </form>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
