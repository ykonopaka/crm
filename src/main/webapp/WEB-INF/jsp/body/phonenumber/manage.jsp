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
				
	<div id="dt_example">
	<script>$('#administration_mi').removeClass('select').addClass('current');
	$('#administration_mi_container').addClass('show');
	$('#administration_mi_phonenumbers').addClass('sub_show');
	</script>
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		id="content-table">
		<tr>
			<th class="topleft"></th>
			<td id="tbl-border-top"></td>
			<th class="topright"></th>
		</tr>
		<tr>
			<td id="tbl-border-left"></td>
			<td>
				<div id="content-table-inner">
					<div id="table-content">
					<h2>
						<a href="${contextPath}/administration/addphonenumber">
							<s:message code="link.add.new.phone.number" />
						</a>
					</h2>
						<form id="mainform" action="">
							<table class="datatable" border="0" width="100%" cellpadding="0" cellspacing="0"
								id="managephonenumbers">
								<thead>
									<tr>
										<th ><s:message code="label.phone.numbers.table.id.column"/></th>
										<th ><s:message code="label.phone.numbers.table.phone.column"/></th>
										<th ><s:message code="label.phone.numbers.table.description.column"/></th>
										<th ><s:message code="label.phone.numbers.table.office.column"/></th>
										<th ><s:message code="label.phone.numbers.table.ismobile.column"/></th>
										<th ><s:message code="label.phone.numbers.table.options.column"/></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="phoneNumber" items="${phoneNumbersList}">
										<tr>
											<td>${phoneNumber.id}</td>
											<td>${phoneNumber.phoneNumber}</td>
											<td>${phoneNumber.description}</td>
											<c:choose>
												<c:when test="${phoneNumber.office.isEnabled == true}">
													<td >${phoneNumber.office.name}</td>
												</c:when>
												<c:otherwise>
													<td ><s:message code="label.phone.numbers.table.options.no.office"/></td>
												</c:otherwise>
											</c:choose>
											<td>
												<c:choose>
													<c:when test="${phoneNumber.isMobile}"> 
														<s:message code="label.mobile.phone.number.yes"/>
													</c:when>
													<c:otherwise>
														<s:message code="label.mobile.phone.number.no"/>
													</c:otherwise>
												</c:choose>
											</td>											
											<td class="options-width">
												<jsp:element name="a">
													<jsp:attribute name="href">${contextPath}/administration/edit/phonenumber/${phoneNumber.id}</jsp:attribute>
													<jsp:attribute name="title"><s:message code="popup.users.table.options.edit"/></jsp:attribute>
													<jsp:attribute name="class">icon-edit info-tooltip</jsp:attribute>
													<jsp:body></jsp:body>
												</jsp:element>
												<jsp:element name="a">
													<jsp:attribute name="href">${contextPath}/administration/delete/phonenumber/${phoneNumber.id}</jsp:attribute>
													<jsp:attribute name="title"><s:message code="popup.users.table.options.delete"/></jsp:attribute>
													<jsp:attribute name="class">icon-delete info-tooltip</jsp:attribute>
													<jsp:body></jsp:body>
												</jsp:element>
											</td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
						</form>
					</div>
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
	</div>
</jsp:root>