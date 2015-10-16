package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.BusinessLineType;

public class BusinessLines {

		public static final String LAW_AGENCIES = "label.law.business.line.type";
		public static final String PERSONAL = "label.personal.services.business.line.type";
		public static final String HOUSING = "label.housing.business.line.type";
		public static final String RESTAURANTS = "label.restaurants.business.line.type";
		public static final String FINANCE = "label.finance.business.line.type";
		public static final String BROKERAGE = "label.brokerage.business.line.type";
		public static final String ENGINEERING = "label.engineering.business.line.type";
		public static final String ENTERTAINMENT = "label.entertainment.business.line.type";
		public static final String NOTARIAL = "label.legal.business.line.type";
		public static final String CHEMICALS = "label.chemicals.business.line.type";
		public static final String FARMING = "label.farming.business.line.type";
		public static final String ARMED_FORCES = "label.forces.business.line.type";
		public static final String LIGHT_INDUSTRY = "label.light.industry.business.line.type";
		public static final String FOOD = "label.food.business.line.type";
		public static final String CONSTRUCTION = "label.construction.business.line.type";
		public static final String BEAUTY_SHOPS = "label.fitness.business.line.type";
		public static final String ART = "label.art.business.line.type";
		public static final String PRINTING = "label.printing.business.line.type";
		public static final String IT = "label.information.business.line.type";
		public static final String SECURITY = "label.security.business.line.type";
		public static final String PUBLISHING = "label.publishing.business.line.type";
		public static final String HEALTH = "label.health.business.line.type";
		public static final String PUBLIC = "label.public.business.line.type";
		public static final String FOREST = "label.forest.business.line.type";
		public static final String TRANSPORT = "label.transport.business.line.type";
		public static final String WHOLESALE = "label.wholesale.business.line.type"; 
		public static final String RETAIL = "label.retail.business.line.type";
		public static final String SCIENCE = "label.science.business.line.type";
		public static final String PR = "label.advertising.business.line.type";
		public static final String ENERGY = "label.energy.business.line.type";
		public static final String COMMUNICATION = "label.relationship.business.line.type";
		public static final String OTHER = "label.other.business.line.type";
		
		public static List<BusinessLineType> generate()	{
			List<BusinessLineType> businessLineTypes = new ArrayList<BusinessLineType>();
			businessLineTypes.add(new BusinessLineType(1, BusinessLines.ARMED_FORCES, true));
			businessLineTypes.add(new BusinessLineType(2, BusinessLines.ART, true));
			businessLineTypes.add(new BusinessLineType(3, BusinessLines.BEAUTY_SHOPS, true));
			businessLineTypes.add(new BusinessLineType(4, BusinessLines.BROKERAGE, true));
			businessLineTypes.add(new BusinessLineType(5, BusinessLines.CHEMICALS, true));
			businessLineTypes.add(new BusinessLineType(6, BusinessLines.COMMUNICATION, true));
			businessLineTypes.add(new BusinessLineType(7, BusinessLines.CONSTRUCTION, true));
			businessLineTypes.add(new BusinessLineType(8, BusinessLines.ENERGY, true));
			businessLineTypes.add(new BusinessLineType(9, BusinessLines.ENGINEERING, true));
			businessLineTypes.add(new BusinessLineType(10, BusinessLines.ENTERTAINMENT, true));
			businessLineTypes.add(new BusinessLineType(11, BusinessLines.FARMING, true));
			businessLineTypes.add(new BusinessLineType(12, BusinessLines.FINANCE, true));
			businessLineTypes.add(new BusinessLineType(13, BusinessLines.FOOD, true));
			businessLineTypes.add(new BusinessLineType(14, BusinessLines.FOREST, true));
			businessLineTypes.add(new BusinessLineType(15, BusinessLines.HEALTH, true));
			businessLineTypes.add(new BusinessLineType(16, BusinessLines.HOUSING, true));
			businessLineTypes.add(new BusinessLineType(17, BusinessLines.IT, true));
			businessLineTypes.add(new BusinessLineType(18, BusinessLines.LAW_AGENCIES, true));
			businessLineTypes.add(new BusinessLineType(19, BusinessLines.LIGHT_INDUSTRY, true));
			businessLineTypes.add(new BusinessLineType(20, BusinessLines.NOTARIAL, true));
			businessLineTypes.add(new BusinessLineType(21, BusinessLines.PERSONAL, true));
			businessLineTypes.add(new BusinessLineType(22, BusinessLines.PR, true));
			businessLineTypes.add(new BusinessLineType(23, BusinessLines.PRINTING, true));
			businessLineTypes.add(new BusinessLineType(24, BusinessLines.PUBLIC, true));
			businessLineTypes.add(new BusinessLineType(25, BusinessLines.PUBLISHING, true));
			businessLineTypes.add(new BusinessLineType(26, BusinessLines.RESTAURANTS, true));
			businessLineTypes.add(new BusinessLineType(27, BusinessLines.RETAIL, true));
			businessLineTypes.add(new BusinessLineType(28, BusinessLines.SCIENCE, true));
			businessLineTypes.add(new BusinessLineType(29, BusinessLines.SECURITY, true));
			businessLineTypes.add(new BusinessLineType(30, BusinessLines.TRANSPORT, true));
			businessLineTypes.add(new BusinessLineType(31, BusinessLines.WHOLESALE, true));
			businessLineTypes.add(new BusinessLineType(32, BusinessLines.OTHER, true));
			return businessLineTypes;
		}
}
