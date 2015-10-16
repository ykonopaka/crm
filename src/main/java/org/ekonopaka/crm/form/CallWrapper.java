package org.ekonopaka.crm.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.ClientPhoneNumber;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.PhoneNumber;

public class CallWrapper {

	Client pClient;

	ClientPhoneNumber pClientPhoneNumber;

	@Pattern(regexp = "([0-9\\+\\-])*")
	String fClientPhoneNumber;
	
	@Size(min = 3, max = 30)
	String fClientPhoneNumberDescription;
	
	InfoSource infoSource;
	
	PhoneNumber phoneNumber; 

	public Client getpClient() {
		return pClient;
	}

	public void setpClient(Client pClient) {
		this.pClient = pClient;
	}

	public ClientPhoneNumber getpClientPhoneNumber() {
		return pClientPhoneNumber;
	}

	public void setpClientPhoneNumber(ClientPhoneNumber pClientPhoneNumbers) {
		this.pClientPhoneNumber = pClientPhoneNumbers;
	}

	public String getfClientPhoneNumber() {
		return fClientPhoneNumber;
	}

	public void setfClientPhoneNumber(String fClientPhoneNumber) {
		this.fClientPhoneNumber = fClientPhoneNumber;
	}

	public String getfClientPhoneNumberDescription() {
		return fClientPhoneNumberDescription;
	}

	public void setfClientPhoneNumberDescription(
			String fClientPhoneNumberDescription) {
		this.fClientPhoneNumberDescription = fClientPhoneNumberDescription;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public InfoSource getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(InfoSource infoSource) {
		this.infoSource = infoSource;
	}

}
