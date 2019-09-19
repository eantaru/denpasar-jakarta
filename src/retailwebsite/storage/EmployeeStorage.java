package retailwebsite.storage;

import java.util.HashMap;
import java.util.Map;

import retailwebsite.entity.Employee;

public class EmployeeStorage {

	private Map<Integer, Employee> storage;
	
	private static EmployeeStorage self;
	
	public static EmployeeStorage instance() {
		if(self == null) {
			self = new EmployeeStorage();
		}
		
		return self;
	}
	
	private EmployeeStorage() {
		storage = new HashMap<Integer, Employee>();
	}
	
	public void addNewEmployee(Employee employee) {
		storage.put(employee.getId(), employee);
	}
	
	public Employee getEmployee(int id) {
		if(isExist(id)) {
			return storage.get(id);
		}
		
		return null;
	}
	
	public boolean isExist(int id) {
		return storage.containsKey(id);
	}
}
