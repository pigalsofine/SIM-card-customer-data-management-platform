package entity;

import java.security.Timestamp;

public class Tag {
	private String nameString;
	private Integer typeInteger;
	private Integer permissionInteger;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Integer getTypeInteger() {
		return typeInteger;
	}
	public void setTypeInteger(Integer typeInteger) {
		this.typeInteger = typeInteger;
	}
	public Integer getPermissionInteger() {
		return permissionInteger;
	}
	public void setPermissionInteger(Integer permissionInteger) {
		this.permissionInteger = permissionInteger;
	}
}
