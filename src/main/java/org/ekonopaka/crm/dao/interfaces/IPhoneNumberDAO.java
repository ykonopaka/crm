package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;

public interface IPhoneNumberDAO {

	public void addPhoneNumber(PhoneNumber phoneNumber);

	public void deletePhoneNumber(PhoneNumber phoneNumber);

	public List<PhoneNumber> getPhoneNumbers();
	
	public List<PhoneNumber> getPhoneNumbers(Office office);
	
	public PhoneNumber getPhoneNumber(int id);

	public void updatePhoneNumber(PhoneNumber phoneNumber);
}
