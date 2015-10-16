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
					$('#isExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('[name="organizationName"]').prop('disabled', false);
									$('[name="positionName"]').prop('disabled', false);
									$('[name="address"]').prop('disabled', false);
									$('.workingTermFrom').prop('disabled', false);
									$('.businessLineType').prop('disabled', false);
									$('.organizationType').prop('disabled', false);
							    } else {
									$('[name="organizationName"]').prop('disabled', true);
									$('[name="positionName"]').prop('disabled', true);
									$('[name="address"]').prop('disabled', true);
									$('.workingTermFrom').prop('disabled', true);
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
					<h2><s:message code="label.header.add.deal.step10.previous.working.place" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="previousWorkingPlace">
										<tr>
											<th style="min-width: 300px;"/>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.does.exist" /></th>
											<td class="border-line"><form:checkbox id="isExisted" path="isExisted"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.working.term.from" /></th>
											<td class="border-line"><form:select path="workingTermFrom"  type="text"
													items="${workingTermFromYearsList}" 
													class="inp-form-select workingTermFrom"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.organization.name" /></th>
											<td class="border-line"><form:input path="organizationName" type="text" class="inp-form"/></td>
											<td><form:errors path="organizationName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.position.name" /></th>
											<td class="border-line"><form:input path="positionName" type="text" class="inp-form"/></td>
											<td><form:errors path="positionName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.business.line" /></th>
											<td class="border-line"><form:select path="businessLineType.id"  type="text"
													items="${businessLineTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select businessLineType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step10.organization.type" /></th>
											<td class="border-line"><form:select path="organizationType.id"  type="text"
													items="${organizationTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select organizationType"/></td>
											<td/>													
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step10.address" /></th>
											<td><form:input path="address" type="text" class="inp-form"/></td>
											<td><form:errors path="address" element="p" cssClass="inp-form-error" /></td>
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