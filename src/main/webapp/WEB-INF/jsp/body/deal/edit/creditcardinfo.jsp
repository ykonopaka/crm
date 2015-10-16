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

	<c:if test="${creditCard.fcIsExisted == false}">
		<script>
			$(window).load(function() {
				$('.fcCreditFormType').prop('disabled', true);
				$('[name="fcBankName"]').prop('disabled', true);
				$('[name="fcTimeLeft"]').prop('disabled', true);
				$('[name="fcMoneyLeft"]').prop('disabled', true);
				$('[name="fcAmount"]').prop('disabled', true);
				$('[name="fcStartingDate"]').prop('disabled', true);
				$('[name="fcEndingDate"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${creditCard.scIsExisted == false}">
		<script>
			$(window).load(function() {
				$('.scCreditFormType').prop('disabled', true);
				$('[name="scBankName"]').prop('disabled', true);
				$('[name="scTimeLeft"]').prop('disabled', true);
				$('[name="scMoneyLeft"]').prop('disabled', true);
				$('[name="scAmount"]').prop('disabled', true);
				$('[name="scStartingDate"]').prop('disabled', true);
				$('[name="scEndingDate"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${creditCard.tcIsExisted == false}">
		<script>
			$(window).load(function() {
				$('.tcCreditFormType').prop('disabled', true);
				$('[name="tcBankName"]').prop('disabled', true);
				$('[name="tcTimeLeft"]').prop('disabled', true);
				$('[name="tcMoneyLeft"]').prop('disabled', true);
				$('[name="tcAmount"]').prop('disabled', true);
				$('[name="tcStartingDate"]').prop('disabled', true);
				$('[name="tcEndingDate"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${creditCard.fccIsExisted == false}">
		<script>
			$(window).load(function() {
				$('[name="fccBankName"]').prop('disabled', true);
				$('[name="fccMonthPayment"]').prop('disabled', true);
				$('[name="fccCreditLimit"]').prop('disabled', true);
				$('[name="fccMoneyLeft"]').prop('disabled', true);
				$('[name="fccStartingDate"]').prop('disabled', true);
				$('[name="fccEndingDate"]').prop('disabled', true);
				$('[name="fccLastTransactionDate"]').prop('disabled', true);
			});
		</script>
	</c:if>
	
	<c:if test="${creditCard.sccIsExisted == false}">
		<script>
			$(window).load(function() {
				$('[name="sccBankName"]').prop('disabled', true);
				$('[name="sccMonthPayment"]').prop('disabled', true);
				$('[name="sccCreditLimit"]').prop('disabled', true);
				$('[name="sccMoneyLeft"]').prop('disabled', true);
				$('[name="sccStartingDate"]').prop('disabled', true);
				$('[name="sccEndingDate"]').prop('disabled', true);
				$('[name="sccLastTransactionDate"]').prop('disabled', true);
				
			});
		</script>
	</c:if>
	
	<c:if test="${creditCard.tccIsExisted == false}">
		<script>
			$(window).load(function() {
				$('[name="tccBankName"]').prop('disabled', true);
				$('[name="tccMonthPayment"]').prop('disabled', true);
				$('[name="tccCreditLimit"]').prop('disabled', true);
				$('[name="tccMoneyLeft"]').prop('disabled', true);
				$('[name="tccStartingDate"]').prop('disabled', true);
				$('[name="tccEndingDate"]').prop('disabled', true);
				$('[name="tccLastTransactionDate"]').prop('disabled', true);
			});
		</script>
	</c:if>

	<script>
		$('#workflow_mi').removeClass('select').addClass('current');
		$('#workflow_mi_container').addClass('show');
		$('#workflow_mi_deals').addClass('sub_show');
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker3" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker3" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
			
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker4" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker4" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker5" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker5" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
			
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker6" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker6" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker7" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker7" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
			
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker8" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker8" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker9" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker9" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
			
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker10" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker10" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker11" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker11" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
			
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker12" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker12" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker13" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker13" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker14" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker14" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		$(function() {
			$.datepicker.setDefaults( $.datepicker.regional[ "${locale}" ] );
			$( "#datepicker15" ).datepicker( "option", "dateFormat", "dd.mm.yy" );
			$( "#datepicker15" ).datepicker({
				changeMonth: true,
				changeYear: true,
				yearRange : 'c-75:c+30',
				dateFormat : "dd.mm.yy",
				maxDate: new Date
			});
		});
		
		
		$(window).load(
				function() {
					$('#fcIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.fcCreditFormType').prop('disabled', false);
									$('[name="fcBankName"]').prop('disabled', false);
									$('[name="fcTimeLeft"]').prop('disabled', false);
									$('[name="fcMoneyLeft"]').prop('disabled', false);
									$('[name="fcAmount"]').prop('disabled', false);
									$('[name="fcStartingDate"]').prop('disabled', false);
									$('[name="fcEndingDate"]').prop('disabled', false);
							    } else {
									$('.fcCreditFormType').prop('disabled', true);
									$('[name="fcBankName"]').prop('disabled', true);
									$('[name="fcTimeLeft"]').prop('disabled', true);
									$('[name="fcMoneyLeft"]').prop('disabled', true);
									$('[name="fcAmount"]').prop('disabled', true);
									$('[name="fcStartingDate"]').prop('disabled', true);
									$('[name="fcEndingDate"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#scIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.scCreditFormType').prop('disabled', false);
									$('[name="scBankName"]').prop('disabled', false);
									$('[name="scTimeLeft"]').prop('disabled', false);
									$('[name="scMoneyLeft"]').prop('disabled', false);
									$('[name="scAmount"]').prop('disabled', false);
									$('[name="scStartingDate"]').prop('disabled', false);
									$('[name="scEndingDate"]').prop('disabled', false);
							    } else {
									$('.scCreditFormType').prop('disabled', true);
									$('[name="scBankName"]').prop('disabled', true);
									$('[name="scTimeLeft"]').prop('disabled', true);
									$('[name="scMoneyLeft"]').prop('disabled', true);
									$('[name="scAmount"]').prop('disabled', true);
									$('[name="scStartingDate"]').prop('disabled', true);
									$('[name="scEndingDate"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#tcIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('.tcCreditFormType').prop('disabled', false);
									$('[name="tcBankName"]').prop('disabled', false);
									$('[name="tcTimeLeft"]').prop('disabled', false);
									$('[name="tcMoneyLeft"]').prop('disabled', false);
									$('[name="tcAmount"]').prop('disabled', false);
									$('[name="tcStartingDate"]').prop('disabled', false);
									$('[name="tcEndingDate"]').prop('disabled', false);
									
							    } else {
									$('.tcCreditFormType').prop('disabled', true);
									$('[name="tcBankName"]').prop('disabled', true);
									$('[name="tcTimeLeft"]').prop('disabled', true);
									$('[name="tcMoneyLeft"]').prop('disabled', true);
									$('[name="tcAmount"]').prop('disabled', true);
									$('[name="tcStartingDate"]').prop('disabled', true);
									$('[name="tcEndingDate"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#fccIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('[name="fccBankName"]').prop('disabled', false);
									$('[name="fccMonthPayment"]').prop('disabled', false);
									$('[name="fccCreditLimit"]').prop('disabled', false);
									$('[name="fccMoneyLeft"]').prop('disabled', false);
									$('[name="fccStartingDate"]').prop('disabled', false);
									$('[name="fccEndingDate"]').prop('disabled', false);
									$('[name="fccLastTransactionDate"]').prop('disabled', false);									
									
							    } else {
									$('[name="fccBankName"]').prop('disabled', true);
									$('[name="fccMonthPayment"]').prop('disabled', true);
									$('[name="fccCreditLimit"]').prop('disabled', true);
									$('[name="fccMoneyLeft"]').prop('disabled', true);
									$('[name="fccStartingDate"]').prop('disabled', true);
									$('[name="fccEndingDate"]').prop('disabled', true);
									$('[name="fccLastTransactionDate"]').prop('disabled', true);
							    }
							}
						);
					});

		$(window).load(
				function() {
					$('#sccIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('[name="sccBankName"]').prop('disabled', false);
									$('[name="sccMonthPayment"]').prop('disabled', false);
									$('[name="sccCreditLimit"]').prop('disabled', false);
									$('[name="sccMoneyLeft"]').prop('disabled', false);
									$('[name="sccStartingDate"]').prop('disabled', false);
									$('[name="sccEndingDate"]').prop('disabled', false);
									$('[name="sccLastTransactionDate"]').prop('disabled', false);									
							    } else {
									$('[name="sccBankName"]').prop('disabled', true);
									$('[name="sccMonthPayment"]').prop('disabled', true);
									$('[name="sccCreditLimit"]').prop('disabled', true);
									$('[name="sccMoneyLeft"]').prop('disabled', true);
									$('[name="sccStartingDate"]').prop('disabled', true);
									$('[name="sccEndingDate"]').prop('disabled', true);
									$('[name="sccLastTransactionDate"]').prop('disabled', true);
							    }
							}
						);
					});
		
		$(window).load(
				function() {
					$('#tccIsExisted').change(
							function() {
							    if ($(this).is(':checked')) {
									$('[name="tccBankName"]').prop('disabled', false);
									$('[name="tccMonthPayment"]').prop('disabled', false);
									$('[name="tccCreditLimit"]').prop('disabled', false);
									$('[name="tccMoneyLeft"]').prop('disabled', false);
									$('[name="tccStartingDate"]').prop('disabled', false);
									$('[name="tccEndingDate"]').prop('disabled', false);
									$('[name="tccLastTransactionDate"]').prop('disabled', false);										
							    } else {
									$('[name="tccBankName"]').prop('disabled', true);
									$('[name="tccMonthPayment"]').prop('disabled', true);
									$('[name="tccCreditLimit"]').prop('disabled', true);
									$('[name="tccMoneyLeft"]').prop('disabled', true);
									$('[name="tccStartingDate"]').prop('disabled', true);
									$('[name="tccEndingDate"]').prop('disabled', true);
									$('[name="tccLastTransactionDate"]').prop('disabled', true);									
							    }
							}
						);
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
					<h2><s:message code="label.header.edit.deal.step13.credit.and.credit.cards" /></h2>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" id="id-form">
									<form:form method="POST" commandName="creditCard">
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th><h2><s:message code="label.header.add.deal.step13.credits" /></h2></th>
											<td/>
											<td/>
										</tr>
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.first" /></h3></th>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.exist" /></th>
											<td class="border-line"><form:checkbox id="fcIsExisted" path="fcIsExisted"/></td>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.bank.name" /></th>
											<td class="border-line"><form:input path="fcBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="fcBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.time.left" /></th>
											<td class="border-line"><form:input path="fcTimeLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="fcTimeLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.form" /></th>
											<td class="border-line"><form:select path="fcCreditFormType.id"  type="text"
													items="${fcCreditTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select fcCreditFormType"/></td>
											<td/>													
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.money.left" /></th>
											<td class="border-line"><form:input path="fcMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="fcMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.amount" /></th>
											<td class="border-line"><form:input path="fcAmount" type="text" class="inp-form"/></td>
											<td><form:errors path="fcAmount" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.first.start.date" /></th>
											<td class="border-line"><form:input path="fcStartingDate" type="text" class="inp-form" id="datepicker1"/></td>
											<td><form:errors path="fcStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.first.end.date" /></th>
											<td><form:input path="fcEndingDate" type="text" class="inp-form" id="datepicker2"/></td>
											<td><form:errors path="fcEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>										
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.second" /></h3></th>
											<td/>
											<td/>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.exist" /></th>
											<td class="border-line"><form:checkbox id="scIsExisted" path="scIsExisted"/></td>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.bank.name" /></th>
											<td class="border-line"><form:input path="scBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="scBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.time.left" /></th>
											<td class="border-line"><form:input path="scTimeLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="scTimeLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.form" /></th>
											<td class="border-line"><form:select path="scCreditFormType.id"  type="text"
													items="${scCreditTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select scCreditFormType"/></td>
											<td/>													
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.money.left" /></th>
											<td class="border-line"><form:input path="scMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="scMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.amount" /></th>
											<td class="border-line"><form:input path="scAmount" type="text" class="inp-form"/></td>
											<td><form:errors path="scAmount" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.second.start.date" /></th>
											<td class="border-line"><form:input path="scStartingDate" type="text" class="inp-form" id="datepicker3"/></td>
											<td><form:errors path="scStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.second.end.date" /></th>
											<td><form:input path="scEndingDate" type="text" class="inp-form" id="datepicker4"/></td>
											<td><form:errors path="scEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>										
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.third" /></h3></th>
											<td/>
											<td/>											
										</tr >
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.exist" /></th>
											<td class="border-line"><form:checkbox id="tcIsExisted" path="tcIsExisted"/></td>
											<td/>											
										</tr >
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.bank.name" /></th>
											<td class="border-line"><form:input path="tcBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="tcBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.time.left" /></th>
											<td class="border-line"><form:input path="tcTimeLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="tcTimeLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.form" /></th>
											<td class="border-line"><form:select path="tcCreditFormType.id"  type="text"
													items="${tcCreditTypeList}" itemValue="id" itemLabel="description"
													class="inp-form-select tcCreditFormType"/></td>
											<td/>													
										</tr>	
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.money.left" /></th>
											<td class="border-line"><form:input path="tcMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="tcMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.amount" /></th>
											<td class="border-line"><form:input path="tcAmount" type="text" class="inp-form" /></td>
											<td><form:errors path="tcAmount" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.third.start.date" /></th>
											<td class="border-line"><form:input path="tcStartingDate" type="text" class="inp-form" id="datepicker5"/></td>
											<td><form:errors path="tcStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.third.end.date" /></th>
											<td><form:input path="tcEndingDate" type="text" class="inp-form" id="datepicker6"/></td>
											<td><form:errors path="tcEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>
										<tr>
											<th><h2><s:message code="label.header.add.deal.step13.credit.cards" /></h2></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.card.first" /></h3></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.exist" /></th>
											<td class="border-line"><form:checkbox id="fccIsExisted" path="fccIsExisted"/></td>
											<td/>											
										</tr>																																																		
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.bank.name" /></th>
											<td class="border-line"><form:input path="fccBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="fccBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.month.payment" /></th>
											<td class="border-line"><form:input path="fccMonthPayment" type="text" class="inp-form"/></td>
											<td><form:errors path="fccMonthPayment" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.credit.limit" /></th>
											<td class="border-line"><form:input path="fccCreditLimit" type="text" class="inp-form"/></td>
											<td><form:errors path="fccCreditLimit" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.money.left" /></th>
											<td class="border-line"><form:input path="fccMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="fccMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr >
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.start.date" /></th>
											<td class="border-line"><form:input path="fccStartingDate" type="text" class="inp-form" id="datepicker7"/></td>
											<td><form:errors path="fccStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.end.date" /></th>
											<td class="border-line"><form:input path="fccEndingDate" type="text" class="inp-form" id="datepicker8"/></td>
											<td><form:errors path="fccEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.card.first.last.transaction.date" /></th>
											<td><form:input path="fccLastTransactionDate" type="text" class="inp-form" id="datepicker9"/></td>
											<td><form:errors path="fccLastTransactionDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>	
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.card.second" /></h3></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.exist" /></th>
											<td class="border-line"><form:checkbox id="sccIsExisted" path="sccIsExisted"/></td>
											<td/>											
										</tr>																																																		
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.bank.name" /></th>
											<td class="border-line"><form:input path="sccBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="sccBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.month.payment" /></th>
											<td class="border-line"><form:input path="sccMonthPayment" type="text" class="inp-form"/></td>
											<td><form:errors path="sccMonthPayment" element="p" cssClass="inp-form-error" /></td>
										</tr >
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.credit.limit" /></th>
											<td class="border-line"><form:input path="sccCreditLimit" type="text" class="inp-form"/></td>
											<td><form:errors path="sccCreditLimit" element="p" cssClass="inp-form-error" /></td>
										</tr >
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.money.left" /></th>
											<td class="border-line"><form:input path="sccMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="sccMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.start.date" /></th>
											<td class="border-line"><form:input path="sccStartingDate" type="text" class="inp-form" id="datepicker10"/></td>
											<td><form:errors path="sccStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.end.date" /></th>
											<td class="border-line"><form:input path="sccEndingDate" type="text" class="inp-form" id="datepicker11"/></td>
											<td><form:errors path="sccEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.card.second.last.transaction.date" /></th>
											<td><form:input path="sccLastTransactionDate" type="text" class="inp-form" id="datepicker12"/></td>
											<td><form:errors path="sccLastTransactionDate" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th/>
											<td/>
											<td/>
										</tr>																																									
										<tr>
											<th><h3><s:message code="label.header.add.deal.step13.credit.card.third" /></h3></th>
											<td/>
											<td/>											
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.exist" /></th>
											<td class="border-line"><form:checkbox id="tccIsExisted" path="tccIsExisted"/></td>
											<td/>											
										</tr>																																																		
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.bank.name" /></th>
											<td class="border-line"><form:input path="tccBankName" type="text" class="inp-form"/></td>
											<td><form:errors path="tccBankName" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.month.payment" /></th>
											<td class="border-line"><form:input path="tccMonthPayment" type="text" class="inp-form"/></td>
											<td><form:errors path="tccMonthPayment" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.credit.limit" /></th>
											<td class="border-line"><form:input path="tccCreditLimit" type="text" class="inp-form"/></td>
											<td><form:errors path="tccCreditLimit" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.money.left" /></th>
											<td class="border-line"><form:input path="tccMoneyLeft" type="text" class="inp-form"/></td>
											<td><form:errors path="tccMoneyLeft" element="p" cssClass="inp-form-error" /></td>
										</tr>
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.start.date" /></th>
											<td class="border-line"><form:input path="tccStartingDate" type="text" class="inp-form" id="datepicker13"/></td>
											<td><form:errors path="tccStartingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th class="border-line" valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.end.date" /></th>
											<td class="border-line"><form:input path="tccEndingDate" type="text" class="inp-form" id="datepicker14"/></td>
											<td><form:errors path="tccEndingDate" element="p" cssClass="inp-form-error" /></td>
										</tr>										
										<tr>
											<th valign="top"><s:message code="label.header.add.deal.step13.credit.card.third.last.transaction.date" /></th>
											<td><form:input path="tccLastTransactionDate" type="text" class="inp-form" id="datepicker15"/></td>
											<td><form:errors path="tccLastTransactionDate" element="p" cssClass="inp-form-error" /></td>
										</tr>											
										<tr>
											<th />
											<td/>
											<td/>
										</tr>
										<tr>
											<th></th>
											<td valign="top"><input name="commit" type="submit"
												value="" class="form-next-${locale}" />
											<a class="form-reset-${locale}" href="${contextPath}/workflow/managedeals/init"></a>
											</td>
											<td/>
										</tr>																				
										
									</form:form>
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