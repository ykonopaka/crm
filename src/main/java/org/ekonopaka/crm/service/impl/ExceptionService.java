package org.ekonopaka.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.service.interfaces.IExceptionService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService implements IExceptionService {

	@Override
	public List<String> transformException(Exception e) {
		List<String> ex = new ArrayList<String>();
		ex.add(e.toString());
		
		for (StackTraceElement traceElement : e.getStackTrace())	{
			ex.add(traceElement.toString());
		}
		
		return ex;
	}

}
