package stacks;

import java.util.Stack;
//implementing queue by two stacks
public class Stackqueue {

	public static Stack<Integer> enqueueStack = new Stack<>();
	public static Stack<Integer> dequeueStack = new Stack<>();
	public static void main(String[] args) {
		
		int[] randomNum = {9,1,5,3,6};
		for(int num:randomNum) {
			enqueue(num);
		}
		System.out.println(dequeue());
	}
	private static int dequeue() {
		while(!enqueueStack.isEmpty()) {
			dequeueStack.push(enqueueStack.pop());
		}
		return dequeueStack.peek();
	}
	public static void enqueue(int num) {
			enqueueStack.push(num);
		
	}

}
