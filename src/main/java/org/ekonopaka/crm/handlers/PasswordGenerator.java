package org.ekonopaka.crm.handlers;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

	public String getRandomPassword() {
		StringBuffer password = new StringBuffer(20);
		int next = RandomUtils.nextInt(13) + 8;
		password.append(RandomStringUtils.randomAlphanumeric(next));
		return password.toString();
	}
}
