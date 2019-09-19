package retailwebsite.entity;

public class Employee {
	
	private final int id;
	private String name;
	
	private Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public static class Builder {
		
		private int id;
		private String name;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Employee build() {
			return new Employee(id, name);
		}
	}
}
