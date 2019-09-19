package retailwebsite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retailwebsite.entity.Item;
import retailwebsite.entity.User;
import retailwebsite.entity.UserType;
import retailwebsite.storage.EmployeeStorage;

public class Bill {

	private List<Item> items;
	private final User user;
	private final Calendar calendar;
	
	public Bill(User user) {
		this.user = user;
		items = new ArrayList<Item>();
		
		calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2); // 2 year ago from today
	}

	// add item on bill
	public void addItem(Item item) {
		items.add(item);
	}
	
	public float sum() {
		float total = 0;
		float groceries = 0;
		
		// add price groceries and non groceries
		for(Item item : items) {
			if(item.isGroceries()) {
				groceries += item.getPrice();
			}
			else {
				total += item.getPrice();
			}
		}
		
		
		return getTotalWithDiscount(total) + groceries;
	}
	
	// calculate price with discount if can apply
	private float getTotalWithDiscount(float total) {
		
		// check if user employee of its retail base on user-type
		// set user-type to normal if not exist
		if(user.getUserType() == UserType.EMPLOYEE && 
				!EmployeeStorage.instance().isExist(user.getEmployeeId())) {
			user.setUserType(UserType.NORMAL);
		}
		
		Discount discount = null;
		// prioritized the most highest discount regulation
		if(user.getUserType() == UserType.EMPLOYEE) {
			discount = new EmployeeDiscount();
		}
		else if(user.getUserType() == UserType.AFFILIATE) {
			discount = new AffiliateDiscount();
		}
		else if(user.getCreated().before(calendar.getTime())) {
			discount = new GoldDiscount();
		}
		else if(total >= 100) {
			int disc = (int) (total / 100d) * 5;
			
			return total - disc;
		}
		
		if(discount != null) {
			total = total - total * discount.getDiscount();
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Bill [items=" + items + ", user=" + user + ", calendar=" + calendar + "]";
	}
}
