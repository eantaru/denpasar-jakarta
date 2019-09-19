package datastoreload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	private List<Map<String, String>> storage;
	
	public Solution() {
		storage = new ArrayList<Map<String,String>>();
	}
	
	// parse text based on newline '\n' as item and stored to Map before added into list storage
	public void store(String text) {
		String[] items = text.split("\n");
		
		for(String item : items) {			
			Map<String, String> map = convertToMap(item);
			storage.add(map);
		}
	}
	
	// convert text param into Map and grab all items on storage. 
	// make loop to check each list of storage
	// compare each list with Map key that converted before and insert into new list if key and value are equal
	public String[] load(String text) {
		String[] items = text.split("\n");
		
		List<String> loads = new ArrayList<>();
		
		for(String item : items) {			
			Map<String, String> map = convertToMap(item);
			
			Set<String> keys = map.keySet();
			
			for(Map<String, String> storage : this.storage) {
				for(String key : keys) {
					if(storage.containsKey(key) && map.get(key).equals(storage.get(key))) {
						String format = String.format("%s=%s", key, storage.get(key));
						loads.add(format);
					}
				}
			}
		}
		
		String[] list = new String[loads.size()];
		return loads.toArray(list);
	}
	
	public void print() {
		for(Map<?, ?> map : storage) {
			System.out.println(map);
		}
	}
	
	// capture key value pairs by eat the string until end of text
	private Map<String, String> convertToMap(String item) {
		Map<String, String> map = new HashMap<>();
		
		while(true) {
			String key = findKey(item);
			if(key != null) {
				item = cutText(item, key.length() + 1);
				
				String value = findValue(item);
				item = cutText(item, value.length() + 1);
				
				map.put(key, value);
			}
			
			if(key == null || "".equals(item)) {
				return map;
			}
		}
	}
	
	private String findKey(String text) {
		char token = '=';
		int end = text.indexOf(token);
		if(end > 0) {
			return text.substring(0, end);
		}
		
		return null;
	}
	
	private String findValue(String text) {
		char token = ';';
		int end = text.indexOf(token);
		if(end > 0) {
			return text.substring(0, end);
		}
		return text;
	}
	
	private String cutText(String text, int start) {
		if(start > text.length())
			return text;
		return text.substring(start);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.store("key&1=&value1;key2=value2;key3=value3\nkeyA=valueA");
		String[] list = s.load("\nkeyA=valueA;");
		
		for(String item : list) {
			System.out.println("load: " + item);
		}

	}
}
