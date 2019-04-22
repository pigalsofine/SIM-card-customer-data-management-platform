package entity;

import java.security.Timestamp;

public class Contract {
	private String part_aString;
	private String part_bString;
	private String timeString;
	private String nameString;
	private String contextString;
	public String getPart_aString() {
		return part_aString;
	}
	public void setPart_aString(String part_aString) {
		this.part_aString = part_aString;
	}
	public String getPart_bString() {
		return part_bString;
	}
	public void setPart_bString(String part_bString) {
		this.part_bString = part_bString;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getContextString() {
		return contextString;
	}
	public void setContextString(String contextString) {
		this.contextString = contextString;
	}
}
