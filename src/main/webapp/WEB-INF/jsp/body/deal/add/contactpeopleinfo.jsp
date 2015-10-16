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
		
		<c:if test="${contactPersons.spExist}">
		<script>
			$(window).load(function() {
				$('.spContactPersonType').prop('disabled', false);
				$('[name="spLastName"]').prop('disabled', false);
				$('[name="spFirstName"]').prop('disabled', false);
				$('[name="spMiddleName"]').prop('disabled', false);
				$('[name="spMobileNumber"]').prop('disabled', false);
				$('[name="spHomeWorkNumber"]').prop('disabled', false);
				$('[name="spBirthDate"]').prop('disabled', false);
				$('[name="spAddress"]').prop('disabled', false);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#spExist').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.spContactPersonType').prop('disabled', false);
									$('[name="spLastName"]').prop('disabled', false);
									$('[name="spFirstName"]').prop('disabled', false);
									$('[name="spMiddleName"]').prop('disabled', false);
									$('[name="spMobileNumber"]').prop('disabled', false);
									$('[name="spHomeWorkNumber"]').prop('disabled', false);
									$('[name="spBirthDate"]').prop('disabled', false);
									$('[name="spAddress"]').prop('disabled', false);
							    } else {
									$('.spContactPersonType').prop('disabled', true);
									$('[name="spLastName"]').prop('disabled', true);
									$('[name="spFirstName"]').prop('disabled', true);
									$('[name="spMiddleName"]').prop('disabled', true);
									$('[name="spMobileNumber"]').prop('disabled', true);
									$('[name="spHomeWorkNumber"]').prop('disabled', true);
									$('[name="spBirthDate"]').prop('disabled', true);
									$('[name="spAddress"]').prop('disabled', true);
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
					<h2><s:message code="label.header.add.deal.step7.contact.people" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="contactPersons">
										<tr>
											<th/>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th><h2><s:message code="label.header.add.deal.step7.fp" /></h2></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.last.name" /></th>
											<td class="border-line"><form:input path="fpLastName" type="text" class="inp-form"/></td>
											<td><form:errors path="fpLastName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.first.name" /></th>
											<td class="border-line"><form:input path="fpFirstName" type="text" class="inp-form"/></td>
											<td><form:errors path="fpFirstName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.middle.name" /></th>
											<td class="border-line"><form:input path="fpMiddleName" type="text" class="inp-form"/></td>
											<td><form:errors path="fpMiddleName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.type" /></th>
											<td class="border-line"><form:select path="fpContactPersonType.id"  type="text"
													items="${fpContactPersonTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.mobile.number" /></th>
											<td class="border-line"><form:input path="fpMobileNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="fpMobileNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.home.number" /></th>
											<td class="border-line"><form:input path="fpHomeWorkNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="fpHomeWorkNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.fp.birth.date" /></th>
											<td class="border-line"><form:input path="fpBirthDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="fpBirthDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step7.fp.address" /></th>
											<td><form:input path="fpAddress" type="text" class="inp-form"/></td>
											<td><form:errors path="fpAddress" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>											
										</tr>										
										<tr>
											<th><h2><s:message code="label.header.add.deal.step7.sp" /></h2></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.present" /></th>
											<td class="border-line"><form:checkbox id="spExist" path="spExist"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.last.name" /></th>
											<td class="border-line"><form:input path="spLastName" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spLastName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.first.name" /></th>
											<td class="border-line"><form:input path="spFirstName" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spFirstName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.middle.name" /></th>
											<td class="border-line"><form:input path="spMiddleName" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spMiddleName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.type" /></th>
											<td class="border-line"><form:select path="spContactPersonType.id"  type="text"
													items="${spContactPersonTypeList}" itemValue="id" itemLabel="description" disabled="true"
													class="inp-form-select spContactPersonType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.mobile.number" /></th>
											<td class="border-line"><form:input path="spMobileNumber" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spMobileNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.home.number" /></th>
											<td class="border-line"><form:input path="spHomeWorkNumber" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spHomeWorkNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step7.sp.birth.date" /></th>
											<td class="border-line"><form:input path="spBirthDate" type="text" class="inp-form" id="datepicker2" disabled="true"/></td>
											<td><form:errors path="spBirthDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr >
											<th valign="top"><s:message code="label.header.add.deal.step7.sp.address" /></th>
											<td><form:input path="spAddress" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="spAddress" element="p" cssClass="inp-form-error" /></td>
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