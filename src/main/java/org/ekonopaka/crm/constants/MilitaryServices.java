package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.MilitaryServiceType;

public class MilitaryServices {

	public static final String ALREADY_SERVED = "label.already.has.been.military.service.type";
	public static final String LIABLE = "label.liable.for.military.service.type";
	public static final String NON_LIABLE = "label.non.liable.for.military.service.type";
	
	public static List<MilitaryServiceType> generate()	{
		List<MilitaryServiceType> militaryServiceTypes = new ArrayList<MilitaryServiceType>();
		militaryServiceTypes.add(new MilitaryServiceType(1, MilitaryServices.ALREADY_SERVED, true));
		militaryServiceTypes.add(new MilitaryServiceType(2, MilitaryServices.LIABLE, true));
		militaryServiceTypes.add(new MilitaryServiceType(3, MilitaryServices.NON_LIABLE, true));
		return militaryServiceTypes;
	}
}
