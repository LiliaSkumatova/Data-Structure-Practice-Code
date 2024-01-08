package HashMapExample2;

import java.util.Objects;

public class Person {

	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//hashCode = hash-function
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		//hashCode = hash-function
		//it calculates an array index based on the key (keys == person objects)
		//avoid clustering with prime numbers
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//There some rules
	//1) if two objects are equal then they must have the same hash code
	//2) if two objects have the same hash code they may or may not be equal
	
	@Override
	//because in a hashmap it may happen collisions
	//that we have to find the item (Person) in linked list
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}
