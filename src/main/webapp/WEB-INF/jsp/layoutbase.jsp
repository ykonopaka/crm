<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:security="http://www.springframework.org/security/tags"
	xmlns:s="http://www.springframework.org/tags"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<c:set var="contextPath" scope="page"
		value="${pageContext.request.contextPath}" />
	<c:set var="locale" scope="page"
		value="${pageContext.response.locale}" />			
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:message code="application.title"/></title>
<link rel="stylesheet" href="${contextPath}/static/css/screen.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet"
	href="${contextPath}/static/css/jquery.dataTables.css" type="text/css"
	media="screen" title="default" />
<link rel="stylesheet"
	href="${contextPath}/static/css/jquery.dataTables_themeroller.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/table_jui.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/table.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/jquery-ui.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/page.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/jquery.ui.core.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/jquery.ui.datepicker.css"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="${contextPath}/static/css/jquery.ui.theme.css"
	type="text/css" media="screen" title="default" />
	
<link rel="shortcut icon" href="${contextPath}/static/ico/icon.png" />

<script type="text/javascript" src="${contextPath}/static/js/jquery.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.dataTables.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.ui.core.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.ui.datepicker.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.ui.widget.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.ui.datepicker-en.js">
	//
</script>
<script type="text/javascript" src="${contextPath}/static/js/jquery.ui.datepicker-ru.js">
	//
</script>

<c:set var="datatablesLanguage">
		${contextPath}/static/datatables/datatables_${pageContext.response.locale}.txt
	</c:set>

<script type="text/javascript">
	$(document).ready(function() {
		$('#manageusers').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "2%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "13%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#manageoffices').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "33%",
				"sClass" : "center"
			}, {
				"sWidth" : "33%",
				"sClass" : "center"
			}, {
				"sWidth" : "13%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#managephonenumbers').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "47%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "8%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#manageinfosources').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "67%",
				"sClass" : "center"
			}, {
				"sWidth" : "8%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#manageempltypes').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "82%",
				"sClass" : "center"
			}, {
				"sWidth" : "8%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#loginhistory').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : "serverprocessing",
			"aaSorting" : [ [ 0, "desc" ] ],
			"bFilter" : false,
			"aoColumns" : [ {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "80%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});

	$(document).ready(function() {
		$('#connectedusers').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aaSorting" : [ [ 0, "asc" ] ],
			"aoColumns" : [ {
				"sWidth" : "2%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "5%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(document).ready(function() {
		$('#manageclients').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : "serverprocessing",
			"aaSorting" : [ [ 0, "asc" ] ],
			"aoColumns" : [ {
				"sWidth" : "4%",
				"sClass" : "center"
			}, {
				"sWidth" : "22%",
				"sClass" : "center"
			}, {
				"sWidth" : "22%",
				"sClass" : "center"
			}, {
				"sWidth" : "22%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	
	$(document).ready(function() {
		$('#managecalls').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : "serverprocessing",
			"aaSorting" : [ [ 0, "desc" ] ],
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "17%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	
	$(document).ready(function() {
		$('#managedeals').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : "serverprocessing",
			"aaSorting" : [ [ 0, "desc" ] ],
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	
	$(document).ready(function() {
		$('#mydeals').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"bProcessing" : true,

			"aaSorting" : [ [ 0, "asc" ] ],
			"aoColumns" : [ {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "5%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "15%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	
	$(document).ready(function() {
		$('#manageclientphonenumbers').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"oLanguage" : {
				"sUrl" : "${datatablesLanguage}",
			},
			"aoColumns" : [ {
				"sWidth" : "10%",
				"sClass" : "center"
			}, {
				"sWidth" : "20%",
				"sClass" : "center"
			}, {
				"sWidth" : "60%",
				"sClass" : "center"
			}, {
				"sWidth" : "10%",
				"sClass" : "center",
				"bSortable" : false
			}, ]
		});
	});
	$(function() {
		$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
		$( "#datepicker1" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
		$( "#datepicker1" ).datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange : 'c-75:c+30',
			dateFormat : "dd.mm.yy",
			maxDate: new Date
		});
		
	});
	$(function() {
		$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
		$( "#datepicker2" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
		$( "#datepicker2" ).datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange : 'c-75:c+30',
			dateFormat : "dd.mm.yy",
			maxDate: new Date
		});
	});
</script>
</head>
<body>
	<div id="language">
		<span> <a href="?lang=en">en</a>|<a href="?lang=ru">ru</a>
		</span>
	</div>
	<tiles:insertAttribute name="topsearch" />
	<tiles:insertAttribute name="navigationbar" />
	<c:set var="pageHeader">
		<tiles:insertAttribute name="header" ignore="true" />
	</c:set>
	<div id="content-outer">
		<div id="content">
			<div id="page-heading">
				<h1>
					<s:message code="${pageHeader}" />
				</h1>
			</div>
			<tiles:insertAttribute name="messages" />
			<tiles:insertAttribute name="pagebody" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
	</html>
</jsp:root>