package org.ekonopaka.crm.controllers.typeeditors;

import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.service.interfaces.IRoleService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

public class RolesListTypeEditor extends CustomCollectionEditor {

	IRoleService roleService;

	public RolesListTypeEditor(
			@SuppressWarnings("rawtypes") Class collectionType) {
		super(collectionType);
	}

	public RolesListTypeEditor(
			@SuppressWarnings("rawtypes") Class collectionType,
			IRoleService roleService) {
		super(collectionType);
		this.roleService = roleService;
	}

	@Override
	protected Object convertElement(Object element) {
		Role role = roleService.getRoleByAuthority((String) element);
		return role;
	}
}
