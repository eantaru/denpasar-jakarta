package retailwebsite;

import java.util.Date;

import retailwebsite.entity.Employee;
import retailwebsite.entity.Item;
import retailwebsite.entity.User;
import retailwebsite.entity.UserType;
import retailwebsite.storage.EmployeeStorage;
import retailwebsite.storage.UserStorage;

public class Retail {
	
	public Retail() {
//		setupEmployee();
//		setupUser();
	}
	
	private void setupEmployee() {
		EmployeeStorage.instance().addNewEmployee(new Employee.Builder()
								.id(1)
								.name("User 1")
								.build());
	}
	
	private void setupUser() {
		User user1 = new User.Builder()
				.id(10)
				.name("User 1")
				.employeeId(1)
				.build();

		User user2 = new User.Builder()
				.id(20)
				.name("User 2")
				.userType(UserType.AFFILIATE)
				.build();
		
		User user3 = new User.Builder()
				.id(30)
				.name("User 3")
				.created(1451001600000L) // 25 dec 2015
				.build();

		
		User user4 = new User.Builder()
				.id(40)
				.name("User 4")
				.created(1566000000000L) // 17 aug 2019
				.build();
		
		UserStorage.instance()
					.addNewUser(user1)
					.addNewUser(user2)
					.addNewUser(user3)
					.addNewUser(user4);
	}

	public static void main(String[] args) {
		// demo usage
		Retail retail = new Retail();
		retail.setupEmployee();
		retail.setupUser();
		
		User user1 = UserStorage.instance().getUser(10);
		
		Bill bill1 = new Bill(user1);
		bill1.addItem(new Item.Builder()
				.id(1)
				.name("soap")
				.price(1.59f)
				.build());
		bill1.addItem(new Item.Builder()
				.id(2)
				.name("tshirt")
				.price(12.99f)
				.build());
		bill1.addItem(new Item.Builder()
				.id(3)
				.name("burger")
				.groceries(true)
				.price(10.59f)
				.build());
		bill1.addItem(new Item.Builder()
				.id(4)
				.name("soft drink")
				.groceries(true)
				.price(2.59f)
				.build());
		bill1.addItem(new Item.Builder()
				.id(5)
				.name("htc-m7")
				.price(112.59f)
				.build());
		
		float totalBill1 = bill1.sum();
		System.out.println(String.format("total bill-1: USD %.2f", totalBill1));
	}
	
}
