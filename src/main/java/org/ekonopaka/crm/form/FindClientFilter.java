package org.ekonopaka.crm.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FindClientFilter {

	@Size(min=5, max=30)
	@Pattern(regexp = "([a-zA-Z0-9\\u0430-\\u044F\\u0410-\\u042F\\s])*")
	String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
