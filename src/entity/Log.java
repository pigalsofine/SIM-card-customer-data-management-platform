package entity;

import java.security.Timestamp;

public class Log {
	private String usernameString;
	private String operateString;
	private String timeString;
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public String getOperateString() {
		return operateString;
	}
	public void setOperateString(String operateString) {
		this.operateString = operateString;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
}
