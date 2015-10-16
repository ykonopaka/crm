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
				
	<c:set var="searchLabel">
       	<s:message code="label.topsearch.default.text" />
    </c:set>		
	<div id="page-top-outer">
		<div id="page-top">
			<div id="logo">
				<a href="">
					<img src="${contextPath}/static/images/shared/logo.png" width="156" height="40" alt="" />
				</a>
			</div>
			<div id="top-search">
<!-- 				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<input type="text" value="${searchLabel}"
							onblur="if (this.value=='') { this.value='${searchLabel}'; }"
							onfocus="if (this.value=='Search') { this.value=''; }"
							class="top-search-inp" />
							</td>
						<td>
							<select class="styledselect">
								<option value=""><s:message code="label.topsearch.option.all" /></option>
								<option value=""><s:message code="label.topsearch.option.calls" /></option>
								<option value=""><s:message code="label.topsearch.option.clients" /></option>
								<option value=""><s:message code="label.topsearch.option.deals" /></option>
							</select>
						</td>
						<td>
							<input type="image" src="${contextPath}/static/images/shared/top_search_btn_${locale}.gif" />
						</td>
					</tr>
				</table> -->
			</div>
		</div>
	</div>
</jsp:root>