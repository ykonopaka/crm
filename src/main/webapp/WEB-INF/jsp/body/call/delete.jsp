<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:security="http://www.springframework.org/security/tags"
	xmlns:s="http://www.springframework.org/tags"
	xmlns:tiles="http://tiles.apache.org/tags-tiles" 
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	version="2.0">
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
									<form:form method="POST" commandName="call">
										<tr>
											<th><h2><s:message code="label.header.view.call.h2.general.call.info" /></h2></th>
											<td/>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.view.call.id"/></th>
											<td>${call.id}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.worker.name"/></th>
											<td>${call.user.lastName} ${call.user.firstName}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.date"/></th>
											<td><fmt:formatDate value="${call.date}" pattern="dd.MM.yyyy"/></td>
										</tr>
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										
								
										<tr><th><h2><s:message code="label.header.view.call.client.info" /></h2></th>
										<td></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.view.call.client.name"/></th>
											<td>${call.client.lastName} ${call.client.firstName} ${call.client.middleName}</td>
										</tr>
										<c:if test="${not empty call.client.age}">
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.client.age"/></th>
											<td>${call.client.age}</td>
										</tr>
										</c:if>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.client.employment.type"/></th>
											<td>${call.client.employmentType.description}</td>
										</tr>
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										

										<tr><th><h2><s:message code="label.header.view.call.office.phone.number" /></h2></th>
										<td></td>
										</tr>										
										<tr>
											<th valign="top"><s:message code="label.view.call.office.phone.number"/></th>
											<td>${call.officePhoneNumber.phoneNumber}</td>
										</tr>
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										
								
										
										<tr><th><h2><s:message code="label.header.view.call.credit.details" /></h2></th>
										<td></td>
										</tr>	
										<tr>
											<th valign="top"><s:message code="label.view.call.credit.amount"/></th>
											<td>${call.credit.amountOfMoney}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.credit.type"/></th>
											<td>${call.credit.creditType.description}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.credit.currency"/></th>
											<td>${call.credit.currencyType.description}</td>
										</tr>
										
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										
									
										<tr><th><h2><s:message code="label.header.view.call.info.source" /></h2></th>
										<td></td>
										</tr>																																																		
										<tr>
											<th valign="top"><s:message code="label.view.call.info.source"/></th>
											<td>${call.infoSource.fullName}</td>
										</tr>

										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										
										
										<tr><th><h2><s:message code="label.header.view.call.additional.information" /></h2></th>
										<td></td>										
										</tr>																																																		
										<tr>
											<th valign="top"><s:message code="label.view.call.additional.info.interests"/></th>
											<td>${call.additionalCallInfo.interestType.description}</td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.view.call.additional.info.were.credits.earlier"/></th>
											<td>
												<c:choose>
													<c:when test="${call.additionalCallInfo.wereCreditsEarlier}"> 
														<s:message code="label.yes.ru"/>
													</c:when>
													<c:otherwise>
														<s:message code="label.no.ru"/>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.additional.info.banks"/></th>
											<td>${call.additionalCallInfo.banksClientContactedWith}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.additional.info.description"/></th>
											<td>${call.additionalCallInfo.description}</td>
										</tr>
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>										

										<tr><th><h2><s:message code="label.header.view.call.client.phone.number" /></h2></th>
										<td></td>										
										</tr>																																																		
										<tr>
											<th valign="top"><s:message code="label.view.call.client.phone.number"/></th>
											<td>${call.clientPhoneNumber.phoneNumber}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.client.phone.number.hidden"/></th>
											<td>
												<c:choose>
													<c:when test="${call.clientPhoneNumber.isHidden}"> 
														<s:message code="label.yes.ru"/>
													</c:when>
													<c:otherwise>
														<s:message code="label.no.ru"/>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.call.client.phone.number.has.client.come"/></th>
											<td>
												<c:choose>
													<c:when test="${call.clientPhoneNumber.hasClientCome}"> 
														<s:message code="label.yes.ru"/>
													</c:when>
													<c:otherwise>
														<s:message code="label.no.ru"/>
													</c:otherwise>
												</c:choose>
											</td>											
										</tr>
										<tr><th /><td/></tr>
										<tr><th /><td/></tr>	
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-submit-${locale}" />
												<a type="button" class="form-reset-${locale}" href="${contextPath}/workflow/managecalls/init"/>
											</td>
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