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
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('.maritalStatusType').change(
							function() {
								if ($(this).val() == "1" || $(this).val() == "2") {
									$('[name="marriageRegistrationDate"]').prop('disabled', false);
									$('[name="lastName"]').prop('disabled', false);
									$('[name="firstName"]').prop('disabled', false);
									$('[name="middleName"]').prop('disabled', false);
									$('[name="birthDate"]').prop('disabled', false);
									$('[name="idTaxNumber"]').prop('disabled', false);
									$('[name="phoneNumberHomeWork"]').prop('disabled', false);
									$('[name="phoneNumberMobile"]').prop('disabled', false);
									$('[name="workplace"]').prop('disabled', false);
									$('[name="position"]').prop('disabled', false);
									$('.jobType').prop('disabled', false);
									$('.businessLineType').prop('disabled', false);
									$('.organizationType').prop('disabled', false);
								} else {
									$('[name="marriageRegistrationDate"]').prop('disabled', true);
									$('[name="lastName"]').prop('disabled', true);
									$('[name="firstName"]').prop('disabled', true);
									$('[name="middleName"]').prop('disabled', true);
									$('[name="birthDate"]').prop('disabled', true);
									$('[name="idTaxNumber"]').prop('disabled', true);
									$('[name="phoneNumberHomeWork"]').prop('disabled', true);
									$('[name="phoneNumberMobile"]').prop('disabled', true);
									$('[name="workplace"]').prop('disabled', true);
									$('[name="position"]').prop('disabled', true);
									$('.jobType').prop('disabled', true);
									$('.businessLineType').prop('disabled', true);
									$('.organizationType').prop('disabled', true);
								}
							}
						);
					});
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
					<h2><s:message code="label.header.edit.deal.step4.marriage" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="marriage">
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.marriage.marital.status" /></th>
											<td class="border-line"><form:select path="maritalStatusType.id"  type="text"
													items="${maritalStatusTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select maritalStatusType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.registration.date" /></th>
											<td class="border-line"><form:input path="marriageRegistrationDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="marriageRegistrationDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.last.name" /></th>
											<td class="border-line"><form:input path="lastName" type="text" class="inp-form"/></td>
											<td><form:errors path="lastName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.first.name" /></th>
											<td class="border-line"><form:input path="firstName" type="text" class="inp-form"/></td>
											<td><form:errors path="firstName" element="p" cssClass="inp-form-error" /></td>
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.middle.name" /></th>
											<td class="border-line"><form:input path="middleName" type="text" class="inp-form"/></td>
											<td><form:errors path="middleName" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.birth.date" /></th>
											<td class="border-line"><form:input path="birthDate" type="text" class="inp-form" id="datepicker2"/></td>
											<td><form:errors path="birthDate" element="p" cssClass="inp-form-error" /></td>
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.id.tax.number" /></th>
											<td class="border-line"><form:input path="idTaxNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="idTaxNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.phone.work.home" /></th>
											<td class="border-line"><form:input path="phoneNumberHomeWork" type="text" class="inp-form"/></td>
											<td><form:errors path="phoneNumberHomeWork" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.phone.mobile" /></th>
											<td class="border-line"><form:input path="phoneNumberMobile" type="text" class="inp-form"/></td>
											<td><form:errors path="phoneNumberMobile" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.workplace" /></th>
											<td class="border-line"><form:input path="workplace" type="text" class="inp-form"/></td>
											<td><form:errors path="workplace" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.position" /></th>
											<td class="border-line"><form:input path="position" type="text" class="inp-form"/></td>
											<td><form:errors path="position" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.job.type" /></th>
											<td class="border-line"><form:select path="jobType.id" 
													type="text"
													items="${jobTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select jobType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.marriage.spouse.business.line.type" /></th>
											<td class="border-line"><form:select path="businessLineType.id" 
													type="text"
													items="${businessLineTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select businessLineType"/></td>
											<td/>													
										</tr>
										<tr>
											<th valign="top"><s:message code="label.add.deal.marriage.spouse.organization.type" /></th>
											<td><form:select path="organizationType.id" 
													type="text"
													items="${organizationTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select organizationType"/></td>
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
												value="" class="form-next-${locale}" />
											<a class="form-reset-${locale}" href="${contextPath}/workflow/managedeals/init"></a>
											</td>
											<td/>
										</tr>
										
									</form:form>
								</table>
							</td>
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