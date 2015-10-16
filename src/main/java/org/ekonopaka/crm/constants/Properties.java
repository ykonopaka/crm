package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.PropertyType;

public class Properties {

	public static final String OWNER = "label.owner.property.type";
	public static final String LEASE = "label.lease.property.type";
	public static final String SERVICE_AREA = "label.service.area.property.type";
	public static final String LIVING_WITH_PARENTS = "label.living.with.parents.property.type";
	public static final String LIVING_IN_HALL = "label.living.in.hall.property.type";
	
	public static List<PropertyType> generate()	{
		List<PropertyType> propertyTypes = new ArrayList<PropertyType>();
		propertyTypes.add(new PropertyType(1, Properties.OWNER, true, true));
		propertyTypes.add(new PropertyType(2, Properties.LEASE, true, true));
		propertyTypes.add(new PropertyType(3, Properties.SERVICE_AREA, true, false));
		propertyTypes.add(new PropertyType(4, Properties.LIVING_WITH_PARENTS, true, false));
		propertyTypes.add(new PropertyType(5, Properties.LIVING_IN_HALL, true, false));
		return propertyTypes;
	}
}
