package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.CurrencyType;

public class Currencies {

	public static final String UAH = "label.uah.currency.type";
	public static final String USD = "label.usd.currency.type";
	public static final String EUR = "label.eur.currency.type";
	
	public static List<CurrencyType> generate()	{
		List<CurrencyType> currencyTypes = new ArrayList<CurrencyType>();
		currencyTypes.add(new CurrencyType(1, Currencies.UAH, true));
		currencyTypes.add(new CurrencyType(2, Currencies.USD, true));
		currencyTypes.add(new CurrencyType(3, Currencies.EUR, true));
		return currencyTypes;
	}
}
