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
		
	<c:if test="${incomeOutcome.isAdditionalIncomePresent == false}">
		<script>
			$(window).load(function() {
				$('.additionalIncomeType').prop('disabled', true);
				$('[name="additionalIncomeSize"]').prop('disabled', true);
			});
		</script>
	</c:if>	
	
	<c:if test="${incomeOutcome.isMarried == false}">
		<script>
			$(window).load(function() {
				$('.spouseIncomeType').prop('disabled', true);
				$('[name="spouseIncomeSize"]').prop('disabled', true);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#isAdditionalIncomePresent').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.additionalIncomeType').prop('disabled', false);
									$('[name="additionalIncomeSize"]').prop('disabled', false);
							    } else {
									$('.additionalIncomeType').prop('disabled', true);
									$('[name="additionalIncomeSize"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#isMarried').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.spouseIncomeType').prop('disabled', false);
									$('[name="spouseIncomeSize"]').prop('disabled', false);
							    } else {
									$('.spouseIncomeType').prop('disabled', true);
									$('[name="spouseIncomeSize"]').prop('disabled', true);
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
					<h2><s:message code="label.header.edit.deal.step11.income.outcome" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="incomeOutcome">
										<tr>
											<th style="min-width: 400px;"/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th><h2><s:message code="label.header.add.deal.step11.income" /></h2></th>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.income.size" /></th>
											<td class="border-line"><form:input path="mainIncomeSize" type="text" class="inp-form"/></td>
											<td><form:errors path="mainIncomeSize" element="p" cssClass="inp-form-error"  /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.income.type" /></th>
											<td class="border-line"><form:select path="mainIncomeType.id"  type="text"
													items="${miIncomeTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select maritalStatusType"/></td>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.income.documents.present" /></th>
											<td class="border-line"><form:checkbox path="areDocumentsPresent"/></td>
											<td/>
										</tr>
										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.additional.income.present" /></th>
											<td class="border-line"><form:checkbox path="isAdditionalIncomePresent" id="isAdditionalIncomePresent"/></td>
											<td/>
										</tr>
										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.additional.income.size" /></th>
											<td class="border-line"><form:input path="additionalIncomeSize" type="text" class="inp-form"/></td>
											<td><form:errors path="additionalIncomeSize" element="p" cssClass="inp-form-error"  /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.additional.income.type" /></th>
											<td class="border-line"><form:select path="additionalIncomeType.id"  type="text"
													items="${aiIncomeTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select additionalIncomeType"/></td>
											<td/>													
										</tr>
										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.is.married" /></th>
											<td class="border-line"><form:checkbox path="isMarried" id="isMarried"/></td>
											<td/>											
										</tr>
										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.spouse.income.size" /></th>
											<td class="border-line"><form:input path="spouseIncomeSize" type="text" class="inp-form"/></td>
											<td><form:errors path="spouseIncomeSize" element="p" cssClass="inp-form-error"  /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step11.spouse.income.type" /></th>
											<td><form:select path="spouseIncomeType.id"  type="text"
													items="${siIncomeTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select spouseIncomeType"/></td>
											<td/>													
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>										
										<tr>
											<th><h2><s:message code="label.header.add.deal.step11.outcome" /></h2></th>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step11.family.outcome" /></th>
											<td class="border-line"><form:input path="totalOutcome" type="text" class="inp-form"/></td>
											<td><form:errors path="totalOutcome" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step11.family.number.people" /></th>
											<td><form:input path="familyPeopleNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="familyPeopleNumber" element="p" cssClass="inp-form-error" /></td>
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