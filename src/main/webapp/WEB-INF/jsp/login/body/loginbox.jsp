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
	<div id="loginbox">
		<s:url var="authUrl" value="/j_spring_security_check" />
		<form method="post" class="signin" action="${authUrl}">
			<div id="login-inner">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th><s:message code="label.username" /></th>
						<td><input name="j_username" type="text" class="login-inp" />
						</td>
					</tr>
					<tr>
						<th><s:message code="label.password" /></th>
						<td><input name="j_password" type="password"
							class="login-inp" /></td>
					</tr>
					<tr>
						<th />
						<td valign="top" />
					</tr>
					<tr>
						<th />
						<td>
							<div class="login_msg">
								<c:if test="${not empty msg}">${msg}</c:if>
							</div> <input name="commit" type="submit"
							class="submit-login-${locale}" />
						</td>
					</tr>
				</table>
			</div>
		</form>
		<div class="clear"></div>
		<a href="${contextPath}/forgotpasswd" class="forgot-pwd"><s:message
				code="link.forgotPassword" /></a>
	</div>
</jsp:root>