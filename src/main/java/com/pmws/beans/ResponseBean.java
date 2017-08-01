package com.pmws.beans;
/**
 *@author guruprasanna n
 */
import java.util.ArrayList;
import java.util.List;

public abstract class ResponseBean<T> {
	protected String responseStatus="";
	protected String responseMsg="";
	protected String errorCode="";
	protected String responseClass="";
	protected String errorDesc="";
	protected String action="";
	protected List<T> bList=new ArrayList<T>();
	protected List<String> listOfErrorDesc=new ArrayList<String>();

	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getResponseClass() {
		return responseClass;
	}
	public void setResponseClass(String responseClass) {
		this.responseClass = responseClass;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<T> getbList() {
		return bList;
	}
	public void setbList(List<T> bList) {
		this.bList = bList;
	}
	public List<String> getListOfErrorDesc() {
		return listOfErrorDesc;
	}
	public void setListOfErrorDesc(List<String> listOfErrorDesc) {
		this.listOfErrorDesc = listOfErrorDesc;
	}

}
