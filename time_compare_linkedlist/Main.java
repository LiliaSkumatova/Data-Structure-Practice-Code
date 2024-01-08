package time_compare_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		long now = System.currentTimeMillis();
		for(int i = 0; i <50000; i++) {
			array.add(0, i);
			System.out.println(i);
		}
		System.out.println("time taken for ArrayList: " 
		+ (System.currentTimeMillis() - now));
		
		LinkedList<Integer> list = new LinkedList<>();
		now = System.currentTimeMillis();
		for(int j = 0; j<50000;j++) {
			list.addFirst(j);
		}
		System.out.println("Time taken for linkedList: " 
		+ (System.currentTimeMillis() - now));
	}

}