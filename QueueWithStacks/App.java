package QueueWithStacks;

public class App {

	public static void main(String[] args) {
		OneStackQueue newQ = new OneStackQueue();
		newQ.enqueue(1);
		newQ.enqueue(2);
		newQ.enqueue(3);
		newQ.enqueue(4);
		newQ.enqueue(5);
		newQ.enqueue(6);
		System.out.println(newQ.dequeue());
	}

}
