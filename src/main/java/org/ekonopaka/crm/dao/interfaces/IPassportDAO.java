package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.Passport;

public interface IPassportDAO {

	public Passport getPassport(int id);

	public void updatePassport(Passport passport);

	public void addPassport(Passport passport);

	public void deletePassport(Passport passport);

}
