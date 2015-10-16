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
		
	<c:if test="${workingPlace.positionType.id ne '1'}">
		<script>
			$(window).load(function() {
		        $('#numberOfWorkers').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${workingPlace.jobType.id eq '8'}">
		<script>
			$(window).load(function() {
		        $('#EDRPOUcode').prop('disabled', true);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('.positionType').change(
							function() {
								if ($(this).val() == "2" || $(this).val() == "3") {
									$('[name="numberOfWorkers"]').prop('disabled', false);
								} else {
									$('[name="numberOfWorkers"]').prop('disabled', true);
								}
							}
						);
					});
		
		$(window).load(
				function() {
					$('.jobType').change(
							function() {
								if ($(this).val() == "8") {
									$('[name="EDRPOUcode"]').prop('disabled', true);
								} else {
									$('[name="EDRPOUcode"]').prop('disabled', false);
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
					<h2><s:message code="label.header.edit.deal.step8.working.place" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="workingPlace">
										<tr>
											<th style="min-width: 300px;"/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th><h2><s:message code="label.header.add.deal.step8.current.working.place" /></h2></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.starting.date" /></th>
											<td class="border-line"><form:input path="startingDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="startingDate" element="p" cssClass="inp-form-error"/></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.organization.name" /></th>
											<td class="border-line"><form:input path="organizationName" type="text" class="inp-form"/></td>
											<td><form:errors path="organizationName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.job.type" /></th>
											<td class="border-line"><form:select path="jobType.id"  type="text"
													items="${jobTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select jobType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.edrpou.code" /></th>
											<td class="border-line"><form:input path="EDRPOUcode" type="text" class="inp-form"/></td>
											<td><form:errors path="EDRPOUcode" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.position" /></th>
											<td class="border-line"><form:select path="positionType.id"  type="text"
													items="${positionTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select positionType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.number.of.workers" /></th>
											<td class="border-line"><form:input path="numberOfWorkers" type="text" class="inp-form"/></td>
											<td><form:errors path="numberOfWorkers" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.business.line" /></th>
											<td class="border-line"><form:select path="businessLineType.id"  type="text"
													items="${businessLineTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select aRegionType"/></td>
											<td/>													
										</tr>																										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.position.name" /></th>
											<td class="border-line"><form:input path="positionName" type="text" class="inp-form"/></td>
											<td><form:errors path="positionName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.company.size" /></th>
											<td class="border-line"><form:select path="companySizeType.id"  type="text"
													items="${companySizeTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.term.of.service.last" /></th>
											<td class="border-line"><form:input path="lengthOfServiceLastPlace" type="text" class="inp-form"/></td>
											<td><form:errors path="lengthOfServiceLastPlace" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.term.of.service.total" /></th>
											<td class="border-line"><form:input path="lengthOfServiceTotal" type="text" class="inp-form"/></td>
											<td><form:errors path="lengthOfServiceTotal" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.organization.type" /></th>
											<td class="border-line"><form:select path="organizationType.id"  type="text"
													items="${organizationTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step8.existing.from.year" /></th>
											<td><form:select path="companyExistingTerm"  type="text"
													items="${yearsList}" 
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>										
										<tr>
											<th><h2><s:message code="label.header.add.deal.step8.current.working.place.address" /></h2></th>
											<td/>
											<td/>											
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.region" /></th>
											<td class="border-line"><form:select path="regionType.id"  type="text"
													items="${regionTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.town" /></th>
											<td class="border-line"><form:input path="town" type="text" class="inp-form"/></td>
											<td><form:errors path="town" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.district" /></th>
											<td class="border-line"><form:input path="district" type="text" class="inp-form"/></td>
											<td><form:errors path="district" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.street" /></th>
											<td class="border-line"><form:input path="street" type="text" class="inp-form"/></td>
											<td><form:errors path="street" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.house" /></th>
											<td class="border-line"><form:input path="house" type="text" class="inp-form"/></td>
											<td><form:errors path="house" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.building" /></th>
											<td class="border-line"><form:input path="building" type="text" class="inp-form"/></td>
											<td><form:errors path="building" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.office" /></th>
											<td class="border-line"><form:input path="office" type="text" class="inp-form"/></td>
											<td><form:errors path="office" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step8.postcode" /></th>
											<td class="border-line"><form:input path="postcode" type="text" class="inp-form"/></td>
											<td><form:errors path="postcode" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step8.phone" /></th>
											<td><form:input path="phoneNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="phoneNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-next-${locale}" />
											<a class="form-reset-${locale}" href="${contextPath}/workflow/managedeals/init"></a>
											</td>
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