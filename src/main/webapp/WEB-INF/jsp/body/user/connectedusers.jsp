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
	$('#administration_mi_users').addClass('sub_show');
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
						<a href="${contextPath}/administration/manageusers">
							<s:message code="link.manage.users.on.connected.users" />
						</a>
					</h2>
						<form id="mainform" action="">
							<table border="0" width="100%" cellpadding="0" cellspacing="0"
								id="connectedusers">
								<thead>
									<tr>
										<th ><s:message code="label.connected.users.table.id.column"/></th>
										<th ><s:message code="label.connected.users.table.username.column"/></th>
										<th ><s:message code="label.connected.users.table.firstname.column"/></th>
										<th ><s:message code="label.connected.users.table.lastname.column"/></th>
										<th ><s:message code="label.connected.users.table.email.column"/></th>
										<th ><s:message code="label.connected.users.table.office.column"/></th>
										<th ><s:message code="label.connected.users.table.options.column"/></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="user" items="${usersList}">
										<tr>
											<td>${user.id}</td>
											<td>${user.username}</td>
											<td>${user.firstName}</td>
											<td>${user.lastName}</td>
											<td>${user.email}</td>
											<c:choose>
												<c:when test="${user.office.isEnabled == true}">
													<td>${user.office.name}</td>
												</c:when>
												<c:otherwise>
													<td><s:message code="label.connected.users.table.options.no.office"/></td>
												</c:otherwise>
											</c:choose>
											<td class="options-width">
												<jsp:element name="a">
													<jsp:attribute name="href">${contextPath}/administration/disconnect/user/${user.id}</jsp:attribute>
													<jsp:attribute name="title"><s:message code="popup.connected.users.table.options.disconnect"/></jsp:attribute>
													<jsp:attribute name="class">icon-disconnect info-tooltip</jsp:attribute>
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