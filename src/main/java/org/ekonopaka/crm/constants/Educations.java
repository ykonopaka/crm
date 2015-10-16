package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.EducationType;

public class Educations {

	public static final String HIGHER = "label.high.education.type";
	public static final String HIGHER_NOT_FINISHED = "label.high.not.finished.education.type"; 
	public static final String SECONDARY = "label.secondary.education.type";
	public static final String SPECIAL = "label.secondary.special.education.type";
	
	public static List<EducationType> generate()	{
		List<EducationType> educationTypes = new ArrayList<EducationType>();
		educationTypes.add(new EducationType(1, Educations.HIGHER, true));
		educationTypes.add(new EducationType(2, Educations.HIGHER_NOT_FINISHED, true));
		educationTypes.add(new EducationType(3, Educations.SECONDARY, true));
		educationTypes.add(new EducationType(3, Educations.SPECIAL, true));
		return educationTypes;
	}
}
