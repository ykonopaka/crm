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

	<c:if test="${not empty client.specificEmploymentType}">
		<script>
			$(window).load(function() {
				$('#employment_type_input').click();
				$('#employment_type_enter').removeAttr("disabled");
				$('#employment_type_choose').attr("disabled", "disabled");
			});
		</script>
	</c:if>

	<c:if test="${empty client.specificEmploymentType}">
		<script>
			$(window).load(function() {
				$('#employment_type_select').click();
				$('#employment_type_choose').removeAttr("disabled");
				$('#employment_type_enter').attr("disabled", "disabled");
			});
		</script>
	</c:if>

	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_clients').addClass('sub_show');

		$(window).load(
				function() {
					$('input[name=employment_type]').click(
							function() {
								if ($('input[name=employment_type]:checked')
										.val() == 'input') {
									$('#employment_type_enter').removeAttr(
											"disabled");
									$('#employment_type_choose').attr(
											"disabled", "disabled");

								}
								if ($('input[name=employment_type]:checked')
										.val() == 'select') {
									$('#employment_type_choose').removeAttr(
											"disabled");
									$('#employment_type_enter').attr(
											"disabled", "disabled");
								}
							});
				});
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
									<form:form method="POST" commandName="client">
										<tr>
											<th />
											<td></td>
										</tr>

										<tr>
											<th valign="top"><s:message
													code="label.add.new.client.last.name" /></th>
											<td><form:input path="lastName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="lastName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.add.new.client.first.name" /></th>
											<td><form:input path="firstName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="firstName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message
													code="label.add.new.client.middle.name" /></th>
											<td><form:input path="middleName" type="text"
													class="inp-form" /></td>
											<td><form:errors path="middleName" element="p"
													cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top">
												<s:message code="label.add.new.client.employment.type" />
											</th>
											<td><input type="radio" name="employment_type"  id="employment_type_select" checked="checked" value="select" />
												<label for="employment_type_select">
													<s:message code="label.add.new.client.choose.employment.type.select" />
												</label>
											</td>
										</tr>
										<tr>
											<th />
											<td><c:choose>
													<c:when test="${empty employmentTypesList}">
														<s:message code="label.no.predefined.employment.types" />
													</c:when>
													<c:otherwise>
														<form:select id="employment_type_choose" multiple="single"
															path="employmentType.id" class="inp-form-select">
															<form:options items="${employmentTypesList}"
																itemValue="id" itemLabel="description" />
														</form:select>
													</c:otherwise>
												</c:choose></td>
										</tr>
										<tr>
											<th />
											<td><input type="radio" name="employment_type" id="employment_type_input" value="input" />
												<label for="employment_type_input">
													<s:message code="label.add.new.client.choose.employment.type.input" />
												</label>
											</td>
										</tr>
										<tr>
											<th />
											<td><form:input id="employment_type_enter" type="text"
													path="specificEmploymentType" class="inp-form" /></td>
											<td><form:errors path="specificEmploymentType"
													element="p" cssClass="inp-form-error" /></td>
										</tr>
										<c:forEach var="clientPhoneNumber"
											items="${clientPhoneNumbersList}" varStatus="status">
											<tr>
												<c:choose>
													<c:when test="${status.index==0}">
														<th valign="top"><s:message
																code="label.add.new.client.phone.numbers" /></th>
													</c:when>
													<c:otherwise>
														<th />
													</c:otherwise>
												</c:choose>
												<td><form:input
														path="clientPhoneNumbers[${status.index}].phoneNumber"
														type="text" class="inp-form" /></td>
												<td><form:errors
														path="clientPhoneNumbers[${status.index}].phoneNumber"
														element="p" cssClass="inp-form-error" /></td>
											</tr>
										</c:forEach>
										<tr>
											<th />
										</tr>
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-submit-${locale}" /> <a class="form-reset-${locale}"
												href="${contextPath}/workflow/manageclients/init"></a></td>
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