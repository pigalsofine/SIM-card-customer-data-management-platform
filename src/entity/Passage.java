package entity;

import java.security.Timestamp;

public class Passage {
	private String nameString;
	private String operatorString;
	private String attrString;
	private String chinese_nameString;
	private String user_nameString;
	private String user_passwordString;
	private String keyString;
	private String addressString;
	private Float overageFloat;
	public Float getOverageFloat() {
		return overageFloat;
	}
	public void setOverageFloat(Float overageFloat) {
		this.overageFloat = overageFloat;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	private Boolean pollingBoolean;
	private String coverageString;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getOperatorString() {
		return operatorString;
	}
	public void setOperatorString(String operatorString) {
		this.operatorString = operatorString;
	}
	public String getAttrString() {
		return attrString;
	}
	public void setAttrString(String attrString) {
		this.attrString = attrString;
	}
	public String getChinese_nameString() {
		return chinese_nameString;
	}
	public void setChinese_nameString(String chinese_nameString) {
		this.chinese_nameString = chinese_nameString;
	}
	public String getUser_nameString() {
		return user_nameString;
	}
	public void setUser_nameString(String user_nameString) {
		this.user_nameString = user_nameString;
	}
	public String getUser_passwordString() {
		return user_passwordString;
	}
	public void setUser_passwordString(String user_passwordString) {
		this.user_passwordString = user_passwordString;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	public Boolean getPollingBoolean() {
		return pollingBoolean;
	}
	public void setPollingBoolean(Boolean pollingBoolean) {
		this.pollingBoolean = pollingBoolean;
	}
	public String getCoverageString() {
		return coverageString;
	}
	public void setCoverageString(String coverageString) {
		this.coverageString = coverageString;
	}

}
