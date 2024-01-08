package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(6);
		heap.insert(2);
		heap.insert(12);
		heap.insert(1);
//		Exercise exercise = new Exercise();
//		System.out.println(exercise.isMinHeap2(heap.getHeap()));
		int[] maxArray = {210, 100, 23, 2, 5};
		Exercise2 ex2 = new Exercise2(maxArray);
		int[] minArray = ex2.transform();
		for(int i = 0; i < minArray.length; i++) {
			System.out.println(minArray[i]);
		}
		
//		int[] minArray = {1,2,3,4,5};
//		System.out.println(exercise.isMinHeap2(minArray));
////		System.out.println(heap.getMax());
//		heap.insert(3);
//		heap.insert(8);
//		heap.insert(-5);
//		heap.heapSort();
		
//		Queue<Integer> heap = new PriorityQueue<>();
		//makes the queue a max heap using Collection.reverseOrder
//		Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
//		//O(logN)
//		heap.add(12);
//		heap.add(5);
//		heap.add(7);
//		heap.add(-2);
//		//O(N)
//		heap.contains(5);
//		//when we consider all N items in O(logN) = O(NlogN)
//		while(!heap.isEmpty()) {
//			//O(logN)
//			System.out.println(heap.poll());
//		}
		
//		Queue<Person> heapPerson = new PriorityQueue<>(Collections.reverseOrder());
//		heapPerson.add(new Person("Kevin",34 ));
//		heapPerson.add(new Person("Daniel",12));
//		heapPerson.add(new Person("Ana",67));
//		while(!heapPerson.isEmpty()) {
//			//O(logN)
//			System.out.println(heapPerson.poll());
//		}
	}

}
