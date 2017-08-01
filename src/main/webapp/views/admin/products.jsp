<%@ include file="../l_includes/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">
			<div class="portlet-title">
				<div class="caption"><h3>Inventory Products List</h3></div>
				<div class="tools">
					<div class="">
					<a class=" btn-xs btn purple pull-right"
						href="${pageContext.request.contextPath}/admin/products?action=add">
						<h5>Add new product<h4> <i
						class="fa fa-plus-circle font-lg fa-3x"></i>&nbsp;</a>
					</div>
				</div>
			</div>
				<div class="row">
					<div class="col-lg-36 col-md-36 col-sm-36 col-xs-36">
					<div class="">
							<c:if test="${not empty posted_product_data}">
								<div id="_server_res_msg_id">
									<h4 style="color: green;"><c:out value="${posted_user_data.responseMsg}"></c:out></h4>
								</div>
							</c:if>
						</div>
					<c:choose>
					<c:when test="${product_bean.responseStatus !='error' }">
							<dandelion:asset jsExcludes="datatables,bootstrap3,jquery,bootstrap3-theme-js" />
							 	<dandelion:asset cssExcludes="datatables,bootstrap3,bootstrap3-theme-css" /> 
								<datatables:table id="producttableId" data="${product_bean.bList}"	row="product"  cssClass="table table-striped table-light  table-hover table-bordered table-condensed "
									theme="bootstrap3" >
									<datatables:column title="Product code" property="productId"  cssClass="col-lg-3 col-md-6 col-sm-6" />
									<datatables:column title="Product Name" property="productName"  cssClass="col-lg-6 col-md-8 col-sm-9 col-xs-24" />
									<datatables:column title="Price" property="price"  cssClass="col-lg-4 col-md-4 col-sm-6 hidden-xs" cssCellClass="hidden-xs"/>
<%-- 									<datatables:column title="createdDate" property="createdDate" cssCellStyle="text-align:right;" filterable="true" cssClass="col-lg-8 col-md-8 col-sm-9 hidden-xs" cssCellClass="hidden-xs"/>
 --%>								<datatables:column title="Quantity" property="quantity"  cssClass="col-lg-8 col-md-8 col-sm-9 col-xs-24" />
 										<c:choose>
										<c:when test="${product.category eq 'M'}">
											<c:set var="category" value="Mobile" />
										</c:when>
										<c:otherwise>
											<c:set var="category" value="Laptop" />
										</c:otherwise>
									</c:choose>
									<datatables:column title="Category" property="" cssClass="col-lg-4 col-md-4 col-sm-6 hidden-xs" cssCellClass="hidden-xs" >
										<c:out value="${category}" />
									</datatables:column>
									 <c:choose>
										<c:when test="${product.status eq 'T'}">
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
										 <a class="" type="button" 	href="${pageContext.request.contextPath}/admin/products?action=edit&productId=${product.productId}"><i class="fa fa-edit" title="edit user"></i> </a>
										 <a class="" type="button" 	href="${pageContext.request.contextPath}/admin/products?action=remove&productId=${product.productId}"><i class="fa fa-times" title="edit user"></i> </a>
										</div>
									</datatables:column>
									</datatables:table>
							</c:when>
						</c:choose> 
					</div>
				</div>
	</div>
</div>
