package queue;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	public int size() {
		return this.count;
	}
	public void enqueue(T data) {
		count++;
		Node<T> oldLastNode =  this.lastNode;
		this.lastNode = new Node<>(data);
		if(isEmpty()) {
			this.firstNode = this.lastNode;
		}else {
			oldLastNode.setNextNode(this.lastNode);
		}
	}
	public T dequeue() {
		if(!isEmpty()) {
			count--;
			T dataToRemove = this.firstNode.getData();
			this.firstNode = this.firstNode.getNextNode();
			return dataToRemove;
		}
		return null;
		
	}
	public T peek() {
		if(!isEmpty()) {
			return this.firstNode.getData();
		}
		return null;
	}
}
