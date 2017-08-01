<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>PMWS</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<%--  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 --%> 
 <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">
 <link href="${pageContext.request.contextPath}/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
 <link href="${pageContext.request.contextPath}/resources/jquery-validation/css/validationEngine.jquery.css"  type="text/css" rel="stylesheet" /> 
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body data-appbase="${pageContext.request.contextPath}">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		<div class="clearfix">
		</div>

		<div class="row">
			<div class="col-sm-3">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="clearfix"></div>
			
			<div class="col-sm-9">
				<div class="page-content-body">
					<tiles:insertAttribute name="body" />
				</div>
				<!-- <div class="sub-page-content-body"></div> -->
			</div>
		</div>
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>


  <script type="text/javascript"  src="${pageContext.request.contextPath}/resources/javascript/jquery.min.js"/>
<%-- <script src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
 --%><script type="text/javascript"  src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-validation/dist/jquery.validate.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<%--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-validation/dist/jquery.validationEngine.js"></script> 
 --%><%--    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-validation/dist/languages/jquery.validationEngine-en.js"></script>
 --%><%-- <script src="${pageContext.request.contextPath}/resources/javascript/jquery.form.js"/> --%>

 <script>
  
	  $(document).ready(function() {

			  $(".fromDate").datetimepicker({
		            autoclose: true,
		            todayBtn: true,
		            minView:2,
	                format: "dd MM yyyy",
		            pickerPosition: "bottom-left"
		        });
	  });
	  
  </script>
 </body>
</html>