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
		
	<div class="nav-outer-repeat">
		<div class="nav-outer">
			<div id="nav-right">
				<a href="${contextPath}/j_spring_security_logout" id="logout">
					<img src="${contextPath}/static/images/shared/nav/nav_logout.png" width="16"
					height="16" alt="" /></a>
			</div>
			<div class="nav">
				<div class="table">
					<security:authorize access="hasAnyRole('COORDINATOR','OPERATOR')"> 
 					<ul id="dashboard_mi" class="select">
						<li><a href="${contextPath}/dashboard"> <b><s:message code="label.navigation.dashboard"/></b>
						</a>
							<div id="dashboard_mi_container" class="select_sub">
								<ul class="sub">
									<li id="dashboard_mi_home"><a href="${contextPath}/dashboard/mydeals"><s:message code="label.navigation.dashboard.my.page" /></a></li>
									<!-- 
									<li><a href="#nogo"><s:message code="label.navigation.dashboard.second" /></a></li>
									<li><a href="#nogo"><s:message code="label.navigation.dashboard.third" /></a></li>
									-->
								</ul>
							</div>
						</li>
					</ul>
					</security:authorize>
					<security:authorize access="hasRole('OPERATOR')"> 
					<ul id="workflow_mi" class="select">
						<li><a href="${contextPath}/workflow"> <b><s:message code="label.navigation.workflow" /></b>
						</a>
							<div id="workflow_mi_container" class="select_sub">
								<ul class="sub">
									<li id="workflow_mi_home"><a href="${contextPath}/workflow"><s:message code="label.navigation.workflow.home" /></a></li>
									<li id="workflow_mi_calls"><a href="${contextPath}/workflow/managecalls/init"><s:message code="label.navigation.workflow.calls" /></a></li>
									<!-- <li id="workflow_mi_clients"><a href="${contextPath}/workflow/manageclients/init"><s:message code="label.navigation.workflow.clients" /></a></li> -->
									<li id="workflow_mi_deals"><a href="${contextPath}/workflow/managedeals/init"><s:message code="label.navigation.workflow.deals" /></a></li>
								</ul>
							</div>
						</li>
					</ul>
					</security:authorize>
<!-- 					<ul id="reports_mi" class="select">
						<li><a href="${contextPath}/reports"> <b><s:message code="label.navigation.reports" /></b>
						</a>
							<div id="reports_mi_container" class="select_sub">
								<ul class="sub">
									<li id="reports_mi_home"><a href="#nogo"><s:message code="label.navigation.reports.first" /></a></li>
									<li><a href="#nogo"><s:message code="label.navigation.reports.second" /></a></li>
									<li><a href="#nogo"><s:message code="label.navigation.reports.third" /></a></li>
								</ul>
							</div>
						</li>
					</ul> -->
					<security:authorize access="hasRole('ADMIN')">
						<ul id="administration_mi" class="select">
							<li><a href="${contextPath}/administration"> <b><s:message code="label.navigation.administration" /></b>
							</a>
								<div id="administration_mi_container" class="select_sub">
									<ul class="sub">
										<li id="administration_mi_home"><a href="${contextPath}/administration"><s:message code="label.navigation.administration.home" /></a></li>
										<li id="administration_mi_users"><a href="${contextPath}/administration/manageusers"><s:message code="label.navigation.administration.users" /></a></li>
										<li id="administration_mi_offices"><a href="${contextPath}/administration/manageoffices"><s:message code="label.navigation.administration.offices" /></a></li>
										<li id="administration_mi_phonenumbers"><a href="${contextPath}/administration/managephonenumbers"><s:message code="label.navigation.administration.phone.numbers" /></a></li>
										<li id="administration_mi_infosources"><a href="${contextPath}/administration/manageinfosources"><s:message code="label.navigation.administration.information.sources" /></a></li>
										<li id="administration_mi_empltypes"><a href="${contextPath}/administration/manageempltypes"><s:message code="label.navigation.administration.employment.types" /></a></li>
									</ul>
								</div>
							</li>
						</ul>
					</security:authorize>
					<ul id="my_account_mi" class="select">
						<li><a href="${contextPath}/myusersettings"> <b><s:message code="label.navigation.my.account" /></b>
						</a>
							<div id="my_account_mi_container" class="select_sub">
								<ul class="sub">
									<li id="my_account_settings"><a href="${contextPath}/myusersettings"><s:message code="label.navigation.my.account.settings" /></a></li>
									<li id="my_account_password"><a href="${contextPath}/changepasswd"><s:message code="label.navigation.my.account.change.password" /></a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</jsp:root>