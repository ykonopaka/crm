package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.InfoSourceType;

public class InfoSources {

	public static final String NEWSPAPER = "label.newspaper.source.type";
	public static final String STREAM_STICK = "label.stream.stick.source.type";
	public static final String RADIO = "label.radio.source.type";
	public static final String TV = "label.tv.source.type";
	public static final String RECOMMENDATION = "label.recommendation.source.type"; 
	public static final String BILLBOARD = "label.billboard.source.type";
	public static final String OUTDOOR_AD = "label.outdoor.ad.source.type";
	public static final String OTHER_AD = "label.other.source.type";
	
	public static List<InfoSourceType> generate()	{
		List<InfoSourceType> infoSourceTypes = new ArrayList<InfoSourceType>();
		infoSourceTypes.add(new InfoSourceType(1, InfoSources.NEWSPAPER, true));
		infoSourceTypes.add(new InfoSourceType(2, InfoSources.STREAM_STICK, true));
		infoSourceTypes.add(new InfoSourceType(3, InfoSources.RADIO, true));
		infoSourceTypes.add(new InfoSourceType(4, InfoSources.TV, true));
		infoSourceTypes.add(new InfoSourceType(5, InfoSources.RECOMMENDATION, true));
		infoSourceTypes.add(new InfoSourceType(6, InfoSources.BILLBOARD, true));
		infoSourceTypes.add(new InfoSourceType(7, InfoSources.OUTDOOR_AD, true));
		infoSourceTypes.add(new InfoSourceType(8, InfoSources.OTHER_AD, true));
		return infoSourceTypes;
	}
}
