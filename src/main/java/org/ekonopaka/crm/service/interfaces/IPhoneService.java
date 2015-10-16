package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;

public interface IPhoneService {

	public PhoneNumber getNewPhoneNumber();
	
	public void addPhoneNumber(PhoneNumber phoneNumber);

	public void deletePhoneNumber(PhoneNumber phoneNumber);

	public List<PhoneNumber> getPhoneNumbers();
	
	public List<PhoneNumber> getPhoneNumbers(Office office);

	public PhoneNumber getPhoneNumberById(int id);

	public void updatePhoneNumber(PhoneNumber phoneNumber);
}
