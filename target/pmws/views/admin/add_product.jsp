<%@ include file="../l_includes/taglibs.jsp"%>
<br>
<div id="subpage_id">
<h3>Product-Edit</h3>
	 <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="portlet-body form">
				 <c:choose>
					<c:when test="${fn:length(product_bean.listOfErrorDesc) gt 0}">
						<c:forEach var="val" items="${product_bean.listOfErrorDesc}">
							<ul>
								<li><h4 style="color: red;">
										<c:out value="${val}"></c:out>
									</h4>
							</ul>
						</c:forEach>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${product_bean.responseStatus !='error' }"></c:when>
					<c:otherwise>
						<c:if test="${not empty product_bean}">
							<div class="${product_bean.responseClass}" id="form_status_id">
								<button class="close" data-dismiss="alert"></button>
								<c:out value="${product_bean.responseMsg}"></c:out>
							</div>
						</c:if>
					</c:otherwise>
				</c:choose> 

				<c:if test="${empty param.productId}">
					<c:set var="submitBtn" value="Save" />
				</c:if>

				<c:if test="${not empty param.productId}">
					<c:set var="submitBtn" value="Update" />
				</c:if>

					<form:form id="product_form_id" modelAttribute="product_bean" method="POST"  action="${pageContext.request.contextPath}/admin/products-save" >	
						
						<div class="form-body">
							<div class="row">

							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">Product Name</label>
									<form:input path="productName" placeholder="Product Name"
										class="validate[required,maxSize[50],custom[onlyLetterSp]] form-control" />
								</div>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label"> Price</label>
									<form:input path="price"
										class="validate[required] form-control" />
								</div>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">Quantity</label>
									<form:select path="quantity"
										class="validate[required] form-control"
										items="${viewUtil.getQuantity()}"></form:select>
								</div>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<div class="form-group mandatory">
									<label class="control-label">Category</label>
									<form:select path="category"
										class="validate[required] form-control"
										items="${viewUtil.getProductCategory()}"></form:select>
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
						</div>
						</div>
						<form:hidden path="productId" />
						<form:hidden path="action" />

						<div class="form-actions">
							<span class="pull-right">
								<button class="btn green" type="submit"><c:out value="${submitBtn}"></c:out></button>
								<button class="btn green" type="reset">Reset</button>
						<a type="button" class="btn green cancel"	href="${pageContext.request.contextPath}/admin/products?action="" "><button class="btn green" type="button">Cancel</button></a>
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div> 
<!-- <script type="text/javascript">
	$('#product_form_id').validationEngine({promptPosition : "topRight",scroll : false,usePrefix : 's2id_'});
</script> -->
