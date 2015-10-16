package org.ekonopaka.crm.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ClasspathFileReader {

	public String readFile(String path) throws IOException {
		final DefaultResourceLoader loader = new DefaultResourceLoader();
		Resource resource = loader.getResource("classpath:" + path);
		InputStream inputStream = null;
		StringWriter writer = new StringWriter();
		try {
			inputStream = resource.getInputStream();
			IOUtils.copy(inputStream, writer, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String result = writer.toString();
		return result;
	}

}
