<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="media">
    <a href="#" class="pull-left"><img src="<c:url value="/resources/user.jpg"/>" class="media-object" alt=''/></a>

    <div class="media-body">
        <h4 class="media-heading">
            ${child.user.login}
        </h4>

        <p><em>${child.getPrettyDate()}</em></p>

        <p>${child.comment}</p>
        <br/>
        <br/>
        <c:forEach var="child" items="${commentService.getChildComments(child.id)}">
            <c:set var="child" value="${child}" scope="request"></c:set>
            <jsp:include page="childcomment.jsp"/>
        </c:forEach>
        <br/>

        <form role="form" action="../addcomment" method="post">
            <textarea maxlength="500" rows="2" class="form-control" name="comment" required="required"> </textarea>
            <input class="hidden" name="user" value="<sec:authentication property="principal.username"/>"/>
            <input class="hidden" name="bookId" value="${book.id}"/>
            <input class="hidden" name="parentId" value="${child.id}"/>
            <button type="submit" class="btn btn-default">Answer</button>
        </form>
        <br/>
    </div>
</div>
