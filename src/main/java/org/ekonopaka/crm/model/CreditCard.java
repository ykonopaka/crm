package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.CreditFormType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "CREDIT_CARDS")
public class CreditCard {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@Column(name = "FC_EXISTED")
	private Boolean fcIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "FC_BANK_NAME")
	private String fcBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FC_TIME_LEFT")
	private Integer fcTimeLeft;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CreditFormType fcCreditFormType;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FC_MONEY_LEFT")
	private Integer fcMoneyLeft;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FC_AMOUNT")
	private Integer fcAmount;
	
	@Column(name = "FC_STARTING_DATE")
	private Date fcStartingDate;

	@Column(name = "FC_ENDING_DATE")
	private Date fcEndingDate;
	
	@Column(name = "SC_EXISTED")
	private Boolean scIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "SC_BANK_NAME")
	private String scBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SC_TIME_LEFT")
	private Integer scTimeLeft;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CreditFormType scCreditFormType;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SC_MONEY_LEFT")
	private Integer scMoneyLeft;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SC_AMOUNT")
	private Integer scAmount;
	
	@Column(name = "SC_STARTING_DATE")
	private Date scStartingDate;

	@Column(name = "SC_ENDING_DATE")
	private Date scEndingDate;

	@Column(name = "TC_EXISTED")
	private Boolean tcIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "TC_BANK_NAME")
	private String tcBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TC_TIME_LEFT")
	private Integer tcTimeLeft;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CreditFormType tcCreditFormType;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TC_MONEY_LEFT")
	private Integer tcMoneyLeft;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TC_AMOUNT")
	private Integer tcAmount;
	
	@Column(name = "TC_STARTING_DATE")
	private Date tcStartingDate;

	@Column(name = "TC_ENDING_DATE")
	private Date tcEndingDate;
	
	@Column(name = "FCC_EXISTED")
	private Boolean fccIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "FCC_BANK_NAME")
	private String fccBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FCC_MONTH_PAYMENT")
	private Integer fccMonthPayment;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FCC_CREDIT_LIMIT")
	private Integer fccCreditLimit;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "FCC_MONEY_LEFT")
	private Integer fccMoneyLeft;
	
	@Column(name = "FCC_STARTING_DATE")
	private Date fccStartingDate;

	@Column(name = "FCC_ENDING_DATE")
	private Date fccEndingDate;
	
	@Column(name = "FCC_LAST_TRANSACTION_DATE")
	private Date fccLastTransactionDate;
	
	@Column(name = "SCC_EXISTED")
	private Boolean sccIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "SCC_BANK_NAME")
	private String sccBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SCC_MONTH_PAYMENT")
	private Integer sccMonthPayment;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SCC_CREDIT_LIMIT")
	private Integer sccCreditLimit;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SCC_MONEY_LEFT")
	private Integer sccMoneyLeft;
	
	@Column(name = "SCC_STARTING_DATE")
	private Date sccStartingDate;

	@Column(name = "SCC_ENDING_DATE")
	private Date sccEndingDate;
	
	@Column(name = "SCC_LAST_TRANSACTION_DATE")
	private Date sccLastTransactionDate;
	
	@Column(name = "TCC_EXISTED")
	private Boolean tccIsExisted;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "TCC_BANK_NAME")
	private String tccBankName;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TCC_MONTH_PAYMENT")
	private Integer tccMonthPayment;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TCC_CREDIT_LIMIT")
	private Integer tccCreditLimit;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "TCC_MONEY_LEFT")
	private Integer tccMoneyLeft;
	
	@Column(name = "TCC_STARTING_DATE")
	private Date tccStartingDate;

	@Column(name = "TCC_ENDING_DATE")
	private Date tccEndingDate;
	
	@Column(name = "TCC_LAST_TRANSACTION_DATE")
	private Date tccLastTransactionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getFcIsExisted() {
		return fcIsExisted;
	}

	public void setFcIsExisted(Boolean fcIsExisted) {
		this.fcIsExisted = fcIsExisted;
	}

	public String getFcBankName() {
		return fcBankName;
	}

	public void setFcBankName(String fcBankName) {
		this.fcBankName = fcBankName;
	}

	public Integer getFcTimeLeft() {
		return fcTimeLeft;
	}

	public void setFcTimeLeft(Integer fcTimeLeft) {
		this.fcTimeLeft = fcTimeLeft;
	}

	public CreditFormType getFcCreditFormType() {
		return fcCreditFormType;
	}

	public void setFcCreditFormType(CreditFormType fcCreditFormType) {
		this.fcCreditFormType = fcCreditFormType;
	}

	public Integer getFcMoneyLeft() {
		return fcMoneyLeft;
	}

	public void setFcMoneyLeft(Integer fcMoneyLeft) {
		this.fcMoneyLeft = fcMoneyLeft;
	}

	public Integer getFcAmount() {
		return fcAmount;
	}

	public void setFcAmount(Integer fcAmount) {
		this.fcAmount = fcAmount;
	}

	public Date getFcStartingDate() {
		return fcStartingDate;
	}

	public void setFcStartingDate(Date fcStartingDate) {
		this.fcStartingDate = fcStartingDate;
	}

	public Date getFcEndingDate() {
		return fcEndingDate;
	}

	public void setFcEndingDate(Date fcEndingDate) {
		this.fcEndingDate = fcEndingDate;
	}

	public Boolean getScIsExisted() {
		return scIsExisted;
	}

	public void setScIsExisted(Boolean scIsExisted) {
		this.scIsExisted = scIsExisted;
	}

	public String getScBankName() {
		return scBankName;
	}

	public void setScBankName(String scBankName) {
		this.scBankName = scBankName;
	}

	public Integer getScTimeLeft() {
		return scTimeLeft;
	}

	public void setScTimeLeft(Integer scTimeLeft) {
		this.scTimeLeft = scTimeLeft;
	}

	public CreditFormType getScCreditFormType() {
		return scCreditFormType;
	}

	public void setScCreditFormType(CreditFormType scCreditFormType) {
		this.scCreditFormType = scCreditFormType;
	}

	public Integer getScMoneyLeft() {
		return scMoneyLeft;
	}

	public void setScMoneyLeft(Integer scMoneyLeft) {
		this.scMoneyLeft = scMoneyLeft;
	}

	public Integer getScAmount() {
		return scAmount;
	}

	public void setScAmount(Integer scAmount) {
		this.scAmount = scAmount;
	}

	public Date getScStartingDate() {
		return scStartingDate;
	}

	public void setScStartingDate(Date scStartingDate) {
		this.scStartingDate = scStartingDate;
	}

	public Date getScEndingDate() {
		return scEndingDate;
	}

	public void setScEndingDate(Date scEndingDate) {
		this.scEndingDate = scEndingDate;
	}

	public Boolean getTcIsExisted() {
		return tcIsExisted;
	}

	public void setTcIsExisted(Boolean tcIsExisted) {
		this.tcIsExisted = tcIsExisted;
	}

	public String getTcBankName() {
		return tcBankName;
	}

	public void setTcBankName(String tcBankName) {
		this.tcBankName = tcBankName;
	}

	public Integer getTcTimeLeft() {
		return tcTimeLeft;
	}

	public void setTcTimeLeft(Integer tcTimeLeft) {
		this.tcTimeLeft = tcTimeLeft;
	}

	public CreditFormType getTcCreditFormType() {
		return tcCreditFormType;
	}

	public void setTcCreditFormType(CreditFormType tcCreditFormType) {
		this.tcCreditFormType = tcCreditFormType;
	}

	public Integer getTcMoneyLeft() {
		return tcMoneyLeft;
	}

	public void setTcMoneyLeft(Integer tcMoneyLeft) {
		this.tcMoneyLeft = tcMoneyLeft;
	}

	public Integer getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(Integer tcAmount) {
		this.tcAmount = tcAmount;
	}

	public Date getTcStartingDate() {
		return tcStartingDate;
	}

	public void setTcStartingDate(Date tcStartingDate) {
		this.tcStartingDate = tcStartingDate;
	}

	public Date getTcEndingDate() {
		return tcEndingDate;
	}

	public void setTcEndingDate(Date tcEndingDate) {
		this.tcEndingDate = tcEndingDate;
	}

	public Boolean getFccIsExisted() {
		return fccIsExisted;
	}

	public void setFccIsExisted(Boolean fccIsExisted) {
		this.fccIsExisted = fccIsExisted;
	}

	public String getFccBankName() {
		return fccBankName;
	}

	public void setFccBankName(String fccBankName) {
		this.fccBankName = fccBankName;
	}

	public Integer getFccMonthPayment() {
		return fccMonthPayment;
	}

	public void setFccMonthPayment(Integer fccMonthPayment) {
		this.fccMonthPayment = fccMonthPayment;
	}

	public Integer getFccCreditLimit() {
		return fccCreditLimit;
	}

	public void setFccCreditLimit(Integer fccCreditLimit) {
		this.fccCreditLimit = fccCreditLimit;
	}

	public Integer getFccMoneyLeft() {
		return fccMoneyLeft;
	}

	public void setFccMoneyLeft(Integer fccMoneyLeft) {
		this.fccMoneyLeft = fccMoneyLeft;
	}

	public Date getFccStartingDate() {
		return fccStartingDate;
	}

	public void setFccStartingDate(Date fccStartingDate) {
		this.fccStartingDate = fccStartingDate;
	}

	public Date getFccEndingDate() {
		return fccEndingDate;
	}

	public void setFccEndingDate(Date fccEndingDate) {
		this.fccEndingDate = fccEndingDate;
	}

	public Boolean getSccIsExisted() {
		return sccIsExisted;
	}

	public void setSccIsExisted(Boolean sccIsExisted) {
		this.sccIsExisted = sccIsExisted;
	}

	public String getSccBankName() {
		return sccBankName;
	}

	public void setSccBankName(String sccBankName) {
		this.sccBankName = sccBankName;
	}

	public Integer getSccMonthPayment() {
		return sccMonthPayment;
	}

	public void setSccMonthPayment(Integer sccMonthPayment) {
		this.sccMonthPayment = sccMonthPayment;
	}

	public Integer getSccCreditLimit() {
		return sccCreditLimit;
	}

	public void setSccCreditLimit(Integer sccCreditLimit) {
		this.sccCreditLimit = sccCreditLimit;
	}

	public Integer getSccMoneyLeft() {
		return sccMoneyLeft;
	}

	public void setSccMoneyLeft(Integer sccMoneyLeft) {
		this.sccMoneyLeft = sccMoneyLeft;
	}

	public Date getSccStartingDate() {
		return sccStartingDate;
	}

	public void setSccStartingDate(Date sccStartingDate) {
		this.sccStartingDate = sccStartingDate;
	}

	public Date getSccEndingDate() {
		return sccEndingDate;
	}

	public void setSccEndingDate(Date sccEndingDate) {
		this.sccEndingDate = sccEndingDate;
	}

	public Boolean getTccIsExisted() {
		return tccIsExisted;
	}

	public void setTccIsExisted(Boolean tccIsExisted) {
		this.tccIsExisted = tccIsExisted;
	}

	public String getTccBankName() {
		return tccBankName;
	}

	public void setTccBankName(String tccBankName) {
		this.tccBankName = tccBankName;
	}

	public Integer getTccMonthPayment() {
		return tccMonthPayment;
	}

	public void setTccMonthPayment(Integer tccMonthPayment) {
		this.tccMonthPayment = tccMonthPayment;
	}

	public Integer getTccCreditLimit() {
		return tccCreditLimit;
	}

	public void setTccCreditLimit(Integer tccCreditLimit) {
		this.tccCreditLimit = tccCreditLimit;
	}

	public Integer getTccMoneyLeft() {
		return tccMoneyLeft;
	}

	public void setTccMoneyLeft(Integer tccMoneyLeft) {
		this.tccMoneyLeft = tccMoneyLeft;
	}

	public Date getTccStartingDate() {
		return tccStartingDate;
	}

	public void setTccStartingDate(Date tccStartingDate) {
		this.tccStartingDate = tccStartingDate;
	}

	public Date getTccEndingDate() {
		return tccEndingDate;
	}

	public void setTccEndingDate(Date tccEndingDate) {
		this.tccEndingDate = tccEndingDate;
	}

	public Date getFccLastTransactionDate() {
		return fccLastTransactionDate;
	}

	public void setFccLastTransactionDate(Date fccLastTransactionDate) {
		this.fccLastTransactionDate = fccLastTransactionDate;
	}

	public Date getSccLastTransactionDate() {
		return sccLastTransactionDate;
	}

	public void setSccLastTransactionDate(Date sccLastTransactionDate) {
		this.sccLastTransactionDate = sccLastTransactionDate;
	}

	public Date getTccLastTransactionDate() {
		return tccLastTransactionDate;
	}

	public void setTccLastTransactionDate(Date tccLastTransactionDate) {
		this.tccLastTransactionDate = tccLastTransactionDate;
	}
	
	
	
}
