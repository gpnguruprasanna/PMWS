<%@ include file="../l_includes/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">
			<div class="portlet-title">
				<div class="caption"><h3>Promotions</h3></div>
		<c:set var="userIsReviewer" value="${viewUtil.isCurrentUserReviewer(currentUserId) }"></c:set>
			<c:if test="${userIsReviewer==false}">
			<div class="tools">
				<div class="">
					<a class=" btn-xs btn purple pull-right"
						href="${pageContext.request.contextPath}/admin/promotions?action=add">
						<h5>Add new promotion<h4><i
						class="fa fa-plus-circle font-lg fa-3x"></i>&nbsp;
					</a>
				</div>
			</div>
			</c:if>
		</div>
				<div class="row">
					<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">
					<div class="">
							<c:if test="${not empty posted_promotion_data}">
								<div id="_server_res_msg_id">
									<h4 style="color: green;"><c:out value="${posted_promotion_data.responseMsg}"></c:out></h4>
								</div>
							</c:if>
						</div>

				<c:choose>
					<c:when test="${promotion_bean.responseStatus !='error' }">
						<dandelion:asset jsExcludes="datatables,bootstrap3,jquery,bootstrap3-theme-js" />
						<dandelion:asset cssExcludes="datatables,bootstrap3,bootstrap3-theme-css" />
						<datatables:table id="promotiontableId" data="${promotion_bean.bList}" row="promotion"
							cssClass="table table-striped table-light  table-hover table-bordered table-condensed "	theme="bootstrap3">
						
							<c:set var="id" value="${ }"></c:set>
							
							<c:set var="product" value="${viewUtil.getProductBasedOnId(promotion.productId)}"></c:set>
							<datatables:column title="Inventory of product" property="" filterable="true"
								cssClass="col-lg-8 col-md-8 col-sm-6">
								<c:out value="${product}" />
							</datatables:column>
							
							<datatables:column title="Discount" property="dicount" filterable="true" cssClass="col-lg-2 col-md-2 col-sm-9 col-xs-24" />
							<datatables:column title="StartDate" property="startDate" cssCellStyle="text-align:right;" filterable="true" cssClass="col-lg-4 col-md-6 col-sm-9 hidden-xs" cssCellClass="hidden-xs"/>
 							<datatables:column title="End Date" property="endDate" cssCellStyle="text-align:right;" filterable="true" cssClass="col-lg-4 col-md-6 col-sm-9 hidden-xs" cssCellClass="hidden-xs"/>
							<c:choose>
								<c:when test="${promotion.status eq 'T'}">
									<c:set var="status" value="Active" />
								</c:when>
								<c:otherwise>
									<c:set var="status" value="Inactive" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${promotion.reviewStatus eq 'A'}">
									<c:set var="reviewStatus" value="Approved" />
								</c:when>
								<c:when test="${promotion.reviewStatus eq 'R'}">
									<c:set var="reviewStatus" value="Rejected" />
								</c:when>
								<c:otherwise>
									<c:set var="reviewStatus" value="Not Reviewed" />
								</c:otherwise>
							</c:choose>
								<datatables:column title="Review Status" property=""
								cssClass="col-lg-6 col-md-6 col-sm-6 hidden-xs" filterable="true"
								cssCellClass="hidden-xs">
								<c:out value="${reviewStatus}" />
							</datatables:column>
							<datatables:column title="Status" property=""
								cssClass="col-lg-4 col-md-4 col-sm-6 hidden-xs"
								cssCellClass="hidden-xs">
								<c:out value="${status}" />
							</datatables:column>
							<datatables:column title="Action" display="html" sortable="false"
								cssClass="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="dt-action-buttons center">
									<a class="" type="button"
										href="${pageContext.request.contextPath}/admin/promotions?action=edit&promotionId=${promotion.promotionId}"><i
										class="fa fa-edit" title="edit user"></i> </a> <a class=""
										type="button"
										href="${pageContext.request.contextPath}/admin/promotions?action=remove&promotionId=${promotion.promotionId}"><i
										class="fa fa-times" title="edit user"></i> </a>
								</div>
							</datatables:column>
						</datatables:table>
					</c:when>
				</c:choose>
			</div>
				</div>
	</div>
</div>
