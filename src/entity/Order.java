package entity;

import java.security.Timestamp;

public class Order {
	private String customerString;
	private String card_idString;
	private Float amountFloat;
	private String submit_timeString;
	private String deal_timeString;
	private String packageString;
	public String getCustomerString() {
		return customerString;
	}
	public void setCustomerString(String customerString) {
		this.customerString = customerString;
	}
	public String getCard_idString() {
		return card_idString;
	}
	public void setCard_idString(String card_idString) {
		this.card_idString = card_idString;
	}
	public Float getAmountFloat() {
		return amountFloat;
	}
	public void setAmountFloat(Float amountFloat) {
		this.amountFloat = amountFloat;
	}
	public String getSubmit_timeString() {
		return submit_timeString;
	}
	public void setSubmit_timeString(String submit_timeString) {
		this.submit_timeString = submit_timeString;
	}
	public String getDeal_timeString() {
		return deal_timeString;
	}
	public void setDeal_timeString(String deal_timeString) {
		this.deal_timeString = deal_timeString;
	}
	public String getPackageString() {
		return packageString;
	}
	public void setPackageString(String packageString) {
		this.packageString = packageString;
	}
}
