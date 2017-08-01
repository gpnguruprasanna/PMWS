<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar navbar-inverse" style="height: 74px">
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PMWS</a>
    </div>
    <ul class="nav navbar-nav pull-right">
       <h2> <li><a href="${pageContext.request.contextPath}/admin_logout"><i class="icon-key"></i> Log Out</a></li></h2> 
     <%--  <li class="dropdown"><a class="dropdown-toggle"  href="${pageContext.request.contextPath}/admin_logout">Log out <span class="caret"></span></a>
        <ul class="dropdown-menu">
        </ul>  --%>
      </li>
    </ul>
  </div>
</div>