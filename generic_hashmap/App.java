package generic_hashmap;

import java.util.Map;
import java.util.HashMap;

public class App {

	public static void main(String[] args) {

//		HashMap<String, Integer> hashTable = new HashMap<>();
//		hashTable.put("a", 1);
//		hashTable.put("b", 2);
//		System.out.println(hashTable.size());
//		hashTable.put("c", 3);
//		hashTable.put("d", 4);
//		hashTable.put("e", 5);
//		System.out.println(hashTable.size());
//		System.out.println(hashTable.get("c"));
//		hashTable.put("f", 6);
//		hashTable.put("g", 7);
//		hashTable.put("h", 8);
//		hashTable.put("i", 9);
//		hashTable.put("j", 10);
//		hashTable.put("k", 11);
		
		Map<Integer, String> map = new HashMap<>();
		//insert into the map O(1) if there is no collision
		map.put(1, "Adam");
		map.put(2, "Kevin");
		map.put(3, "Ana");
		map.put(40, "Lucy");
		//remove items in O(1)
		map.remove(2);
		//we can retrieve items based on keys O(1)
		//NULL keys
		//System.out.println(map.get(null));
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}
