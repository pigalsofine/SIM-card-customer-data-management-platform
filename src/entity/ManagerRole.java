package entity;

import java.security.Timestamp;

public class ManagerRole {
	private String name;
	private String add_time;
	private String permission;
	private String desprition;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String string) {
		this.add_time = string;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getDesprition() {
		return desprition;
	}
	public void setDesprition(String desprition) {
		this.desprition = desprition;
	}
	
}
