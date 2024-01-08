package queue;

public class App {

	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<>();
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		System.out.println(queue.size());
		System.out.println("We have removed this:" + queue.dequeue());
		System.out.println(queue.size());
		System.out.println(queue.peek());
	}

}
