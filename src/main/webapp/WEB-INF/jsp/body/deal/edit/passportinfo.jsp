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
		
		<c:if test="${passport.hasOtherDocument}">
		<script>
			$(window).load(function() {
		        $('#nameOfOtherDocument').prop('disabled', false);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#hasOtherDocument').change(
							function() {
							    if ($(this).is(':checked')) {
							        $('#nameOfOtherDocument').prop('disabled', false);
							    } else {
							        $('#nameOfOtherDocument').prop('disabled', true);
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
					<h2><s:message code="label.header.edit.deal.step3.passport" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="passport">
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.passport.serial" /></th>
											<td class="border-line"><form:input path="serial" type="text" class="inp-form"/></td>
											<td><form:errors path="serial" element="p" cssClass="inp-form-error"  /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.passport.number" /></th>
											<td class="border-line"><form:input path="number" type="text" class="inp-form"/></td>
											<td><form:errors path="number" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.passport.registration.date" /></th>
											<td class="border-line"><form:input path="passportRegistrationDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="passportRegistrationDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.passport.who.gave.passport" /></th>
											<td class="border-line"><form:input path="whoGavePassport" type="text" class="inp-form"/></td>
											<td><form:errors path="whoGavePassport" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.tax.number" /></th>
											<td class="border-line"><form:input path="idTaxNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="idTaxNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>		
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.tax.number.registration.date" /></th>
											<td class="border-line"><form:input path="idTaxRegistrationDate" type="text" class="inp-form" id="datepicker2"/></td>
											<td><form:errors path="idTaxRegistrationDate" element="p" cssClass="inp-form-error" /></td>
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.tax.number.who.gave.tax.number" /></th>
											<td class="border-line"><form:input path="whoGaveIdtax" type="text" class="inp-form"/></td>
											<td><form:errors path="whoGaveIdtax" element="p" cssClass="inp-form-error" /></td>
										</tr>		
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.has.other.document" /></th>
											<td class="border-line"><form:checkbox id="hasOtherDocument" path="hasOtherDocument"/></td>
											<td/>											
										</tr>
										<tr>
											<th valign="top"><s:message code="label.add.deal.other.document.name" /></th>
											<td><form:input path="nameOfOtherDocument" id="nameOfOtherDocument" type="text" class="inp-form" disabled="true"/></td>
											<td><form:errors path="nameOfOtherDocument" element="p" cssClass="inp-form-error" /></td>
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