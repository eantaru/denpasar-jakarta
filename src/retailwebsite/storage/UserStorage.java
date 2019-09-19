package retailwebsite.storage;

import java.util.HashMap;
import java.util.Map;

import retailwebsite.entity.User;

public class UserStorage {

	private Map<Integer, User> storage;
	
	private static UserStorage self;
	
	public static UserStorage instance() {
		if(self == null) {
			self = new UserStorage();
		}
		
		return self;
	}
	
	private UserStorage() {
		storage = new HashMap<Integer, User>();
	}
	
	public UserStorage addNewUser(User user) {
		storage.put(user.getId(), user);
		return this;
	}
	
	public User getUser(int id) {
		if(storage.containsKey(id)) {
			return storage.get(id);
		}
		
		return null;
	}
}
