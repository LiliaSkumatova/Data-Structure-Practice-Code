package hashtable_linear_probing;

public class HashTable {

	private static final int TABLE_SIZE = 10;
	private HashItem[] hashTable;
	///it tracks the number of key-value pairs already stored in the table
	private int counter;
	
	public HashTable() {
		hashTable = new HashItem[TABLE_SIZE];
	}
	
	public int get(int key) {
		int index = hash(key);
		
		//linear probing
		while(hashTable[index] != null && hashTable[index].getKey() != key) {
			index = (index+1)% TABLE_SIZE;
			System.out.println("Incrementing the index: " + index);
		}
		//search miss
		if(hashTable[index] == null){
			return -1;
		}
		return hashTable[index].getValue();
	}
	
	public void put(int key, int value) {
		if(counter >= TABLE_SIZE) {
			return;
		}
		
		int index = hash(key);
		//COLLISION
		//until we do not find an empty slot(null) we keep generating
		//the next index 
		while(hashTable[index] != null) {
			index = (index +1)%TABLE_SIZE;
			System.out.println("Incrementing the index: " + index);
		}
		//we have found a valid index (with empty array bucket) for the item
		hashTable[index] = new HashItem(key, value);
		
		counter++;
	}
	//it transforms the key into an index of the underlying array
	//prime numbers
	private int hash(int key) {
		return key%TABLE_SIZE;
	}
}
