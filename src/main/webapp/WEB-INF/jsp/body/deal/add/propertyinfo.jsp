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
		
	<c:if test="${property.isCarPresent == false}">
		<script>
			$(window).load(function() {
				$('.carReleaseYear').prop('disabled', true);
				$('[name="carBrand"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${property.isEPPresent == false}">
		<script>
			$(window).load(function() {
				$('.epPurchaseYear').prop('disabled', true);
				$('.epPropertyHistoryType').prop('disabled', true);
				$('.epPropertyType').prop('disabled', true);
				$('[name="epAddress"]').prop('disabled', true);
				$('[name="epArea"]').prop('disabled', true);
				$('[name="epRoomNumber"]').prop('disabled', true);
				$('[name="epPrice"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${property.isGAPresent == false}">
		<script>
			$(window).load(function() {
				$('.gaPropertyType').prop('disabled', true);
				$('[name="gaAddress"]').prop('disabled', true);
				$('[name="gaArea"]').prop('disabled', true);
			});
		</script>
	</c:if>
		
	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(window).load(
				function() {
					$('#isCarPresent').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.carReleaseYear').prop('disabled', false);
									$('[name="carBrand"]').prop('disabled', false);
							    } else {
									$('.carReleaseYear').prop('disabled', true);
									$('[name="carBrand"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#isEPPresent').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.epPurchaseYear').prop('disabled', false);
									$('.epPropertyHistoryType').prop('disabled', false);
									$('.epPropertyType').prop('disabled', false);
									$('[name="epAddress"]').prop('disabled', false);
									$('[name="epArea"]').prop('disabled', false);
									$('[name="epRoomNumber"]').prop('disabled', false);
									$('[name="epPrice"]').prop('disabled', false);
							    } else {
									$('.epPurchaseYear').prop('disabled', true);
									$('.epPropertyHistoryType').prop('disabled', true);
									$('.epPropertyType').prop('disabled', true);
									$('[name="epAddress"]').prop('disabled', true);
									$('[name="epArea"]').prop('disabled', true);
									$('[name="epRoomNumber"]').prop('disabled', true);
									$('[name="epPrice"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#isGAPresent').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.gaPropertyType').prop('disabled', false);
									$('[name="gaAddress"]').prop('disabled', false);
									$('[name="gaArea"]').prop('disabled', false);
							    } else {
									$('.gaPropertyType').prop('disabled', true);
									$('[name="gaAddress"]').prop('disabled', true);
									$('[name="gaArea"]').prop('disabled', true);
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
					<h2><s:message code="label.header.add.deal.step12.property" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="property">
										<tr>
											<th/>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.is.car.present" /></th>
											<td class="border-line"><form:checkbox id="isCarPresent" path="isCarPresent"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.car.brand" /></th>
											<td class="border-line"><form:input path="carBrand" type="text" class="inp-form"/></td>
											<td><form:errors path="carBrand" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.car.release.year" /></th>
											<td class="border-line"><form:select path="carReleaseYear"  type="text"
													items="${carYearsList}" 
													class="inp-form-select carReleaseYear"/></td>
											<td/>													
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.is.ep.present" /></th>
											<td class="border-line"><form:checkbox id="isEPPresent" path="isEPPresent"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.address" /></th>
											<td class="border-line"><form:input path="epAddress" type="text" class="inp-form"/></td>
											<td><form:errors path="epAddress" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.area" /></th>
											<td class="border-line"><form:input path="epArea" type="text" class="inp-form"/></td>
											<td><form:errors path="epArea" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.room.number" /></th>
											<td class="border-line"><form:input path="epRoomNumber" type="text" class="inp-form"/></td>
											<td><form:errors path="epRoomNumber" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.approx.price" /></th>
											<td class="border-line"><form:input path="epPrice" type="text" class="inp-form"/></td>
											<td><form:errors path="epPrice" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.purchase.year" /></th>
											<td class="border-line"><form:select path="epPurchaseYear"  type="text"
													items="${epPurchaseYearList}" 
													class="inp-form-select epPurchaseYear"/></td>
											<td/>													
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.property.type" /></th>
											<td class="border-line"><form:select path="epPropertyType.id"  type="text"
													items="${epPropertyTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select epPropertyType"/></td>
											<td/>													
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ep.property.history" /></th>
											<td class="border-line"><form:select path="epPropertyHistoryType.id"  type="text"
													items="${propertyHistoryTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select epPropertyHistoryType"/></td>
											<td/>													
										</tr>																			
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.is.ga.present" /></th>
											<td class="border-line"><form:checkbox id="isGAPresent" path="isGAPresent"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ga.address" /></th>
											<td class="border-line"><form:input path="gaAddress" type="text" class="inp-form"/></td>
											<td><form:errors path="gaAddress" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step12.ga.area" /></th>
											<td class="border-line"><form:input path="gaArea" type="text" class="inp-form"/></td>
											<td><form:errors path="gaArea" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step12.ep.property.type" /></th>
											<td><form:select path="gaPropertyType.id"  type="text"
													items="${gaPropertyTypesList}" itemValue="id" itemLabel="description"
													class="inp-form-select gaPropertyType"/></td>
											<td/>													
										</tr>
										<tr>
											<th />
											<td/>
											<td/>																						
										</tr>
										<tr>
											<th/>
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