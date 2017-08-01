<%@ include file="../l_includes/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">
			<div class="portlet-title">
				<h3>Users</h3>
				<div class="tools">
					<div class="">
					<a class=" btn-xs btn purple pull-right" data-toggle="tooltip"
						href="${pageContext.request.contextPath}/admin/users?action=add"><h5>Add new User<h4> <i
						class="fa fa-plus-circle font-lg  fa-3x"></i>&nbsp;</a>
					</div>
				</div>
			</div>
				<div class="row">
					<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">

						<div class="">
							<c:if test="${not empty posted_user_data}">
								<div id="_server_res_msg_id">
									<h4 style="color: green;"><c:out value="${posted_user_data.responseMsg}"></c:out></h4>
								</div>
							</c:if>
						</div>
						<c:choose>
							 	<c:when test="${user_bean.responseStatus !='error' }">
								<dandelion:asset jsExcludes="datatables,bootstrap3,jquery,bootstrap3-theme-js" />
							 	<dandelion:asset cssExcludes="datatables,bootstrap3,bootstrap3-theme-css" /> 
								<datatables:table id="myTableId" data="${user_bean.bList}"	row="users"  cssClass="table table-striped table-light  table-hover table-bordered table-condensed "
									theme="bootstrap3" >
									<datatables:column title="UserName" property="userName"  cssClass="col-lg-4 col-md-4 col-sm-6" />
									<datatables:column title="Password" property="password"  cssClass="col-lg-4 col-md-4 col-sm-6"/>
									
									<datatables:column title="Roles" property=""  cssClass="col-lg-4 col-md-4 col-sm-6 hidden-xs">
									<c:forEach var="val" items="${users.roles}" varStatus="index">
									<c:set var="val" value="${viewUtil.getRole(val)}" ></c:set>
									<c:out value="${val}"></c:out>
									<c:if test="${!index.last}">,</c:if>
									</c:forEach>
									</datatables:column>
									 <c:choose>
										<c:when test="${users.status eq 'T'}">
											<c:set var="status" value="Active" />
										</c:when>
										<c:otherwise>
											<c:set var="status" value="Inactive" />
										</c:otherwise>
									</c:choose>

									<datatables:column title="Status" property="" cssClass="col-lg-4 col-md-4 col-sm-6 hidden-xs" cssCellClass="hidden-xs" >
										<c:out value="${status}" />
									</datatables:column>
									<datatables:column title="Action" display="html" sortable="false" cssClass="col-lg-4 col-md-4 col-sm-6 col-xs-12">
										<div class="dt-action-buttons center">
										 <a class="" type="button" 	href="${pageContext.request.contextPath}/admin/users?action=edit&userId=${users.userId}"><i class="fa fa-edit" title="edit user"></i> </a>
										 <a class="" type="button" 	href="${pageContext.request.contextPath}/admin/users?action=remove&userId=${users.userId}"><i class="fa fa-times" title="edit user"></i> </a>
										</div>
									</datatables:column>
									</datatables:table>
							</c:when>
						</c:choose> 
					</div>
				</div>
	</div>
</div>
