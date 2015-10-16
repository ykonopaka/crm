package org.ekonopaka.crm.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateFormatter {

	public static String format = "dd.MM.yyyy HH:mm:ss";
	
	SimpleDateFormat formatter;
	
	DateFormatter()	{
		formatter = new SimpleDateFormat(format);
	}
	
	public String format(Date date)	{
		return formatter.format(date);
	}
	
}
