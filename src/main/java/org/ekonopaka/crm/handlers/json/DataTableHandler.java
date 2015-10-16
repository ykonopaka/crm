package org.ekonopaka.crm.handlers.json;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class DataTableHandler {

	DataTableRequest dataTableRequest;
	DataTableResponse dataTableResponse;

	public DataTableHandler(HttpServletRequest request) {
		dataTableRequest = new DataTableRequest(request);
		dataTableResponse = new DataTableResponse();
		dataTableResponse.setsEcho(dataTableRequest.getsEcho());
	}

	public String getResponse() {
		Gson gson = new Gson();

		return gson.toJson(dataTableResponse);
	}

	public void setData(String[][] data) {
		dataTableResponse.setAaData(data);
	}

	public DataTableRequest getDataTableRequest() {
		return dataTableRequest;
	}

	public void setDataTableRequest(DataTableRequest dataTableRequest) {
		this.dataTableRequest = dataTableRequest;
	}

	public DataTableResponse getDataTableResponse() {
		return dataTableResponse;
	}

	public void setDataTableResponse(DataTableResponse dataTableResponse) {
		this.dataTableResponse = dataTableResponse;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		dataTableResponse.setiTotalDisplayRecords(iTotalDisplayRecords);
	}

	public void setiTotalRecords(int iTotalRecords) {
		dataTableResponse.setiTotalRecords(iTotalRecords);
	}
}
