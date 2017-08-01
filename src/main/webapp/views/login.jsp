<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>PMWS</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form  method="POST" modelAttribute="adminlogin" action="loginpost" class="form-signin">
        <h2 class="form-heading">Log in</h2>
        <div class="form-group">
         <%--   // <span>${message}</span> --%>
            <form:input name="username" path="username" type="text" class="validate[required,maxSize[50],custom[onlyLetterSp]] form-control" placeholder="Username" 
                   autofocus="true"/>
            <form:input name="password" path="password" type="password" class="form-control"  placeholder="Password"/>
            <%-- <span>${error}</span> --%>
            <c:if test="${adminlogin.responseStatus=='error' }">
        <span style="color: red"> <h3> <c:out value="${adminlogin.responseMsg}"></c:out></h3> </span> 
            </c:if>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>
    </form:form>
</div>
<!-- /container -->
<script src="${contextPath}/resources/javascript/bootstrap.min.js"></script>
<script src="${contextPath}/resources/javascript/jquery.min.js"/>
</body>
</html>
