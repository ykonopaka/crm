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

	<div id="dt_example">				
	<script>
		$('#dashboard_mi').removeClass('select').addClass('current');
		$('#dashboard_mi_container').addClass('show');
		$('#dashboard_mi_home').addClass('sub_show');
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
						<form id="mainform" action="">
							<table class="datatable" border="0" width="100%" cellpadding="0" cellspacing="0"
								id="mydeals">
								<thead>
									<tr>
										<th><s:message code="label.deals.table.id"/></th>
										<th><s:message code="label.deals.table.name"/></th>
										<th><s:message code="label.deals.table.job.type"/></th>
										<th><s:message code="label.deals.table.credit.amount"/></th>
										<th><s:message code="label.deals.table.credit.term"/></th>
										<th><s:message code="label.deals.table.operator.name"/></th>
										<th><s:message code="label.deals.table.date"/></th>
										<th><s:message code="label.deals.table.workflow.type"/></th>
										<th><s:message code="label.deals.table.options.column"/></th>
										
									</tr>
								</thead>
								<tbody>
								<c:forEach var="deal" items="${myDealsList}">
										<tr>
											<td>${deal.id}</td>
											<td>${deal.customer.lastName} ${deal.customer.firstName} ${deal.customer.middleName}</td>
											<td>${deal.customer.workingPlace.jobType.description}</td>
											<td>${deal.credit.amountOfMoney}</td>
											<td>${deal.credit.term}</td>
											<td>${deal.user.lastName} ${deal.user.firstName}</td>
											<td><fmt:formatDate value="${deal.creationDate}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
											<td>${deal.dealWorkflowType.description}</td>
											<td class="options-width">
												<jsp:element name="a">
													<jsp:attribute name="href">${contextPath}/workflow/edit/deal/${deal.id}</jsp:attribute>
													<jsp:attribute name="title"><s:message code="popup.deals.table.options.edit"/></jsp:attribute>
													<jsp:attribute name="class">icon-edit info-tooltip</jsp:attribute>
													<jsp:body></jsp:body>
												</jsp:element>
												<jsp:element name="a">
													<jsp:attribute name="href">${contextPath}/workflow/delete/deal/${deal.id}</jsp:attribute>
													<jsp:attribute name="title"><s:message code="popup.deals.table.options.delete"/></jsp:attribute>
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