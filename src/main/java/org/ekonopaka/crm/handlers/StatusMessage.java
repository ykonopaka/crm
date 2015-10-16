package org.ekonopaka.crm.handlers;

public class StatusMessage {

	int status;
	String description;

	public static final int ERROR_STATUS = 0;
	public static final int WARNING_STATUS = 1;
	public static final int SUCCESS_STATUS = 2;

	StatusMessage(int status, String description) {
		this.status = status;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
