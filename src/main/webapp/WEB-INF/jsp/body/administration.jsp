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
	<script>$('#administration_mi').removeClass('select').addClass('current');
	$('#administration_mi_container').addClass('show');
	$('#administration_mi_home').addClass('sub_show');
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
						<div id="administation_table_wrapper">
						<table>
							<thead>
								<tr>
									<th><h2><s:message code="label.header.user.administration"/></h2></th>
									<th><h2><s:message code="label.header.office.administration"/></h2></th>
									<th><h2><s:message code="label.header.phone.numbers.administration"/></h2></th>
									<th><h2><s:message code="label.header.information.source.administration"/></h2></th>
								</tr>
							</thead>
							<tbody>
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/administration/adduser"><img src="${contextPath}/static/images/shared/users_add.png"></img></a></td>
												<td><a href="${contextPath}/administration/manageusers"><img src="${contextPath}/static/images/shared/users_manage.png"></img></a></td>
											</tr>
											<tr>
												<th><s:message code="link.header.administration.user.add"/></th>
												<th><s:message code="link.header.administration.user.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td>
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/administration/addoffice"><img src="${contextPath}/static/images/shared/offices_add.png"></img></a></td>
												<td><a href="${contextPath}/administration/manageoffices"><img src="${contextPath}/static/images/shared/offices_manage.png"></img></a></td>
											</tr>
											<tr>
												<th class=""><s:message code="link.header.administration.office.add"/></th>
												<th class=""><s:message code="link.header.administration.office.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td>
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/administration/addphonenumber"><img src="${contextPath}/static/images/shared/phones_add.png"></img></a></td>
												<td><a href="${contextPath}/administration/managephonenumbers"><img src="${contextPath}/static/images/shared/phones_manage.png"></img></a></td>
											</tr>
											<tr>
												<th><s:message code="link.header.administration.phone.numbers.add"/></th>
												<th><s:message code="link.header.administration.phone.numbers.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td>	
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/administration/addinfosource"><img src="${contextPath}/static/images/shared/info_sources_add.png"></img></a></td>
												<td><a href="${contextPath}/administration/manageinfosources"><img src="${contextPath}/static/images/shared/info_sources_manage.png"></img></a></td>
											</tr>
											<tr>
												<th><s:message code="link.header.administration.information.source.add"/></th>
												<th><s:message code="link.header.administration.information.source.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td>																								
							</tbody>
						</table>
						</div>
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