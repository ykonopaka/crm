package org.ekonopaka.crm.handlers;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.ekonopaka.crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component
public class EmailHandler {

	String TEST_MESSAGE_TEMPLATE_BODY = "templates/test_message_body.vm";
	String TEST_MESSAGE_TEMPLATE_SUBJECT = "templates/test_message_subject.vm";

	String FORGOTPASSWD_MESSAGE_TEMPLATE_BODY = "templates/forgotpasswd_message_body.vm";
	String FORGOTPASSWD_MESSAGE_TEMPLATE_SUBJECT = "templates/forgotpasswd_message_subject.vm";

	@Autowired
	JavaMailSenderImpl sender;

	@Autowired
	VelocityEngine velocityEngine;

	@Autowired
	PasswordGenerator passwordGenerator;

	Logger log = Logger.getLogger(this.getClass());

	public void sendMessage(@SuppressWarnings("rawtypes") Map model,
			String templateBody, String templateSubject, String toRecipient) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(toRecipient);
			String subject = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateSubject, model);
			String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateBody, model);
			helper.setText(body, true);
			helper.setSubject(subject);

			sender.send(message);
		} catch (MessagingException e) {
			log.error("Unable to send email message", e);
		}

	}

	public void sendTestMessage(User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		sendMessage(model, TEST_MESSAGE_TEMPLATE_BODY,
				TEST_MESSAGE_TEMPLATE_SUBJECT, user.getEmail());
	}

	public void sendNewPassword(User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		sendMessage(model, FORGOTPASSWD_MESSAGE_TEMPLATE_BODY,
				FORGOTPASSWD_MESSAGE_TEMPLATE_SUBJECT, user.getEmail());
	}
}
