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
	<script>
		$('#administration_mi').removeClass('select').addClass('current');
		$('#administration_mi_container').addClass('show');
		$('#administration_mi_users').addClass('sub_show');
	</script>
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		id="content-table">
		<tr>
		<tr>
			<th class="topleft"></th>
			<td id="tbl-border-top"></td>
			<th class="topright"></th>
		</tr>
		</tr>
		<tr>
			<td id="tbl-border-left"></td>
			<td>
				<div id="content-table-inner">
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="user">
										<tr class="border-line">
											<th valign="top"><s:message code="label.delete.user.settings.id"/></th>
											<td>${user.id}</td>
											<td/>
										</tr>
										<tr class="border-line">
											<th valign="top"><s:message code="label.delete.user.settings.username"/></th>
											<td>${user.username}</td>
											<td/>
										</tr>
										<tr class="border-line">
											<th valign="top"><s:message code="label.delete.user.settings.first.name"/></th>
											<td>${user.firstName}</td>
											<td/>											
										</tr>
										<tr class="border-line">
											<th valign="top"><s:message code="label.delete.user.settings.last.name"/></th>
											<td>${user.lastName}</td>
											<td/>											
										</tr>
										<tr class="border-line">
											<th valign="top"><s:message code="label.delete.user.settings.email"/></th>
											<td>${user.email}</td>
											<td/>											
										</tr>
										
										<tr>
											<th valign="top"><s:message code="label.delete.user.settings.office"/></th>
											<c:choose>
												<c:when test="${user.office.isEnabled == true}">
													<td>${user.office.name}</td>
												</c:when>
												<c:otherwise>
													<td><s:message
															code="label.delete.user.no.office" /></td>
												</c:otherwise>
											</c:choose>
											<td/>											
										</tr>
										<tr>
											<th />
											<td/>
											<td/>
										</tr>
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-submit-${locale}" />
												<a class="form-reset-${locale}" href="${contextPath}/administration/manageusers"></a>
											</td>
											<td/>											
										</tr>
									</form:form>
								</table>
							</td>
							<td></td>
						</tr>
					</table>
					<div class="clear"></div>
				</div>
			</td>
			<td id="tbl-border-right"></td>
		</tr>
		<tr>
			<th class="sized bottomleft"></th>
			<td id="tbl-border-bottom"></td>
			<th class="sized bottomright"></th>
		</tr>
	</table>
</jsp:root>