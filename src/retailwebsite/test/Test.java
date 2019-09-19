package retailwebsite.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import retailwebsite.Bill;
import retailwebsite.entity.Employee;
import retailwebsite.entity.Item;
import retailwebsite.entity.User;
import retailwebsite.entity.UserType;
import retailwebsite.storage.EmployeeStorage;
import retailwebsite.storage.UserStorage;

public class Test {
	
	@BeforeClass
	public static void setupStorage() {
		EmployeeStorage.instance().addNewEmployee(new Employee.Builder()
								.id(1)
								.name("User 1")
								.build());
		
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
	
	@org.junit.Test
	public void testUserIsEmployee() {
		User user = UserStorage.instance().getUser(10);
		
		Bill bill = new Bill(user);
		bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
		bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
		bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		
		System.out.print(String.format("USD %.2f", bill.sum()));
		
		float expectedResult = 56f;
		assertEquals(expectedResult, bill.sum(), 0.01f);
	}

	@org.junit.Test
	public void testUserIsAffiliate() {
		User user = UserStorage.instance().getUser(20);
		
		Bill bill = new Bill(user);
		bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
		bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
		bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		
		float expectedResult = 62f;
		assertEquals(expectedResult, bill.sum(), 0.01f);
	}

	@org.junit.Test
	public void testUserIsOver2Years() {

		User user = UserStorage.instance().getUser(30);
		
		Bill bill = new Bill(user);
		bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
		bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
		bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		
		float expectedResult = 63.5f;
		assertEquals(expectedResult, bill.sum(), 0.01f);
	}

	@org.junit.Test
	public void testBillLessThan100() {
		User user = UserStorage.instance().getUser(40);
		
		Bill bill = new Bill(user);
		bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
		bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
		bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		
		float expectedResult = 65f;
		assertEquals(expectedResult, bill.sum(), 0.01f);
	}

	@org.junit.Test
	public void testBillOver100() {
		User user = UserStorage.instance().getUser(40);
		
		Bill bill = new Bill(user);
		bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
		bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
		bill.addItem(new Item.Builder()
				.price(510f)
				.name("Macboo-Pro 13\" Retina")
				.build());
		bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		bill.addItem(new Item.Builder()
				.price(25f)
				.groceries(true)
				.name("Doughnat")
				.build());
		bill.addItem(new Item.Builder()
				.price(75f)
				.groceries(true)
				.name("Side Country Duck, Balinese")
				.build());
		
		float expectedResult = 650f;
		assertEquals(expectedResult, bill.sum(), 0.01f);
	}

}
