package entity;

import java.security.Timestamp;

public class Card {
	private String numberString;
	private String card_idString;
	private String ICCID;
	private String IMSI;
	private Integer statusInteger;
	private String tagString;
	private String start_timeString;
	private String billing_timeString;
	private Integer billing_cycleInteger;
	public String getNumberString() {
		return numberString;
	}
	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}
	public String getCard_idString() {
		return card_idString;
	}
	public void setCard_idString(String card_idString) {
		this.card_idString = card_idString;
	}
	public String getICCID() {
		return ICCID;
	}
	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}
	public String getIMSI() {
		return IMSI;
	}
	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}
	public Integer getStatusInteger() {
		return statusInteger;
	}
	public void setStatusInteger(Integer statusInteger) {
		this.statusInteger = statusInteger;
	}
	public String getTagString() {
		return tagString;
	}
	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
	public String getStart_timeString() {
		return start_timeString;
	}
	public void setStart_timeString(String start_timeString) {
		this.start_timeString = start_timeString;
	}
	public String getBilling_timeString() {
		return billing_timeString;
	}
	public void setBilling_timeString(String billing_timeString) {
		this.billing_timeString = billing_timeString;
	}
	public Integer getBilling_cycleInteger() {
		return billing_cycleInteger;
	}
	public void setBilling_cycleInteger(Integer billing_cycleInteger) {
		this.billing_cycleInteger = billing_cycleInteger;
	}
	public String getPacket_nameString() {
		return packet_nameString;
	}
	public void setPacket_nameString(String packet_nameString) {
		this.packet_nameString = packet_nameString;
	}
	public Float getFlow_usedFloat() {
		return flow_usedFloat;
	}
	public void setFlow_usedFloat(Float flow_usedFloat) {
		this.flow_usedFloat = flow_usedFloat;
	}
	public Float getFlow_totalFloat() {
		return flow_totalFloat;
	}
	public void setFlow_totalFloat(Float flow_totalFloat) {
		this.flow_totalFloat = flow_totalFloat;
	}
	public Float getRechargeFloat() {
		return rechargeFloat;
	}
	public void setRechargeFloat(Float rechargeFloat) {
		this.rechargeFloat = rechargeFloat;
	}
	public Float getOverangeFloat() {
		return overangeFloat;
	}
	public void setOverangeFloat(Float overangeFloat) {
		this.overangeFloat = overangeFloat;
	}
	public String getIpString() {
		return ipString;
	}
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	public String getDomainString() {
		return domainString;
	}
	public void setDomainString(String domainString) {
		this.domainString = domainString;
	}
	public String getCustomerString() {
		return customerString;
	}
	public void setCustomerString(String customerString) {
		this.customerString = customerString;
	}
	public String getOwnerString() {
		return ownerString;
	}
	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}
	public String getOperatorString() {
		return operatorString;
	}
	public void setOperatorString(String operatorString) {
		this.operatorString = operatorString;
	}
	private String packet_nameString;
	private Float flow_usedFloat;
	private Float flow_totalFloat;
	private Float rechargeFloat;
	private Float overangeFloat;
	private String ipString;
	private String domainString;
	private String customerString;
	private String ownerString;
	private String operatorString;
}
