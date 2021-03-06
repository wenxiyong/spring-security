<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
</head>
<body>
<h1>Title:${title}</h1>
<h1>Message:${message}</h1>

<sec:authorize access="hasRole('POWER')">
    <!-- For login user -->
    <form action="<c:url value='j_spring_security_logout' />" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            User : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a> | <a href="admin">admin</a>
        </h2>
    </c:if>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <br />
    <h2>
        <a href="login">login</a>
    </h2>
</sec:authorize>

</body>
</html>