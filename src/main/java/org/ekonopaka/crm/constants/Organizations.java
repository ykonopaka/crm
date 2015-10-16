package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.OrganizationType;

public class Organizations {

	public static final String AT = "label.at.organization.type";
	public static final String PAT = "label.pat.organization.type";
	public static final String PRAT = "label.prat.organization.type";
	public static final String TOV = "label.tov.organization.type";
	public static final String ZAT = "label.zat.organization.type";
	public static final String PP = "label.pp.organization.type";
	public static final String FOP = "label.fop.organization.type";
	public static final String SP = "label.sp.organization.type";
	public static final String DERZHP = "label.derzhp.organization.type";
	public static final String DOCHP = "label.dochP.organization.type";
	public static final String IP = "label.ip.organization.type";
	public static final String KP = "label.kp.organization.type";
	public static final String FG = "label.fg.organization.type";
	
	public static List<OrganizationType> generate()	{
		List<OrganizationType> organizationTypes = new ArrayList<OrganizationType>();
		organizationTypes.add(new OrganizationType(1, Organizations.AT, true));
		organizationTypes.add(new OrganizationType(2, Organizations.PAT, true));
		organizationTypes.add(new OrganizationType(3, Organizations.PRAT, true));
		organizationTypes.add(new OrganizationType(4, Organizations.TOV, true));
		organizationTypes.add(new OrganizationType(5, Organizations.ZAT, true));
		organizationTypes.add(new OrganizationType(6, Organizations.PP, true));
		organizationTypes.add(new OrganizationType(7, Organizations.FOP, true));
		organizationTypes.add(new OrganizationType(8, Organizations.SP, true));
		organizationTypes.add(new OrganizationType(9, Organizations.DERZHP, true));
		organizationTypes.add(new OrganizationType(10, Organizations.DOCHP, true));
		organizationTypes.add(new OrganizationType(11, Organizations.IP, true));
		organizationTypes.add(new OrganizationType(12, Organizations.KP, true));
		organizationTypes.add(new OrganizationType(13, Organizations.FG, true));
		return organizationTypes;
	}
}
