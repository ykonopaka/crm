package org.ekonopaka.crm.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ekonopaka.crm.constants.BusinessLines;
import org.ekonopaka.crm.constants.CompanySizes;
import org.ekonopaka.crm.constants.ContactPersons;
import org.ekonopaka.crm.constants.Convictions;
import org.ekonopaka.crm.constants.CreditForms;
import org.ekonopaka.crm.constants.CreditObjectives;
import org.ekonopaka.crm.constants.Credits;
import org.ekonopaka.crm.constants.Currencies;
import org.ekonopaka.crm.constants.DealStates;
import org.ekonopaka.crm.constants.DealWorkflowSideTypes;
import org.ekonopaka.crm.constants.DealWorkflowStates;
import org.ekonopaka.crm.constants.Educations;
import org.ekonopaka.crm.constants.Employments;
import org.ekonopaka.crm.constants.Genders;
import org.ekonopaka.crm.constants.Incomes;
import org.ekonopaka.crm.constants.InfoSources;
import org.ekonopaka.crm.constants.Interests;
import org.ekonopaka.crm.constants.Jobs;
import org.ekonopaka.crm.constants.MaritalStatuses;
import org.ekonopaka.crm.constants.MilitaryServices;
import org.ekonopaka.crm.constants.Organizations;
import org.ekonopaka.crm.constants.Positions;
import org.ekonopaka.crm.constants.Properties;
import org.ekonopaka.crm.constants.PropertyHistories;
import org.ekonopaka.crm.constants.Regions;
import org.ekonopaka.crm.init.Configuration;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.ContactPersonType;
import org.ekonopaka.crm.model.types.ConvictionType;
import org.ekonopaka.crm.model.types.CreditFormType;
import org.ekonopaka.crm.model.types.CreditObjectiveType;
import org.ekonopaka.crm.model.types.CreditType;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;
import org.ekonopaka.crm.model.types.EducationType;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.model.types.GenderType;
import org.ekonopaka.crm.model.types.IncomeType;
import org.ekonopaka.crm.model.types.InfoSourceType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.MaritalStatusType;
import org.ekonopaka.crm.model.types.MilitaryServiceType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.ekonopaka.crm.model.types.PositionType;
import org.ekonopaka.crm.model.types.PropertyType;
import org.ekonopaka.crm.model.types.RegionType;

import com.thoughtworks.xstream.XStream;

