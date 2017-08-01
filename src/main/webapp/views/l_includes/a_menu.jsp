<%@ include file="../l_includes/taglibs.jsp"%>
  <div class="row">
    <div class="col-sm-12" style="background-color:yellow;">
    <ul>
      <c:forEach items="${viewUtil.getLinks(currentUserId)}" var="ubar"	varStatus="ubar_count">
		<li class="tabItems-focus-li">
		<a href="${pageContext.request.contextPath}/${ubar.url}" >
			<h3> <c:out value="${ubar.linkName}"></c:out><h3>
		</a>
		</li>
	</c:forEach>
	</ul>
    </div>
    </div>
  </div>

