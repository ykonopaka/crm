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
		
		<c:if test="${address.registrationIsActual}">
		<script>
			$(window).load(function() {
				$('.aRegionType').prop('disabled', true);
				$('[name="aTown"]').prop('disabled', true);
				$('[name="aDistrict"]').prop('disabled', true);
				$('[name="aStreet"]').prop('disabled', true);
				$('[name="aHouse"]').prop('disabled', true);
				$('[name="aBuilding"]').prop('disabled', true);
				$('[name="aApartment"]').prop('disabled', true);
				$('[name="aPostcode"]').prop('disabled', true);
				$('[name="aTermOfLiving"]').prop('disabled', true);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#registrationIsActual').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.aRegionType').prop('disabled', true);
									$('[name="aTown"]').prop('disabled', true);
									$('[name="aDistrict"]').prop('disabled', true);
									$('[name="aStreet"]').prop('disabled', true);
									$('[name="aHouse"]').prop('disabled', true);
									$('[name="aBuilding"]').prop('disabled', true);
									$('[name="aApartment"]').prop('disabled', true);
									$('[name="aPostcode"]').prop('disabled', true);
									$('[name="aTermOfLiving"]').prop('disabled', true);
							    } else {
									$('.aRegionType').prop('disabled', false);
									$('[name="aTown"]').prop('disabled', false);
									$('[name="aDistrict"]').prop('disabled', false);
									$('[name="aStreet"]').prop('disabled', false);
									$('[name="aHouse"]').prop('disabled', false);
									$('[name="aBuilding"]').prop('disabled', false);
									$('[name="aApartment"]').prop('disabled', false);
									$('[name="aPostcode"]').prop('disabled', false);
									$('[name="aTermOfLiving"]').prop('disabled', false);
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
					<h2><s:message code="label.header.add.deal.step5.address" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="address">
										<tr>
											<th/>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th>
											<h2><s:message code="label.add.deal.registration.address" /></h2>
											</th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.region" /></th>
											<td class="border-line"><form:select path="rRegionType.id"  type="text"
													items="${rRegionTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.town" /></th>
											<td class="border-line"><form:input path="rTown" type="text" class="inp-form"/></td>
											<td><form:errors path="rTown" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.district" /></th>
											<td class="border-line"><form:input path="rDistrict" type="text" class="inp-form"/></td>
											<td><form:errors path="rDistrict" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.street" /></th>
											<td class="border-line"><form:input path="rStreet" type="text" class="inp-form"/></td>
											<td><form:errors path="rStreet" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.house" /></th>
											<td class="border-line"><form:input path="rHouse" type="text" class="inp-form"/></td>
											<td><form:errors path="rHouse" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.building" /></th>
											<td class="border-line"><form:input path="rBuilding" type="text" class="inp-form"/></td>
											<td><form:errors path="rBuilding" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.apartment" /></th>
											<td class="border-line"><form:input path="rApartment" type="text" class="inp-form"/></td>
											<td><form:errors path="rApartment" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.postcode" /></th>
											<td class="border-line"><form:input path="rPostcode" type="text" class="inp-form"/></td>
											<td><form:errors path="rPostcode" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.registration.address.date" /></th>
											<td class="border-line"><form:input path="rRegistrationDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="rRegistrationDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.add.deal.registration.address.term" /></th>
											<td><form:select path="rTermOfLiving"  type="text"
													items="${rYearsList}" 
													class="inp-form-select rRegionType"/></td>
											<td/>													
										</tr>
										<tr>
											<th />
											<td/>
											<td/>
										</tr>
										<tr>
											<th>
											<h2><s:message code="label.add.deal.actual.address" /></h2>
											</th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.is.the.same" /></th>
											<td class="border-line"><form:checkbox id="registrationIsActual" path="registrationIsActual"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.region" /></th>
											<td class="border-line"><form:select path="aRegionType.id"  type="text"
													items="${aRegionTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select aRegionType"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.town" /></th>
											<td class="border-line"><form:input path="aTown" type="text" class="inp-form"/></td>
											<td><form:errors path="aTown" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.district" /></th>
											<td class="border-line"><form:input path="aDistrict" type="text" class="inp-form"/></td>
											<td><form:errors path="aDistrict" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.street" /></th>
											<td class="border-line"><form:input path="aStreet" type="text" class="inp-form"/></td>
											<td><form:errors path="aStreet" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.house" /></th>
											<td class="border-line"><form:input path="aHouse" type="text" class="inp-form"/></td>
											<td><form:errors path="aHouse" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.building" /></th>
											<td class="border-line"><form:input path="aBuilding" type="text" class="inp-form"/></td>
											<td><form:errors path="aBuilding" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.apartment" /></th>
											<td class="border-line"><form:input path="aApartment" type="text" class="inp-form"/></td>
											<td><form:errors path="aApartment" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.add.deal.actual.address.postcode" /></th>
											<td class="border-line"><form:input path="aPostcode" type="text" class="inp-form"/></td>
											<td><form:errors path="aPostcode" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.add.deal.actual.address.term" /></th>
											<td><form:select path="aTermOfLiving"  type="text"
													items="${aYearsList}" 
													class="inp-form-select aRegionType"/></td>
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