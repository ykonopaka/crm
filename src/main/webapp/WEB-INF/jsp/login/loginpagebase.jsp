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
	<link rel="stylesheet" href="${contextPath}/static/css/screen.css" type="text/css"
		media="screen" title="default" />
	<link rel="shortcut icon" href="${contextPath}/static/ico/icon.png"/>
	</head>
	<body id="login-bg">
		<div id="language">
			<span> <a href="?lang=en">en</a>|<a href="?lang=ru">ru</a>
			</span>
		</div>
		<div id="login-holder">
			<div id="logo-login">
				<!-- <a href="${contextPath}/index"> <img
					src="${contextPath}/static/images/shared/logo.png" width="156" height="40" alt="" />
				</a>
				 -->
			</div>
			<div class="clear" />
			<tiles:insertAttribute name="box" />
		</div>
	</body>
	</html>
</jsp:root>
