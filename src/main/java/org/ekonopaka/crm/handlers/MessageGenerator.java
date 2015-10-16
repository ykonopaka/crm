package org.ekonopaka.crm.handlers;

import org.springframework.stereotype.Component;

@Component
public class MessageGenerator {

	public StatusMessage generateMessage(int status, String description) {
		StatusMessage message = new StatusMessage(status, description);
		return message;
	}
}
