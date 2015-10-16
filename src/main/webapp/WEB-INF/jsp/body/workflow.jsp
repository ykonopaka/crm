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
		$('#workflow_mi_home').addClass('sub_show');
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
						<div id="workflow_table_wrapper">
						<table>
							<thead>
								<tr>
									<th><h2><s:message code="label.header.calls.workflow"/></h2></th>
<!-- 									<th><h2><s:message code="label.header.clients.workflow"/></h2></th> -->
									<th><h2><s:message code="label.header.deals.workflow"/></h2></th>
								</tr>
							</thead>
							<tbody>
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/workflow/addcall"><img src="${contextPath}/static/images/shared/calls_add.png"></img></a></td>
												<td><a href="${contextPath}/workflow/managecalls/init"><img src="${contextPath}/static/images/shared/calls_manage.png"></img></a></td>
											</tr>
											<tr>
												<th><s:message code="link.header.workflow.call.add"/></th>
												<th><s:message code="link.header.workflow.call.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td>
<!-- 								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/workflow/addclient"><img src="${contextPath}/static/images/shared/clients_add.png"></img></a></td>
												<td><a href="${contextPath}/workflow/manageclients/init"><img src="${contextPath}/static/images/shared/clients_manage.png"></img></a></td>
											</tr>
											<tr>
												<th class=""><s:message code="link.header.workflow.client.add"/></th>
												<th class=""><s:message code="link.header.workflow.client.manage"/></th>
											</tr>
										</tbody>
									</table>
								</td> -->
								<td>
									<table class="adm_options">
										<tbody>
											<tr>
												<td><a href="${contextPath}/workflow/adddeal"><img src="${contextPath}/static/images/shared/deals_add.png"></img></a></td>
												<td><a href="${contextPath}/workflow/managedeals/init"><img src="${contextPath}/static/images/shared/deals_manage.png"></img></a></td>
											</tr>
											<tr>
												<th><s:message code="link.header.workflow.deal.add"/></th>
												<th><s:message code="link.header.workflow.deal.manage"/></th>
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