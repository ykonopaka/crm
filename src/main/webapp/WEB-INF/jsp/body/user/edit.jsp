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
										<tr>
											<th class="border-line" valign="top"><s:message code="label.edit.user.settings.id"/></th>
											<td class="border-line"><form:input path="id" type="text" class="inp-form"
													readonly="true" /></td>
										</tr>
									
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.edit.user.settings.username" /></th>
											<td class="border-line"><form:input path="username" type="text"
													class="inp-form" readonly="true"/></td>
											<td><form:errors path="username" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.edit.user.settings.first.name" /></th>
											<td class="border-line"><form:input path="firstName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="firstName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.edit.user.settings.last.name" /></th>
											<td class="border-line"><form:input path="lastName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="lastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.edit.user.settings.email" /></th>
											<td class="border-line"><form:input path="email" type="text"
													class="inp-form" /></td>
											<td><form:errors path="email" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<c:choose>
											<c:when test="${empty officesList}">
												<tr>
													<th class="border-line" valign="top"><s:message
															code="label.edit.user.settings.office" /></th>
													<td  class="border-line">
													<a
														href="${contextPath}/administration/addoffice">
														<s:message code="link.add.new.office.when.editing.user" />
													</a>
													</td>

												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<th class="border-line" valign="top"><s:message
															code="label.edit.user.settings.office" /></th>
													<td class="border-line"><form:select path="office.id" type="text"
															items="${officesList}" itemValue="id" itemLabel="name"
															class="inp-form-select" /></td>
													<td/>
												</tr>
											</c:otherwise>
										</c:choose>
										<tr>
											<th valign="top"><s:message
													code="label.edit.user.settings.role" /></th>
											<td>
												<div>
													<form:checkboxes path="roles" items="${rolesList}"
														itemLabel="description" itemValue="authority" element="p" />
												</div>
											</td>
											<td><form:errors path="roles" element="p"
													cssClass="inp-form-error" /></td>
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