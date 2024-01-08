package stacks;
import java.util.Queue;
import java.util.Stack;

public class MaxStack {

	public static void main(String[] args) {
		Stack<Integer> enqueueStack = new Stack<>();
		Stack<Integer> dequeueStack = new Stack<>();
		
		
		Stack<Integer> nums = new Stack<>();
		Stack<Integer> maxNum = new Stack<>();
		int[] randomNum = {1,5,3,6,4,8,23,1,4};
		for(int i = 0; i < randomNum.length; i++) {
			nums.push(randomNum[i]);
			if(maxNum.isEmpty()) {
				maxNum.push(randomNum[i]);
			}else if(maxNum.peek() < randomNum[i]) {
				maxNum.push(randomNum[i]);
			}else {
				maxNum.push(maxNum.peek());
			}
		}
		System.out.println(maxNum.peek());
		
	}

}
