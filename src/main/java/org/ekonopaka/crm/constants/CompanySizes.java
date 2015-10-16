package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.CompanySizeType;

public class CompanySizes {

	public static final String SMALL = "label.small.company.size.type";
	public static final String MIDDLE = "label.middle.company.size.type";
	public static final String LARGE = "label.large.company.size.type";
	
	public static List<CompanySizeType> generate()	{
		List<CompanySizeType> companySizes = new ArrayList<CompanySizeType>();
		companySizes.add(new CompanySizeType(1, CompanySizes.SMALL, true));
		companySizes.add(new CompanySizeType(2, CompanySizes.MIDDLE, true));
		companySizes.add(new CompanySizeType(3, CompanySizes.LARGE, true));
		return companySizes;
	}
}
