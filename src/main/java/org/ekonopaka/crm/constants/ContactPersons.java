package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.ContactPersonType;

public class ContactPersons {

	public static final String WIFE_HUSBAND = "label.wife.husband.contact.person.type";
	public static final String BOYFRIEND_GIRLFRIEND = "label.boyfriend.girlfriend.contact.person.type";
	public static final String MOTHER_FATHER = "label.father.mother.contact.person.type";
	public static final String GRANDMOTHER_GRANDFATHER = "label.grandfather.grandmother.contact.person.type";
	public static final String SON_DAUGHTER = "label.son.daughter.contact.person.type";
	public static final String BROTHER_SISTER = "label.brother.sister.contact.person.type";
	public static final String RELATIVE = "label.relative.husband.contact.person.type";
	public static final String FRIEND = "label.friend.husband.contact.person.type";
	public static final String FAMILIAR = "label.familiar.husband.contact.person.type";
	public static final String EMPLOYEE = "label.employee.husband.contact.person.type";
	public static final String HEAD = "label.head.husband.contact.person.type";
	public static final String NIGHBOR = "label.neighbor.husband.contact.person.type";
	public static final String OTHER = "label.other.husband.contact.person.type";
	
	public static List<ContactPersonType> generate()	{
		List<ContactPersonType> contactPersonTypes = new ArrayList<ContactPersonType>();
		contactPersonTypes.add(new ContactPersonType(1, ContactPersons.WIFE_HUSBAND, true));
		contactPersonTypes.add(new ContactPersonType(2, ContactPersons.BOYFRIEND_GIRLFRIEND, true));
		contactPersonTypes.add(new ContactPersonType(3, ContactPersons.MOTHER_FATHER, true));
		contactPersonTypes.add(new ContactPersonType(4, ContactPersons.GRANDMOTHER_GRANDFATHER, true));
		contactPersonTypes.add(new ContactPersonType(5, ContactPersons.SON_DAUGHTER, true));
		contactPersonTypes.add(new ContactPersonType(6, ContactPersons.BROTHER_SISTER, true));
		contactPersonTypes.add(new ContactPersonType(7, ContactPersons.RELATIVE, true));
		contactPersonTypes.add(new ContactPersonType(8, ContactPersons.FRIEND, true));
		contactPersonTypes.add(new ContactPersonType(9, ContactPersons.FAMILIAR, true));
		contactPersonTypes.add(new ContactPersonType(10, ContactPersons.EMPLOYEE, true));
		contactPersonTypes.add(new ContactPersonType(11, ContactPersons.HEAD, true));
		contactPersonTypes.add(new ContactPersonType(12, ContactPersons.NIGHBOR, true));
		contactPersonTypes.add(new ContactPersonType(13, ContactPersons.OTHER, true));
		return contactPersonTypes;
	}
}
