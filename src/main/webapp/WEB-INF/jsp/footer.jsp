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
	<div id="footer">
		<div id="footer-left">
			<s:message code="label.footer.copyright"/>
			<jsp:text>   </jsp:text>
			<jsp:element name="a">
				<jsp:attribute name="href"> <s:message code="label.footer.copyright.link"/> </jsp:attribute>
				<jsp:body><s:message code="label.footer.copyright.link.name"/></jsp:body>
			</jsp:element>
			<jsp:text>   </jsp:text>
			<s:message code="label.footer.copyright.rights"/>
			<jsp:text>   </jsp:text>
			<s:message code="label.version"/>
		</div>
	</div>
</jsp:root>