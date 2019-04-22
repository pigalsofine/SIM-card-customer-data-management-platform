package entity;

public class Report {
	private String nameString;
	private Integer typeInteger;
	public Integer getTypeInteger() {
		return typeInteger;
	}
	public void setTypeInteger(Integer typeInteger) {
		this.typeInteger = typeInteger;
	}
	private String time;
	private String contextString;
	private String contactString;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContextString() {
		return contextString;
	}
	public void setContextString(String contextString) {
		this.contextString = contextString;
	}
	public String getContactString() {
		return contactString;
	}
	public void setContactString(String contactString) {
		this.contactString = contactString;
	}
}
