<%@ include file="../l_includes/taglibs.jsp"%>
<br>
<div id="subpage_id">
<h3>Promotion-Edit</h3>
	 <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
					
					<c:if test="${empty param.promotionId}">
						<c:set var="submitBtn" value="Save" />
					</c:if>
					<c:if test="${not empty param.promotionId}">
						<c:set var="submitBtn" value="Update" />
					</c:if>
					<c:set var="userIsReviewer" value="${viewUtil.isCurrentUserReviewer(currentUserId) }"></c:set>
					<c:set var="postUrl" value="${pageContext.request.contextPath}/admin/promotions-save"></c:set>
					<c:if test="${userIsReviewer}">
					<c:set var="postUrl" value="${pageContext.request.contextPath}/admin/promotions-save?action=update"></c:set>
					</c:if>
					<c:out value="${postUrl}"></c:out>
					<form:form id="promotion_form_id" modelAttribute="promotion_bean" method="POST"  action="${postUrl}" >	
						
						<div class="form-body">
							<div class="row">

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<div class="form-group mandatory">
										<label class="control-label">Select Product for Promotion</label>
										<form:select path="productId" disabled="${userIsReviewer}"	class="validate[required] form-control"	items="${viewUtil.getProducts()}" ></form:select>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<div class="form-group mandatory">
										<label class="control-label"> Discount</label>
										<form:input path="dicount" disabled="${userIsReviewer}" class="validate[required] form-control"  />
									</div>
								</div>
								
							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">Start Date</label>
									<div class="input-group date fromDate" disabled="${userIsReviewer}"
										data-date-startdate="${viewUtil.getCurrentViewDate()}">
										<form:input path="startDate" id="start_date" disabled="${userIsReviewer}" 
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
										<form:input path="endDate" id="start_date" disabled="${userIsReviewer}"
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
										<label class="control-label">status</label>
										<form:select path="status" disabled="${userIsReviewer}" 	class="validate[required] form-control"	items="${viewUtil.getStatuses()}" ></form:select>
									</div>
								</div>
								
								<c:if test="${userIsReviewer}">
								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<div class="form-group mandatory">
										<label class="control-label">Review Status</label>
										<form:select path="reviewStatus" 	class="validate[required] form-control"	items="${viewUtil.getReviewStatuses()}" ></form:select>
									</div>
								</div>
								</c:if>
								
							</div>
						</div>
						<form:hidden path="promotionId" />
						<c:if test="${!userIsReviewer}">
						<form:hidden path="action" />
						</c:if>

						<div class="form-actions">
							<span class="pull-right">
								<button class="btn green" type="submit"><c:out value="${submitBtn}"></c:out></button>
								<button class="btn green" type="reset">Reset</button>
								<a type="button" class="btn green cancel"	href="${pageContext.request.contextPath}/admin/promotions?action="" "><button class="btn green" type="button">Cancel</button></a>
							</span>
						</div>
					</form:form> 
				</div>
			</div>
		</div>
	</div>
</div> 
<script type="text/javascript">
	$('#promotion_form_id').validationEngine({promptPosition : "topRight",scroll : false,usePrefix : 's2id_'});
</script>
