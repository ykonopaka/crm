package org.ekonopaka.crm.handlers.json;

import java.util.Locale;

import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class OptionsColumnHandler {

	@Autowired
	MessageSource messageSource;

	private final String EDIT_LINK_TEMPLATE = "<a href=\"../edit/-object_type-/-object_type_id-\" class=\"icon-edit info-tooltip\" title=\"-edit_link-\"/>";
	private final String VIEW_LINK_TEMPLATE = "<a href=\"../view/-object_type-/-object_type_id-\" class=\"icon-view info-tooltip\" title=\"-view_link-\"/>";
	private final String DELETE_LINK_TEMPLATE = "<a href=\"../delete/-object_type-/-object_type_id-\" class=\"icon-delete info-tooltip\" title=\"-delete_link-\"/>";
	private final String CREATE_CALL_LINK_TEMPLATE = "<a href=\"../addcall/-object_type-/-object_type_id-/phone\" class=\"icon-call info-tooltip\" title=\"-create_call_link-\"/>";
	
	public String getClientsOptionsBlockAdmin(Client client, String viewCode, String editCode,
			String deleteCode, String createCallCode, Locale locale) {
		
		Integer id =  client.getId();
		String object_type = "client";

		String viewlink = messageSource.getMessage(viewCode, null, locale);
		String editlink = messageSource.getMessage(editCode, null, locale);
		String deletelink = messageSource.getMessage(deleteCode, null, locale);
		String createCallLink = messageSource.getMessage(createCallCode, null, locale);

		String viewBlock = VIEW_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-view_link-", viewlink);
		
		String editBlock = EDIT_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-edit_link-", editlink);

		String deleteBlock = DELETE_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-delete_link-", deletelink);
		
		String createCallBlock = CREATE_CALL_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-create_call_link-", createCallLink);

		return viewBlock + editBlock + deleteBlock + createCallBlock;
	}
	
	public String getClientsOptionsBlockOperator(Client client, String viewCode,
			String createCallCode, Locale locale) {
		
		Integer id =  client.getId();
		String object_type = "client";

		String viewlink = messageSource.getMessage(viewCode, null, locale);
		String createCallLink = messageSource.getMessage(createCallCode, null, locale);

		String viewBlock = VIEW_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-view_link-", viewlink);

		String createCallBlock = CREATE_CALL_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-create_call_link-", createCallLink);

		return viewBlock + createCallBlock;
	}
	
	public String getCallsOptionsBlockOwner(Call call, String viewCode, String editCode,
			String deleteCode, Locale locale) {
		Integer id = 0;
		String object_type = "call";
		id = call.getId();
		object_type = "call";
		
		String editlink = messageSource.getMessage(editCode, null, locale);
		String deletelink = messageSource.getMessage(deleteCode, null, locale);
		String viewlink = messageSource.getMessage(viewCode, null, locale);

		String editBlock = EDIT_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-edit_link-", editlink);

		String deleteBlock = DELETE_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-delete_link-", deletelink);
		
		String viewBlock = VIEW_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-view_link-", viewlink);
		
		return viewBlock + editBlock + deleteBlock;
	}
	
	public String getCallsOptionsBlockNotOwner(Call call, String viewCode, Locale locale) {
		Integer id = 0;
		String object_type = "call";
		id = call.getId();
		object_type = "call";
		
		String viewlink = messageSource.getMessage(viewCode, null, locale);

		String viewBlock = VIEW_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-view_link-", viewlink);
		
		return viewBlock;
	}
	
	public String getDealsOptionsBlockOwner(Deal deal, String editCode ,String deleteCode, Locale locale) {
		Integer id = 0;
		String object_type = "deal";
		id = deal.getId();
		
		String editlink = messageSource.getMessage(editCode, null, locale);
		String deletelink = messageSource.getMessage(deleteCode, null, locale);

		String editBlock = EDIT_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-edit_link-", editlink);
		
		String deleteBlock = DELETE_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-delete_link-", deletelink);
		
		return editBlock + deleteBlock;
	}
	
	public String getDealsOptionsBlockNotOwner(Deal deal, String viewCode, Locale locale) {
		Integer id = 0;
		String object_type = "deal";
		id = deal.getId();
		
		String viewlink = messageSource.getMessage(viewCode, null, locale);

		String viewBlock = VIEW_LINK_TEMPLATE
				.replaceAll("-object_type_id-", String.valueOf(id))
				.replaceAll("-object_type-", object_type)
				.replaceAll("-view_link-", viewlink);
		
		return viewBlock;
	}

}
