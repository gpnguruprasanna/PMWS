<%@ include file="../l_includes/taglibs.jsp"%>
	 <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<h3>Search Promotion</h3>
				<div class="portlet-body form">
				 <c:choose>
					<c:when test="${fn:length(promotion_bean.listOfErrorDesc) gt 0}">
						<c:forEach var="val" items="${promotion_bean.listOfErrorDesc}">
							<ul>
								<li><h4 style="color: red;">
										<c:out value="${val}"></c:out>
									</h4>
							</ul>
						</c:forEach>
					</c:when>
				</c:choose>
				
					<c:choose>
						<c:when test="${promotion_bean.responseStatus !='error' }"></c:when>
						<c:otherwise>
							<c:if test="${not empty promotion_bean}">
								<div class="${promotion_bean.responseClass}" id="form_status_id">
									<button class="close" data-dismiss="alert"></button>
									<c:out value="${promotion_bean.responseMsg}"></c:out>
								</div>
							</c:if>
						</c:otherwise>
					</c:choose>
					<form:form id="promotion_form_id" modelAttribute="promotion_bean" method="POST"  action="${pageContext.request.contextPath}/admin/fetchsearch?action=search" >	
						
						<div class="form-body">
							<div class="row">

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<div class="form-group mandatory">
										<label class="control-label">Product</label>
										<form:select path="productId" 	class="validate[required] form-control"	items="${viewUtil.getProducts()}" ></form:select>
									</div>
								</div>
								
							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">Start Date</label>
									<div class="input-group date fromDate"
										data-date-startdate="${viewUtil.getCurrentViewDate()}">
										<form:input path="startDate" id="start_date"
											class="validate[required] form-control fdate" size="16" />
										<span class="input-group-btn">
											<button type="button" class="btn default date-set">
												<i class="fa fa-calendar"></i>
											</button>
										</span>
									</div>

								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">End Date</label>
									<div class="input-group date fromDate"
										data-date-startdate="${viewUtil.getCurrentViewDate()}">
										<form:input path="endDate" id="start_date"
											class="validate[required] form-control fdate" size="16" />
										<span class="input-group-btn">
											<button type="button" class="btn default date-set">
												<i class="fa fa-calendar"></i>
											</button>
										</span>
									</div>

								</div>
							</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<div class="form-group mandatory">
										<label class="control-label">Review Status</label>
										<form:select path="listOfReviewStatus" multiple="true"	class="validate[required] form-control"	items="${viewUtil.getReviewStatuses()}" ></form:select>
									</div>
								</div>
							</div>
						</div>
						<form:hidden path="promotionId" />

						<div class="form-actions">
							<span class="pull-right">
								<button class="btn green" type="submit">Search</button>
								<button class="btn green" type="reset">Reset</button>
							</span>
						</div>
					</form:form> 
					
					<br>
					<c:if test="${promotion_bean.action eq 'search_result'}">
				<c:choose>
					<c:when test="${promotion_bean_result.responseStatus !='error' }">
						<dandelion:asset jsExcludes="datatables,bootstrap3,jquery,bootstrap3-theme-js" />
						<dandelion:asset cssExcludes="datatables,bootstrap3,bootstrap3-theme-css" />
						<datatables:table id="promotiontableId" data="${promotion_bean_result.bList}" row="promotion"
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
				</c:if>
				</div>
			</div>
		</div>
	</div>
