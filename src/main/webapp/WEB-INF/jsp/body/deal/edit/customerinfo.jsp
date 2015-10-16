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

	<c:if test="${customer.wasLastNameChanged}">
		<script>
			$(window).load(function() {
		        $('#datepicker2').prop('disabled', false);
		        $('#previousLastName').prop('disabled', false);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#wasLastNameChanged').change(
							function() {
							    if ($(this).is(':checked')) {
							        $('#datepicker2').prop('disabled', false);
							        $('#previousLastName').prop('disabled', false);
							    } else {
							        $('#datepicker2').prop('disabled', true);
							        $('#previousLastName').prop('disabled', true);
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
					<h2><s:message code="label.header.edit.deal.step2.client" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="customer">
										<tr>
											<th/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.last.name" /></th>
											<td class="border-line"><form:input path="lastName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="lastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.first.name" /></th>
											<td class="border-line"><form:input path="firstName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="firstName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.middle.name" /></th>
											<td class="border-line"><form:input path="middleName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="middleName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.gender" /></th>
											<td class="border-line"><form:select path="genderType.id" type="text"
													items="${genderTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.birthdate" /></th>
											<td class="border-line"><form:input path="birthDate" type="text"
													class="inp-form" id="datepicker1" /></td>
											<td><form:errors path="birthDate" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.birthplace" /></th>
											<td class="border-line"><form:input path="birthPlace" type="text"
													class="inp-form" /></td>
											<td><form:errors path="birthPlace" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.education" /></th>
											<td class="border-line"><form:select path="educationType.id" type="text"
													items="${educationTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.speciality" /></th>
											<td class="border-line"><form:input path="speciality" type="text"
													class="inp-form" /></td>
											<td><form:errors path="speciality" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.military.service" /></th>
											<td class="border-line"><form:select path="militaryServiceType.id" type="text"
													items="${militaryServiceTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.conviction" /></th>
											<td class="border-line"><form:select path="convictionType.id" type="text"
													items="${convictionTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.mother.lastname" /></th>
											<td class="border-line"><form:input path="motherLastName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="motherLastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.was.lastname.changed" /></th>
											<td class="border-line"><form:checkbox id="wasLastNameChanged" path="wasLastNameChanged"/></td>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.lastname.change.date" /></th>
											<td class="border-line"><form:input path="lastNameChangeDate" type="text"
													class="inp-form lastNameChangeDate" id="datepicker2" disabled="true"/></td>
											<td><form:errors path="lastNameChangeDate" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.previous.lastname" /></th>
											<td class="border-line"><form:input path="previousLastName" type="text"
													class="inp-form" disabled="true"/></td>
											<td><form:errors path="previousLastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message
													code="label.add.deal.customer.number.all.children" /></th>
											<td class="border-line"><form:input path="numberOfAllChildren" type="text"
													class="inp-form" /></td>
											<td><form:errors path="numberOfAllChildren" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.add.deal.customer.number.young.children" /></th>
											<td><form:input path="numberOfYoungChildren" type="text"
													class="inp-form" /></td>
											<td><form:errors path="numberOfYoungChildren" element="p"
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