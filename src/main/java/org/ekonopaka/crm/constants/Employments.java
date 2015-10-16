package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.EmploymentType;

public class Employments {

	public static final String OFFICIAL = "label.official.worker.employment.type"; 
	public static final String NON_OFFICIAL = "label.non.official.worker.employment.type";
	public static final String PRIVATE_ENTERPRENEUR = "label.private.entrepreneur.employment.type";
	public static final String OTHER = "label.other.employment.type";
	
	public static final int ID_OFFICIAL = 1; 
	public static final int ID_NON_OFFICIAL = 2;
	public static final int ID_PRIVATE_ENTERPRENEUR = 3;
	public static final int ID_OTHER = 4;

	public static List<EmploymentType> generate()	{
		List<EmploymentType> employmentTypes = new ArrayList<EmploymentType>();
		employmentTypes.add(new EmploymentType(ID_OFFICIAL, Employments.OFFICIAL, true));
		employmentTypes.add(new EmploymentType(ID_NON_OFFICIAL, Employments.NON_OFFICIAL, true));
		employmentTypes.add(new EmploymentType(ID_PRIVATE_ENTERPRENEUR, Employments.PRIVATE_ENTERPRENEUR, true));
		employmentTypes.add(new EmploymentType(ID_OTHER, Employments.OTHER, true));
		return employmentTypes;
	}
}
