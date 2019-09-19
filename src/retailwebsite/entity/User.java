package retailwebsite.entity;

import java.util.Date;

import retailwebsite.storage.EmployeeStorage;

public class User {

	private final int id; // will not change
	private String name;
	private @UserType int userType; // UserType.NORMAL as default
	private Date created;
	private int employeeId; // UserType.EMPLOYEE
	
	public User(int id, String name,  @UserType int userType, Date created, int employeeId) {
		this.id = id;
		this.name = name;
		this.userType = userType;
		this.created = created;
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userType=" + userType + ", created=" + created + ", employeeId="
				+ employeeId + "]";
	}

	public static class Builder {

		private int id;
		private String name;
		private  @UserType int userType = UserType.NORMAL;
		private Date created;
		private int employeeId;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder userType(@UserType int userType) {
			this.userType = userType;
			return this;
		}
		
		public Builder created(Date created) {
			this.created = created;
			return this;
		}
		
		public Builder created(long date) {
			this.created = new Date(date);
			return this;
		}
		
		public Builder employeeId(int employeeId) {
			this.employeeId = employeeId;
			this.userType = UserType.EMPLOYEE;
			return this;
		}
		
		public User build() {
			return new User(id, name, userType, created, employeeId);
		}
	}
}
