package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.Passport;

public interface IPassportService {

	public Passport getPassport(int id);

	public void updatePassport(Passport passport);

	public void addPassport(Passport passport);

	public void deletePassport(Passport passport);
	
	public Passport createNewPassport();
}
