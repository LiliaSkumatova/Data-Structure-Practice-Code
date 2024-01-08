package QueueWithStacks;

import java.util.Stack;

public class OneStackQueue {

	private Stack<Integer> stack;
	public OneStackQueue() {
		this.stack = new Stack<>();
	}
	public void enqueue(int item) {
		this.stack.push(item);
	}
	public int dequeue() {
		if(stack.size() == 1) {
			return stack.pop();
		}
		
		int item = stack.pop();
		
		int lastDequeueItem = dequeue();
		enqueue(item);
		return lastDequeueItem;
	}
}
