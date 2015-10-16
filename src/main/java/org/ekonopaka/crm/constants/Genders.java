package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.GenderType;

public class Genders {

	public static final String MALE = "label.male.gender.type";
	public static final String FEMALE = "label.female.gender.type";
	
	public static List<GenderType> generate()	{
		List<GenderType> genderTypes = new ArrayList<GenderType>();
		genderTypes.add(new GenderType(1, Genders.MALE, true));
		genderTypes.add(new GenderType(2, Genders.FEMALE, true));
		return genderTypes;
	}
}
