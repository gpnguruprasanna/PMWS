<%@ include file="../l_includes/taglibs.jsp"%>
<br>
<div id="subpage_id">
		<h3>User-edit<h3>
	 <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="portlet-body form">
						<c:choose>
							<c:when test="${fn:length(user_bean.listOfErrorDesc) gt 0}">
								<c:forEach var="val" items="${user_bean.listOfErrorDesc}">
									<ul>
										<li><h4 style="color: red;">
												<c:out value="${val}"></c:out>
											</h4>
									</ul>
								</c:forEach>
							</c:when>
						</c:choose>

						<c:choose>
							<c:when test="${user_bean.responseStatus !='error' }"></c:when>
							<c:otherwise>
								<c:if test="${not empty user_bean}">
									<div class="${user_bean.responseClass}" id="form_status_id">
										<button class="close" data-dismiss="alert"></button>
										<c:out value="${user_bean.responseMsg}"></c:out>
									</div>
								</c:if>
							</c:otherwise>
						</c:choose>

						<c:if test="${empty param.userId}">
							<c:set var="submitBtn" value="Save" />
						</c:if>

						<c:if test="${not empty param.userId}">
							<c:set var="submitBtn" value="Update" />
						</c:if>

						<form:form id="user_form_id" modelAttribute="user_bean" method="POST"  action="${pageContext.request.contextPath}/admin/users-save" >	
						<div class="form-body">
							<div class="row">

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="form-group mandatory">
											<label class="control-label">User Name</label>
											<form:input path="userName" placeholder="username"
												class="validate[required,maxSize[50],custom[onlyLetterSp]] form-control" />
											<form:errors path="userName"></form:errors>
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="form-group mandatory">
											<label class="control-label">Password</label>
											<form:input path="password"
												class="validate[required] form-control" />
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="form-group mandatory">
											<label class="control-label">status</label>
											<form:select path="status"
												class="validate[required] form-control"
												items="${viewUtil.getStatuses()}"></form:select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="form-group mandatory">
											<label class="control-label">Roles</label>
											<form:select path="roles" multiple="true"
												class="validate[required] form-control chosen-select"
												items="${viewUtil.getRoles()}"></form:select>
										</div>
									</div>
								</div>
						</div>
							<div class="form-actions">
								<span class="pull-right">
									<button class="btn green" type="submit">
										<c:out value="${submitBtn}"></c:out>
									</button>
									<button class="btn green" type="reset">Reset</button>
									<a type="button" class="btn green cancel"	href="${pageContext.request.contextPath}/admin/users?action="" "><button class="btn green" type="button">Cancel</button></a>
								</span>
							</div>
							<form:hidden path="userId" />
						<form:hidden path="action" />
					</form:form>
				</div>
		</div>
	</div>
</div> 
