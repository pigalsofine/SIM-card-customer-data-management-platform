package entity;

import java.security.Timestamp;

public class Customer {
	private String nameString;
	private String accountString;
	private String phoneString;
	private Integer idInteger;
	public Integer getIdInteger() {
		return idInteger;
	}
	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAccountString() {
		return accountString;
	}
	public void setAccountString(String accountString) {
		this.accountString = accountString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	
}
