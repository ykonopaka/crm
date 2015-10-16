package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.RegionType;

public class Regions {

	public static final String REGION_01 = "label.01.region.type";
	public static final String REGION_02 = "label.02.region.type";
	public static final String REGION_03 = "label.03.region.type";
	public static final String REGION_04 = "label.04.region.type";
	public static final String REGION_05 = "label.05.region.type";
	public static final String REGION_06 = "label.06.region.type";
	public static final String REGION_07 = "label.07.region.type";
	public static final String REGION_08 = "label.08.region.type";
	public static final String REGION_09 = "label.09.region.type";
	public static final String REGION_10 = "label.10.region.type";
	public static final String REGION_11 = "label.11.region.type";
	public static final String REGION_12 = "label.12.region.type";
	public static final String REGION_13 = "label.13.region.type";
	public static final String REGION_14 = "label.14.region.type";
	public static final String REGION_15 = "label.15.region.type";
	public static final String REGION_16 = "label.16.region.type";
	public static final String REGION_17 = "label.17.region.type";
	public static final String REGION_18 = "label.18.region.type";
	public static final String REGION_19 = "label.19.region.type";
	public static final String REGION_20 = "label.20.region.type";
	public static final String REGION_21 = "label.21.region.type";
	public static final String REGION_22 = "label.22.region.type";
	public static final String REGION_23 = "label.23.region.type";
	public static final String REGION_24 = "label.24.region.type";
	public static final String REGION_25 = "label.25.region.type";
	
	public static List<RegionType> generate()	{
		List<RegionType> regionTypes = new ArrayList<RegionType>();
		regionTypes.add(new RegionType(1, Regions.REGION_01, true));
		regionTypes.add(new RegionType(2, Regions.REGION_02, true));
		regionTypes.add(new RegionType(3, Regions.REGION_03, true));
		regionTypes.add(new RegionType(4, Regions.REGION_04, true));
		regionTypes.add(new RegionType(5, Regions.REGION_05, true));
		regionTypes.add(new RegionType(6, Regions.REGION_06, true));
		regionTypes.add(new RegionType(7, Regions.REGION_07, true));
		regionTypes.add(new RegionType(8, Regions.REGION_08, true));
		regionTypes.add(new RegionType(9, Regions.REGION_09, true));
		regionTypes.add(new RegionType(10, Regions.REGION_10, true));
		regionTypes.add(new RegionType(11, Regions.REGION_11, true));
		regionTypes.add(new RegionType(12, Regions.REGION_12, true));
		regionTypes.add(new RegionType(13, Regions.REGION_13, true));
		regionTypes.add(new RegionType(14, Regions.REGION_14, true));
		regionTypes.add(new RegionType(15, Regions.REGION_15, true));
		regionTypes.add(new RegionType(16, Regions.REGION_16, true));
		regionTypes.add(new RegionType(17, Regions.REGION_17, true));
		regionTypes.add(new RegionType(18, Regions.REGION_18, true));
		regionTypes.add(new RegionType(19, Regions.REGION_19, true));
		regionTypes.add(new RegionType(20, Regions.REGION_20, true));
		regionTypes.add(new RegionType(21, Regions.REGION_21, true));
		regionTypes.add(new RegionType(22, Regions.REGION_22, true));
		regionTypes.add(new RegionType(23, Regions.REGION_23, true));
		regionTypes.add(new RegionType(24, Regions.REGION_24, true));
		regionTypes.add(new RegionType(25, Regions.REGION_25, true));
		
		return regionTypes;
	}
}
