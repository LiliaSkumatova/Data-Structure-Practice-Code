package stacks;

public class Stack<T> {
	private T[] stack;
	private int count;
	public Stack() {
		stack = (T[]) new Object[1];
		
	}
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		--count;
		T item = stack[count];
		stack[count] = null;
		
		//might have to resize
		if(count > 0 &&count == stack.length/4) {
			resize(stack.length/2);
		}
		return item;
	}
	public boolean isEmpty() {
		return count == 0;
	}
	//we just have to add the new item to the end of the array 0(1)
	public void push(T newData) {
		//ARRAYS ARE NOT DUNAMIC DATA STRUCTURES !!!
		//we have to resize the underlying array if necessary
		//if there are too many items: we double the size of the array
		//if there are too few items: then we decrease (shrink) the array
		if(count == stack.length) {
			resize(2*count);
		}
		stack[count++] = newData;
		
	}
	
	private void resize(int capacity) {
		T[] stackCopy = (T[]) new Object[capacity];
		//copy items one by one
		for(int i = 0; i<count;i++) {
			stackCopy[i] = stack[i];
		}
		stack = stackCopy;
	}

}
