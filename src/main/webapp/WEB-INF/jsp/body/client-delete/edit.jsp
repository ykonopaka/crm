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
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_clients').addClass('sub_show');
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
									<form:form method="POST" commandName="client">
										<tr>
											<th />
											<td></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.edit.client.last.name" /></th>
											<td><form:input path="lastName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="lastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.edit.client.first.name" /></th>
											<td><form:input path="firstName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="firstName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.edit.client.middle.name" /></th>
											<td><form:input path="middleName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="middleName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.edit.client.employment.type" /></th>
											<td><form:select id="employment_type_choose"
													multiple="single" path="employmentType.id"
													class="inp-form-select">
													<form:options items="${employmentTypesList}" itemValue="id"
														itemLabel="description" />
												</form:select></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.edit.client.phone.numbers" /></th>
											<td><a
												href="${contextPath}/workflow/client/${client.id}/edit/manageclientphonenumbers">
													<s:message
														code="link.manage.client.phones.when.editing.client" />
											</a></td>


										</tr>
										<tr>
											<th />
										</tr>
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-submit-${locale}" /> <a class="form-reset-${locale}"
												href="${contextPath}/workflow/manageclients/init"></a></td>
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