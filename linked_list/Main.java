package linked_list;

public class Main {

	public static void main(String[] args) {

//		LinkedList<String> names = new LinkedList<>();
//		names.insert("Adam");
//		names.insert("Daniel");
//		names.insert("Ana");
//		
//		names.traverse();
//		System.out.println();
//		names.remove("Daniel");
//		names.traverse();
		
//		LinkedList<Person> people = new LinkedList<>();
//		Person p = new Person(23, "Adam");
//		people.insert(p);
//		people.insert(new Person(34, "Daniel"));
//		people.insert(new Person(54, "Adam"));
//		people.insert(new Person(56, "Michale"));
//		
//		people.traverse();
//		System.out.println();
//		people.remove(p);
//		people.traverse();
		
		LinkedList<Integer> nums = new LinkedList<>();
		nums.insert(1);
		nums.insert(2);
		nums.insert(3);
		nums.insert(4);
		nums.traverse();
		nums.reverse();
		nums.traverse();
	}

}
