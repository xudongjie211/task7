package com.jnshu.util.alismsUtil;


public class AlismsBean {
	private String accessKeyId;
    private String accessKeySecret;
    private String SignName;
    private String TemplateCode;
    private String ConnectTimeout;
    private String ReadTimeout;
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getSignName() {
		return SignName;
	}
	public void setSignName(String signName) {
		SignName = signName;
	}
	public String getTemplateCode() {
		return TemplateCode;
	}
	public void setTemplateCode(String templateCode) {
		TemplateCode = templateCode;
	}
	public String getConnectTimeout() {
		return ConnectTimeout;
	}
	public void setConnectTimeout(String connectTimeout) {
		ConnectTimeout = connectTimeout;
	}
	public String getReadTimeout() {
		return ReadTimeout;
	}
	public void setReadTimeout(String readTimeout) {
		ReadTimeout = readTimeout;
	}
	
	
}
