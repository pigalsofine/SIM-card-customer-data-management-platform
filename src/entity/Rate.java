package entity;

import java.security.Timestamp;

public class Rate {
	private String usernameString;
	private Float rateFloat;
	private String descriptionString;
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public Float getRateFloat() {
		return rateFloat;
	}
	public void setRateFloat(Float rateFloat) {
		this.rateFloat = rateFloat;
	}
	public String getDescriptionString() {
		return descriptionString;
	}
	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}
}
