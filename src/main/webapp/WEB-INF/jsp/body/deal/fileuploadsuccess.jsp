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
	<c:set var="locale" scope="page" value="${pageContext.response.locale}" />

	<c:choose>
		<c:when test="${coordinatorOnly}"> 
			<script>		
				$('#dashboard_mi').removeClass('select').addClass('current');
				$('#dashboard_mi_container').addClass('show');
				$('#dashboard_mi_home').addClass('sub_show');
			</script>
		</c:when>
		<c:otherwise>
			<script>		
				$('#workflow_mi').removeClass('select').addClass('current');
				$('#workflow_mi_container').addClass('show');
				$('#workflow_mi_deals').addClass('sub_show');
			</script>
		</c:otherwise>
	</c:choose>
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
					<h2>
						<s:message code="label.header.deal.upload.file.finished" />
					</h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<tr>
										<th/>
										<td/>
									</tr>
									<tr>
										<th valign="top"><s:message code="label.header.deal.upload.file.finished.success" /></th>
										<td>${file}</td>
									</tr>
									<tr>
										<th/>
										<td/>
										<a href="${contextPath}/workflow/deal/${dealId}/files/upload"><s:message code="label.header.deal.upload.file.link" /></a>
									</tr>
									<tr>
										<th/>
										<td/>
									</tr>																	
									<tr>
										<th/>
										<td>
											<a class="form-reset-${locale}" href="${contextPath}/workflow/edit/deal/${dealId}"></a>
										</td>
									</tr>
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