public class InitExample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		XStream xStream = new XStream();
		xStream.alias("infoSourceType", InfoSourceType.class);
		xStream.alias("employmentType", EmploymentType.class);
		xStream.alias("businessLineType", BusinessLineType.class);
		xStream.alias("companySizeType", CompanySizeType.class);
		xStream.alias("contactPersonType", ContactPersonType.class);
		xStream.alias("convictionType", ConvictionType.class);
		xStream.alias("creditObjectiveType", CreditObjectiveType.class);
		xStream.alias("educationType", EducationType.class);
		xStream.alias("genderType", GenderType.class);
		xStream.alias("incomeType", IncomeType.class);
		xStream.alias("jobType", JobType.class);
		xStream.alias("maritalStatusType", MaritalStatusType.class);
		xStream.alias("militaryServiceType", MilitaryServiceType.class);
		xStream.alias("organizationType", OrganizationType.class);
		xStream.alias("positionType", PositionType.class);
		xStream.alias("propertyType", PropertyType.class);
		xStream.alias("regionType", RegionType.class);
		xStream.alias("creditFormType", CreditFormType.class);
		xStream.alias("dealStateType", DealStateType.class);
		xStream.alias("dealWorkflowSideType", DealWorkflowSideType.class);
		xStream.alias("dealWorkflowType", DealWorkflowType.class);
		
		xStream.alias("user", User.class);
		xStream.alias("role", Role.class);
		xStream.alias("infoSource", InfoSource.class);
		xStream.alias("configuration", Configuration.class);
		xStream.alias("creditType", CreditType.class);
		xStream.alias("credit", Credit.class);
		xStream.alias("client", Client.class);
		xStream.alias("office", Office.class);
		xStream.alias("phoneNumber", PhoneNumber.class);
		xStream.alias("client", Client.class);
		
		Configuration conf = new Configuration();
		
		Office office1 = new Office();
		office1.setName("Office 1");
		office1.setAddress("Address 1");
		office1.setIsEnabled(true);
		office1.setDescription("Office 1 Description");
		
		Office office2 = new Office();
		office2.setName("Office 2");
		office2.setAddress("Address 2");
		office2.setIsEnabled(true);
		office2.setDescription("Office 2 Description");
		
		PhoneNumber number1 = new PhoneNumber();
		number1.setDescription("Main office phone number");
		number1.setPhoneNumber("048394631");
		number1.setIsMobile(false);
		number1.setOffice(office1);
		
		PhoneNumber number2 = new PhoneNumber();
		number2.setDescription("Main office phone number 2");
		number2.setPhoneNumber("048394632");
		number2.setIsMobile(false);
		number2.setOffice(office1);
		
		PhoneNumber number3 = new PhoneNumber();
		number3.setDescription("My mobile phone");
		number3.setPhoneNumber("+380674870555");
		number3.setIsMobile(true);
		number3.setOffice(office2);
		
		PhoneNumber number4 = new PhoneNumber();
		number4.setDescription("My mobile phone 2");
		number4.setPhoneNumber("+380674870557");
		number4.setIsMobile(true);
		number4.setOffice(office2);
		
		conf.addOffice(office1);
		conf.addOffice(office2);
		
		conf.addPhoneNumber(number1);
		conf.addPhoneNumber(number2);
		conf.addPhoneNumber(number3);
		conf.addPhoneNumber(number4);
		
		Role roleAdmin = new Role();
		roleAdmin.setAuthority(Role.ADMIN);
		roleAdmin.setCode("label.administrator.role");
		roleAdmin.setIsAdmin(true);
		
		Role roleOperator = new Role();
		roleOperator.setAuthority(Role.OPERATOR);
		roleOperator.setCode("label.operator.role");
		roleOperator.setIsAdmin(false);
		
		Role roleCoordinator = new Role();
		roleCoordinator.setAuthority(Role.COORDINATOR);
		roleCoordinator.setCode("label.coordinator.role");
		roleCoordinator.setIsAdmin(false);
		
		List<Role> allRoles = new ArrayList<Role>();
		allRoles.add(roleAdmin);
		allRoles.add(roleOperator);
		allRoles.add(roleCoordinator);
		
		conf.setRoles(allRoles);

		List<Role> rolesAdmin = new ArrayList<Role>();
		rolesAdmin.add(roleAdmin);
		
		List<Role> rolesOperator = new ArrayList<Role>();
		rolesOperator.add(roleOperator);
		
		List<Role> rolesCoordinator = new ArrayList<Role>();
		rolesCoordinator.add(roleCoordinator);
		
		User userAdmin = new User();
		userAdmin.setUsername(User.ADMIN_USERNAME);
		userAdmin.setPassword(User.ADMIN_DEFAULT_PASSWORD);
		userAdmin.setEmail("ykonopaka@gmail.com");
		userAdmin.setCreationDate(new Date());
		userAdmin.setIsEnabled(true);
		userAdmin.setFirstName("Administrator");
		userAdmin.setLastName("Administrator");
		userAdmin.setRoles(rolesAdmin);
		userAdmin.setOffice(office1);
		
		User userOper = new User();
		userOper.setUsername("oper");
		userOper.setPassword("oper");
		userOper.setEmail("ekonopaka@lohika.com");
		userOper.setCreationDate(new Date());
		userOper.setIsEnabled(true);
		userOper.setFirstName("Operator");
		userOper.setLastName("Operator");
		userOper.setRoles(rolesOperator);
		userOper.setOffice(office1);
		
		User userCoord = new User();
		userCoord.setUsername("coord");
		userCoord.setPassword("coord");
		userCoord.setEmail("ykonopaka@lohika.com");
		userCoord.setCreationDate(new Date());
		userCoord.setIsEnabled(true);
		userCoord.setFirstName("Coordinator");
		userCoord.setLastName("Coordinator");
		userCoord.setRoles(rolesCoordinator);
		userCoord.setOffice(office1);
		
		conf.addUser(userAdmin);
		conf.addUser(userOper);
		conf.addUser(userCoord);
		
		conf.setBusinessLineTypes(BusinessLines.generate());
		conf.setCompanySizeTypes(CompanySizes.generate());
		conf.setContactPersonTypes(ContactPersons.generate());
		conf.setConvictionTypes(Convictions.generate());
		conf.setCreditObjectiveTypes(CreditObjectives.generate());
		conf.setCreditTypes(Credits.generate());
		conf.setEducationTypes(Educations.generate());
		conf.setEmploymentTypes(Employments.generate());
		conf.setGenderTypes(Genders.generate());
		conf.setIncomeTypes(Incomes.generate());
		conf.setInfoSourceTypes(InfoSources.generate());
		conf.setJobTypes(Jobs.generate());
		conf.setMaritalStatusTypes(MaritalStatuses.generate());
		conf.setMilitaryServiceTypes(MilitaryServices.generate());
		conf.setOrganizationTypes(Organizations.generate());
		conf.setPositionTypes(Positions.generate());
		conf.setPropertyHistoryTypes(PropertyHistories.generate());
		conf.setPropertyTypes(Properties.generate());
		conf.setRegionTypes(Regions.generate());
		conf.setCreditFormTypes(CreditForms.generate());
		conf.setCurrencyTypes(Currencies.generate());
		conf.setInterestTypes(Interests.generate());
		conf.setDealStateTypes(DealStates.generate());
		conf.setDealWorkflowSideTypes(DealWorkflowSideTypes.generate());
		conf.setDealWorkflowTypes(DealWorkflowStates.generate());
		
		InfoSource defaultSource = new InfoSource();
		defaultSource.setInfoSourceType(conf.getInfoSourceTypes().get(0));
		defaultSource.setIsEnabled(true);
		defaultSource.setDetails("Some details");
		
		conf.addInfoSource(defaultSource);
		
		System.out.println(xStream.toXML(conf));
		
/*		String xml = readFile("src/main/resources/init.xml");
		
		User user = (User)xStream.fromXML(xml);
		
		System.out.println();*/

	}
	
	@SuppressWarnings("unused")
	private static String readFile(String path) throws IOException {
		  FileInputStream stream = new FileInputStream(new File(path));
		  try {
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    return Charset.defaultCharset().decode(bb).toString();
		  }
		  finally {
		    stream.close();
		  }
		}

}
