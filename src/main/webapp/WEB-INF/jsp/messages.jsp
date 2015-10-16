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
	<c:if test="${message != null}">
	<c:set var="color" value="blue"/>
	<c:choose>
    	<c:when test="${message.status == '0'}">
        	<c:set var="color" value="red"/>
    	</c:when>
    	<c:when test="${message.status == '1'}">
        	<c:set var="color" value="yellow"/>
    	</c:when>
		<c:when test="${message.status == '2'}">
        	<c:set var="color" value="green"/>
    	</c:when>
    	<c:otherwise>
        	<c:set var="color" value="blue"/>
    	</c:otherwise>
	</c:choose>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td>
				<!--  start message-yellow -->
				<div id="message-${color}">
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="${color}-left">${message.description}</td>
							<td class="${color}-right" />
						</tr>
					</table>
				</div> <!--  end message-yellow -->
			</td>
		</tr>
	</table>
	</c:if> 
	
</jsp:root>