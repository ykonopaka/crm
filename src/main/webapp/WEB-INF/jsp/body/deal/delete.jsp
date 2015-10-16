<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:security="http://www.springframework.org/security/tags"
	xmlns:s="http://www.springframework.org/tags"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.0">
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
									<form:form method="POST" commandName="deal">
										<tr><th><h2><s:message code="label.header.view.deal.h2.deal" /></h2></th>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.view.deal.id"/></th>
											<td>${deal.id}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.deal.creation.date"/></th>
											<td><fmt:formatDate value="${deal.creationDate}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.deal.modification.date"/></th>
											<td><fmt:formatDate value="${deal.modificationDate}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
										</tr>
										<tr><th /></tr>
										<tr><th /></tr>
										<c:if test="${deal.step >= 1}">
										<tr><th><h2><s:message code="label.header.view.deal.h2.credit" /></h2></th><td></td></tr>
										<tr>
											<th valign="top"><s:message code="label.view.deal.credit.amount.money"/></th>
											<td>${deal.credit.amountOfMoney}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.deal.credit.term"/></th>
											<td>${deal.credit.term}</td>
										</tr>
										<tr class="border-line-top">
											<th valign="top"><s:message code="label.view.deal.credit.objective.type"/></th>
											<td>${deal.credit.creditObjectiveType.description}</td>
										</tr>
										<tr><th /></tr>
										<tr><th /></tr>											
										</c:if>
										<c:if test="${deal.step >= 2}">									
										<tr><th><h2><s:message code="label.header.view.deal.h2.personal.data" /></h2></th></tr>
											<tr><td><h3><s:message code="label.header.view.deal.h3.client" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.name"/></th>
												<td>${deal.customer.lastName} ${deal.customer.firstName} ${deal.customer.middleName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.gender"/></th>
												<td>${deal.customer.genderType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.birth.date"/></th>
												<td><fmt:formatDate value="${deal.customer.birthDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.birth.place"/></th>
												<td>${deal.customer.birthPlace}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.education"/></th>
												<td>${deal.customer.educationType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.speciality"/></th>
												<td>${deal.customer.speciality}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.military.service"/></th>
												<td>${deal.customer.militaryServiceType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.conviction"/></th>
												<td>${deal.customer.convictionType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.mother.lastname"/></th>
												<td>${deal.customer.motherLastName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.was.lastname.changed"/></th>
												<td>
													<c:choose>
														<c:when test="${deal.customer.wasLastNameChanged}"> 
															<s:message code="label.yes"/>
														</c:when>
														<c:otherwise>
															<s:message code="label.no"/>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
											<c:if test="${deal.customer.wasLastNameChanged}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.lastname.change.date"/></th>
												<td><fmt:formatDate value="${deal.customer.lastNameChangeDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.previous.lastname"/></th>
												<td>${deal.customer.previousLastName}</td>
											</tr>
											</c:if>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.all.children"/></th>
												<td>${deal.customer.numberOfAllChildren}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.young.children"/></th>
												<td>${deal.customer.numberOfYoungChildren}</td>
											</tr>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 3}">
										<tr><td><h3><s:message code="label.header.view.deal.h3.passport" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.passport.serial.number"/></th>
												<td>${deal.customer.passport.serial}${deal.customer.passport.number}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.passport.who.gave.passport"/></th>
												<td>${deal.customer.passport.whoGavePassport}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.passport.registration.date"/></th>
												<td><fmt:formatDate value="${deal.customer.passport.passportRegistrationDate}" pattern="dd.MM.yyyy"/></td>												
											</tr>	
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.passport.has.other.document"/></th>
												<td>
													<c:choose>
														<c:when test="${deal.customer.passport.hasOtherDocument}"> 
															<s:message code="label.yes"/>
														</c:when>
														<c:otherwise>
															<s:message code="label.no"/>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>		
											<c:if test="${deal.customer.passport.hasOtherDocument}">																			
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.passport.name.other.document"/></th>
												<td>${deal.customer.passport.nameOfOtherDocument}</td>
											</tr>
											</c:if>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.id.tax.number"/></th>
												<td>${deal.customer.passport.idTaxNumber}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.id.tax.registration.date"/></th>
												<td><fmt:formatDate value="${deal.customer.passport.idTaxRegistrationDate}" pattern="dd.MM.yyyy"/></td>												
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.id.tax.who.gave"/></th>
												<td>${deal.customer.passport.whoGaveIdtax}</td>
											</tr>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 4}">
											<tr><td><h3><s:message code="label.header.view.deal.h3.marriage" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.marriage.status"/></th>
												<td>${deal.customer.marriage.maritalStatusType.description}</td>
											</tr>											
											<c:if test="${deal.customer.marriage.maritalStatusType.id == '1' || deal.customer.marriage.maritalStatusType.id == '2'}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.name"/></th>
												<td>${deal.customer.marriage.lastName} ${deal.customer.marriage.firstName} ${deal.customer.marriage.middleName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.registration.date"/></th>
												<td><fmt:formatDate value="${deal.customer.marriage.marriageRegistrationDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.birth.date"/></th>
												<td><fmt:formatDate value="${deal.customer.marriage.birthDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.phone.number.mobile"/></th>
												<td>${deal.customer.marriage.phoneNumberMobile}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.phone.number.home.work"/></th>
												<td>${deal.customer.marriage.phoneNumberHomeWork}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.workplace"/></th>
												<td>${deal.customer.marriage.workplace}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.position"/></th>
												<td>${deal.customer.marriage.position}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.business.line"/></th>
												<td>${deal.customer.marriage.businessLineType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.organization.type"/></th>
												<td>${deal.customer.marriage.organizationType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.job"/></th>
												<td>${deal.customer.marriage.jobType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.marriage.id.tax.number"/></th>
												<td>${deal.customer.marriage.idTaxNumber}</td>
											</tr>
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 5}">
										<tr><th><h2><s:message code="label.header.view.deal.h2.contact.points" /></h2></th></tr>
											<tr><td><h3><s:message code="label.header.view.deal.h3.address" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.registration.address"/></th>
												<td>${deal.customer.address.rTown}, ${deal.customer.address.rRegionType.description}</td>
											</tr>
											<c:if test="${not empty deal.customer.address.rDistrict}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.registration.address.district" /><jsp:text>   </jsp:text>${deal.customer.address.rDistrict}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.rStreet}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.registration.address.street" /><jsp:text>   </jsp:text>${deal.customer.address.rStreet}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.rHouse}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.registration.address.house" /><jsp:text>   </jsp:text>${deal.customer.address.rHouse}</td>
												</tr>
											</c:if>											
											<c:if test="${not empty deal.customer.address.rBuilding}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.registration.address.building" /><jsp:text>   </jsp:text>${deal.customer.address.rBuilding}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.rApartment}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.registration.address.apartment" /><jsp:text>   </jsp:text>${deal.customer.address.rApartment}</td>
												</tr>
											</c:if>	
											<tr>
												<th/>
												<td/>
												<td/>
											</tr>																						
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.registration.address.postcode"/></th>
												<td>${deal.customer.address.rPostcode}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.registration.address.registration.date"/></th>
												<td><fmt:formatDate value="${deal.customer.address.rRegistrationDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.registration.address.term.of.living"/></th>
												<td>${deal.customer.address.rTermOfLiving}</td>
											</tr>
											<tr class="border-line-top" >
												<th valign="top"><s:message code="label.view.customer.registration.actual.the.same"/></th>
												<td>
													<c:choose>
														<c:when test="${deal.customer.address.registrationIsActual}"> 
															<s:message code="label.yes"/>
														</c:when>
														<c:otherwise>
															<s:message code="label.no"/>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
											<c:if test="${not deal.customer.address.registrationIsActual}">											
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.actual.address"/></th>
												<td>${deal.customer.address.aTown}, ${deal.customer.address.aRegionType.description}</td>
											</tr>
											<c:if test="${not empty deal.customer.address.aDistrict}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.actual.address.district" /><jsp:text>   </jsp:text>${deal.customer.address.rDistrict}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.aStreet}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.actual.address.street" /><jsp:text>   </jsp:text>${deal.customer.address.rStreet}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.aHouse}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.actual.address.house" /><jsp:text>   </jsp:text>${deal.customer.address.rHouse}</td>
												</tr>
											</c:if>											
											<c:if test="${not empty deal.customer.address.aBuilding}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.actual.address.building" /><jsp:text>   </jsp:text>${deal.customer.address.rBuilding}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.address.aApartment}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.actual.address.apartment" /><jsp:text>   </jsp:text>${deal.customer.address.rApartment}</td>
												</tr>
											</c:if>
											<tr>
												<th/>
												<td/>
												<td/>
											</tr>											
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.actual.address.postcode"/></th>
												<td>${deal.customer.address.aPostcode}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.actual.address.term.of.living"/></th>
												<td>${deal.customer.address.aTermOfLiving}</td>
											</tr>	
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 6}">										
											<tr><td><h3><s:message code="label.header.view.deal.h3.phones" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.phones.mobile1"/></th>
												<td>${deal.customer.customerPhoneSet.phoneNumberMobile1}</td>
											</tr>
											<c:if test="${not empty deal.customer.customerPhoneSet.phoneNumberMobile2}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.phones.mobile2"/></th>
												<td>${deal.customer.customerPhoneSet.phoneNumberMobile2}</td>
											</tr>
											</c:if>
											<c:if test="${not empty deal.customer.customerPhoneSet.phoneNumberRegistration}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.phones.registration"/></th>
												<td>${deal.customer.customerPhoneSet.phoneNumberRegistration}</td>
											</tr>
											</c:if>
											<c:if test="${not empty deal.customer.customerPhoneSet.phoneNumberActual}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.phones.actual"/></th>
												<td>${deal.customer.customerPhoneSet.phoneNumberActual}</td>
											</tr>	
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>		
										<c:if test="${deal.step >= 7}">																																										
											<tr><td><h3><s:message code="label.header.view.deal.h3.contact.people" /></h3></td><td></td></tr>
											<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.first.contact.person" /></font></b></i></th></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.first.contact.person.name"/></th>
												<td>${deal.customer.contactPersons.fpLastName} ${deal.customer.contactPersons.fpFirstName} ${deal.customer.contactPersons.fpMiddleName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.first.contact.person.type"/></th>
												<td>${deal.customer.contactPersons.fpContactPersonType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.first.contact.person.mobile.number"/></th>
												<td>${deal.customer.contactPersons.fpMobileNumber}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.first.contact.person.home.or.work.number"/></th>
												<td>${deal.customer.contactPersons.fpHomeWorkNumber}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.first.contact.person.birth.date"/></th>
												<td><fmt:formatDate value="${deal.customer.contactPersons.fpBirthDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.first.contact.person.address"/></th>
												<td>${deal.customer.contactPersons.fpAddress}</td>
											</tr>
											<c:if test="${deal.customer.contactPersons.spExist}">
											<tr><th><b><i><font color="#92B22C"><s:message code="label.header.view.deal.h4.second.contact.person" /></font></i></b></th></tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.name"/></th>
												<td>${deal.customer.contactPersons.spLastName} ${deal.customer.contactPersons.spFirstName} ${deal.customer.contactPersons.spMiddleName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.type"/></th>
												<td>${deal.customer.contactPersons.spContactPersonType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.mobile.number"/></th>
												<td>${deal.customer.contactPersons.spMobileNumber}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.home.or.work.number"/></th>
												<td>${deal.customer.contactPersons.spHomeWorkNumber}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.birth.date"/></th>
												<td><fmt:formatDate value="${deal.customer.contactPersons.spBirthDate}" pattern="dd.MM.yyyy"/></td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.second.contact.person.address"/></th>
												<td>${deal.customer.contactPersons.spAddress}</td>
											</tr>
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 8}">
										<tr><th><h2><s:message code="label.header.view.deal.h2.job" /></h2></th></tr>
											<tr><td><h3><s:message code="label.header.view.deal.h3.working.place" /></h3></td><td></td></tr>
											<tr>
												<th valign="top"><s:message code="label.view.customer.working.place.organization.name"/></th>
												<td>${deal.customer.workingPlace.organizationName}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.starting.date"/></th>
												<td><fmt:formatDate value="${deal.customer.workingPlace.startingDate}" pattern="dd.MM.yyyy"/></td>
											</tr>											
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.business.line"/></th>
												<td>${deal.customer.workingPlace.businessLineType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.job.type"/></th>
												<td>${deal.customer.workingPlace.jobType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.EDRPOU.code"/></th>
												<td>${deal.customer.workingPlace.EDRPOUcode}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.position"/></th>
												<td>${deal.customer.workingPlace.positionName}</td>
											</tr>	
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.position.type"/></th>
												<td>${deal.customer.workingPlace.positionType.description}</td>
											</tr>
											<c:if test="${deal.customer.workingPlace.positionType.id == '2' || deal.customer.workingPlace.positionType.id == '3'}">
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.number.of.workers"/></th>
												<td>${deal.customer.workingPlace.numberOfWorkers}</td>
											</tr>
											</c:if>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.company.size"/></th>
												<td>${deal.customer.workingPlace.companySizeType.description}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.organization"/></th>
												<td>${deal.customer.workingPlace.organizationType.description}</td>
											</tr>	
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.company.existing.term"/></th>
												<td>${deal.customer.workingPlace.companyExistingTerm}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.length.of.service.total"/></th>
												<td>${deal.customer.workingPlace.lengthOfServiceTotal}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.length.of.service.last"/></th>
												<td>${deal.customer.workingPlace.lengthOfServiceLastPlace}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.address"/></th>
												<td>${deal.customer.workingPlace.town}, ${deal.customer.workingPlace.regionType.description}</td>
											</tr>
											<c:if test="${not empty deal.customer.workingPlace.district}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.working.place.address.district" /><jsp:text>   </jsp:text>${deal.customer.address.rDistrict}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.workingPlace.street}">
												<tr>
													<th/>
													<td><s:message code="label.view.customer.working.place.address.street" /><jsp:text>   </jsp:text>${deal.customer.address.rStreet}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.workingPlace.house}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.working.place.address.house" /><jsp:text>   </jsp:text>${deal.customer.address.rHouse}</td>
												</tr>
											</c:if>											
											<c:if test="${not empty deal.customer.workingPlace.building}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.working.place.address.building" /><jsp:text>   </jsp:text>${deal.customer.address.rBuilding}</td>
												</tr>
											</c:if>
											<c:if test="${not empty deal.customer.workingPlace.office}">
												<tr>
													<th/>
														<td><s:message code="label.view.customer.working.place.address.office" /><jsp:text>   </jsp:text>${deal.customer.address.rApartment}</td>
												</tr>
											</c:if>																							
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.postcode"/></th>
												<td>${deal.customer.workingPlace.postcode}</td>
											</tr>
											<tr class="border-line-top">
												<th valign="top"><s:message code="label.view.customer.working.place.phone.number"/></th>
												<td>${deal.customer.workingPlace.phoneNumber}</td>
											</tr>
										</c:if>
										<tr><th /></tr>
										<tr><th /></tr>										
										<c:if test="${deal.step >= 9}">																																																																																																																										
										<tr><td><h3><s:message code="label.header.view.deal.h3.additional.working.place" /></h3></td><td></td></tr>
											<c:choose>
												<c:when test="${deal.customer.additionalWorkingPlace.isExisted}"> 
													<tr>
														<th valign="top"><s:message code="label.view.customer.additional.working.place.working.term.from"/></th>
														<td>${deal.customer.additionalWorkingPlace.workingTermFrom}</td>
													</tr>	
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.organization"/></th>
														<td>${deal.customer.additionalWorkingPlace.organizationName}</td>
													</tr>	
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.position"/></th>
														<td>${deal.customer.additionalWorkingPlace.positionName}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.business.line"/></th>
														<td>${deal.customer.additionalWorkingPlace.businessLineType.description}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.organization"/></th>
														<td>${deal.customer.additionalWorkingPlace.organizationType.description}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.company.size"/></th>
														<td>${deal.customer.additionalWorkingPlace.companySizeType.description}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.address"/></th>
														<td>${deal.customer.additionalWorkingPlace.address}</td>
													</tr>	
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.phone.number"/></th>
														<td>${deal.customer.additionalWorkingPlace.phoneNumber}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.additional.working.place.company.existing.term"/></th>
														<td>${deal.customer.additionalWorkingPlace.companyExistingTerm}</td>
													</tr>																																																																																																															
												</c:when>
												<c:otherwise>
													<tr>
														<th valign="top"><s:message code="label.view.customer.additional.working.place.existed"/></th>
														<td><s:message code="label.no"/></td>
													</tr>
												</c:otherwise>
											</c:choose>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 10}">
										<tr><td><h3><s:message code="label.header.view.deal.h3.previous.working.place" /></h3></td><td></td></tr>
											<c:choose>
												<c:when test="${deal.customer.previousWorkingPlace.isExisted}"> 
													<tr>
														<th valign="top"><s:message code="label.view.customer.previous.working.place.working.term.from"/></th>
														<td>${deal.customer.previousWorkingPlace.workingTermFrom}</td>
													</tr>	
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.previous.working.place.organization.name"/></th>
														<td>${deal.customer.previousWorkingPlace.organizationName}</td>
													</tr>	
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.previous.working.place.position"/></th>
														<td>${deal.customer.previousWorkingPlace.positionName}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.previous.working.place.business.line"/></th>
														<td>${deal.customer.previousWorkingPlace.businessLineType.description}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.previous.working.place.organization"/></th>
														<td>${deal.customer.previousWorkingPlace.organizationType.description}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.previous.working.place.address"/></th>
														<td>${deal.customer.previousWorkingPlace.address}</td>
													</tr>	
												</c:when>
												<c:otherwise>
													<tr>
														<th valign="top"><s:message code="label.view.customer.previous.working.place.existed"/></th>
														<td><s:message code="label.no"/></td>
													</tr>
												</c:otherwise>
											</c:choose>
										<tr><th /></tr>
										<tr><th /></tr>												
										</c:if>
										<c:if test="${deal.step >= 11}">																						
										<tr><th><h2><s:message code="label.header.view.deal.h2.finances.credits" /></h2></th></tr>
											<tr><td><h3><s:message code="label.header.view.deal.h3.income.outcome" /></h3></td><td></td></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.income.outcome.main.income.size"/></th>
													<td>${deal.customer.incomeOutcome.mainIncomeSize}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.main.income.type"/></th>
													<td>${deal.customer.incomeOutcome.mainIncomeType.description}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.documents.present"/></th>
													<td>${deal.customer.incomeOutcome.areDocumentsPresent}</td>
												</tr>
												<c:if test="${deal.customer.incomeOutcome.isAdditionalIncomePresent}"> 	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.additional.income.size"/></th>
													<td>${deal.customer.incomeOutcome.additionalIncomeSize}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.addition.income.type"/></th>
													<td>${deal.customer.incomeOutcome.additionalIncomeType.description}</td>
												</tr>	
												</c:if>
												<c:if test="${deal.customer.incomeOutcome.isMarried}"> 
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.spouse.income.size"/></th>
													<td>${deal.customer.incomeOutcome.spouseIncomeSize}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.spouse.income.type"/></th>
													<td>${deal.customer.incomeOutcome.spouseIncomeType.description}</td>
												</tr>	
												</c:if>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.total.outcome"/></th>
													<td>${deal.customer.incomeOutcome.totalOutcome}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.income.outcome.family.people.number"/></th>
													<td>${deal.customer.incomeOutcome.familyPeopleNumber}</td>
												</tr>
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												
										<c:if test="${deal.step >= 12}">																																																																																												
										<tr><td><h3><s:message code="label.header.view.deal.h3.property" /></h3></td><td></td></tr>
												<c:if test="${deal.customer.property.isCarPresent}">
													<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.property.car" /></font></b></i></th></tr> 
													<tr>
														<th valign="top"><s:message code="label.view.customer.property.car"/></th>
														<td>${deal.customer.property.carBrand}, ${deal.customer.property.carReleaseYear} <s:message code="label.release.year"/></td>
													</tr>														
												</c:if>	
												<c:if test="${deal.customer.property.isEPPresent}">
													<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.property.ep" /></font></b></i></th></tr> 
													<tr>
														<th valign="top"><s:message code="label.view.customer.property.ep.address"/></th>
														<td>${deal.customer.property.epAddress}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ep.area"/></th>
														<td>${deal.customer.property.epArea}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ep.room.number"/></th>
														<td>${deal.customer.property.epRoomNumber}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ep.price"/></th>
														<td>${deal.customer.property.epPrice}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ep.property.type"/></th>
														<td>${deal.customer.property.epPropertyType.description}</td>
													</tr>		
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ep.property.history.type"/></th>
														<td>${deal.customer.property.epPropertyHistoryType.description}</td>
													</tr>																																																															
												</c:if>	
												<c:if test="${deal.customer.property.isGAPresent}">
													<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.property.ga" /></font></b></i></th></tr> 
													<tr>
														<th valign="top"><s:message code="label.view.customer.property.ga.address"/></th>
														<td>${deal.customer.property.gaAddress}</td>
													</tr>
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ga.area"/></th>
														<td>${deal.customer.property.gaArea}</td>
													</tr>		
													<tr class="border-line-top">
														<th valign="top"><s:message code="label.view.customer.property.ga.property.type"/></th>
														<td>${deal.customer.property.gaPropertyType.description}</td>
													</tr>													
												</c:if>
											<tr><th /></tr>
											<tr><th /></tr>													
											</c:if>	
											<c:if test="${deal.step >= 13}">																																															
											<tr><td><h3><s:message code="label.header.view.deal.h3.credit.cards" /></h3></td><td></td></tr>
											<c:if test="${deal.customer.creditCard.fcIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.fc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.bank.name"/></th>
													<td>${deal.customer.creditCard.fcBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.time.left"/></th>
													<td>${deal.customer.creditCard.fcTimeLeft}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.money.left"/></th>
													<td>${deal.customer.creditCard.fcMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.credit.type"/></th>
													<td>${deal.customer.creditCard.fcCreditFormType.description}</td>
												</tr>												
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.amount"/></th>
													<td>${deal.customer.creditCard.fcAmount}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.fcStartingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.fc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.fcEndingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>																																																																							
											</c:if> 
											<c:if test="${deal.customer.creditCard.scIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.sc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.bank.name"/></th>
													<td>${deal.customer.creditCard.scBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.time.left"/></th>
													<td>${deal.customer.creditCard.scTimeLeft}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.money.left"/></th>
													<td>${deal.customer.creditCard.scMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.credit.type"/></th>
													<td>${deal.customer.creditCard.scCreditFormType.description}</td>
												</tr>												
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.amount"/></th>
													<td>${deal.customer.creditCard.scAmount}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.scStartingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.sc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.scEndingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>	
																						
											</c:if> 
											<c:if test="${deal.customer.creditCard.tcIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.tc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.bank.name"/></th>
													<td>${deal.customer.creditCard.tcBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.time.left"/></th>
													<td>${deal.customer.creditCard.tcTimeLeft}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.money.left"/></th>
													<td>${deal.customer.creditCard.tcMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.credit.type"/></th>
													<td>${deal.customer.creditCard.tcCreditFormType.description}</td>
												</tr>												
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.amount"/></th>
													<td>${deal.customer.creditCard.tcAmount}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.tcStartingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.tcEndingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>	
																							
											</c:if> 
											<c:if test="${deal.customer.creditCard.fccIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.fcc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.bank.name"/></th>
													<td>${deal.customer.creditCard.fccBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.month.payment"/></th>
													<td>${deal.customer.creditCard.fccMonthPayment}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.credit.limit"/></th>
													<td>${deal.customer.creditCard.fccCreditLimit}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.money.left"/></th>
													<td>${deal.customer.creditCard.fccMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.fccStartingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.fccEndingDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.last.transaction.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.fccLastTransactionDate}" pattern="dd.MM.yyyy"/></td>														
												</tr>																																																																					
											</c:if> 
											<c:if test="${deal.customer.creditCard.sccIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.scc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.bank.name"/></th>
													<td>${deal.customer.creditCard.sccBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.month.payment"/></th>
													<td>${deal.customer.creditCard.sccMonthPayment}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.credit.limit"/></th>
													<td>${deal.customer.creditCard.sccCreditLimit}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.money.left"/></th>
													<td>${deal.customer.creditCard.sccMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.sccStartingDate}" pattern="dd.MM.yyyy"/></td>													
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.sccEndingDate}" pattern="dd.MM.yyyy"/></td>													
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.scc.last.transaction.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.sccLastTransactionDate}" pattern="dd.MM.yyyy"/></td>													
												</tr>													
											</c:if> 
											<c:if test="${deal.customer.creditCard.tccIsExisted}">
												<tr><th><i><b><font color="#92B22C"><s:message code="label.header.view.deal.h4.credit.cards.tcc" /></font></b></i></th></tr>
												<tr>
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.bank.name"/></th>
													<td>${deal.customer.creditCard.tccBankName}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.month.payment"/></th>
													<td>${deal.customer.creditCard.tccMonthPayment}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.credit.limit"/></th>
													<td>${deal.customer.creditCard.tccCreditLimit}</td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.money.left"/></th>
													<td>${deal.customer.creditCard.tccMoneyLeft}</td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.starting.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.tccStartingDate}" pattern="dd.MM.yyyy"/></td>
												</tr>
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.ending.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.tccEndingDate}" pattern="dd.MM.yyyy"/></td>
												</tr>	
												<tr class="border-line-top">
													<th valign="top"><s:message code="label.view.customer.credit.cards.tcc.last.transaction.date"/></th>
													<td><fmt:formatDate value="${deal.customer.creditCard.tccLastTransactionDate}" pattern="dd.MM.yyyy"/></td>
												</tr>													
											</c:if>
										<tr><th /></tr>
										<tr><th /></tr>												 
										</c:if>
										<c:if test="${deal.step >= 13}">												
										<tr><th><h2><s:message code="label.header.view.deal.h2.files" /></h2></th><td></td></tr>
										<c:forEach var="attachment" items="${attachmentsList}">
										<tr>
												<th/>
												<td>
													<a class="table_edit" href="${contextPath}/uploads/${deal.id}/${attachment.fileName}" target="_blank">${attachment.fileName}</a>
												</td>
										</tr>
										</c:forEach>
										</c:if>
										<tr>
											<th />
										</tr>
									
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-submit-${locale}" />
												<a type="button" class="form-reset-${locale}" href="${contextPath}/dashboard/mydeals"/>
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