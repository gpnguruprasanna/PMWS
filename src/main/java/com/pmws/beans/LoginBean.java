package com.pmws.beans;
/**
 *@author guruprasanna n
 */
public class LoginBean extends ResponseBean<LoginBean>{
	private Long userId;
	private String username="";
	private String pwd="";
	private String clientId="";
	protected String responseStatus="";
	protected String responseMsg="";
	protected String errorCode="";
	private String loginType="";
	private String targetUrl;
	private String password="";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
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
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
