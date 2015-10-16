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
	<div id="forgotbox">
		<form:form method="POST" class="signin" commandName="user">
			<div id="forgotbox-text">
				<s:message code="message.forgot.password" />
			</div>
			<div id="forgot-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th />
						<td></td>
					</tr>
					<tr>
						<th><s:message code="label.email" /></th>
						<td><form:input path="email" id="email" type="text" value=""
								class="login-inp" /></td>
					</tr>
					<tr>
						<th />
						<td valign="top" />
					</tr>
					<tr>
						<th />
						<td><form:errors path="email" cssClass="login_msg"
								element="div" /> <input name="commit" type="submit"
							class="submit-forgot-${locale}" /></td>
					</tr>
				</table>
			</div>
			<div class="clear" />
			<a href="${contextPath}/login" class="back-login"><s:message
					code="link.backToLogin" /></a>
		</form:form>
	</div>
</jsp:root>
