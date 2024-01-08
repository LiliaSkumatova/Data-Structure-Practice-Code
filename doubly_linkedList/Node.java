package doubly_linkedList;

public class Node <T extends Comparable> {
	private T data;
	private Node<T> nextNode;
	private Node<T> previousNode;

	Node(T data){
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	
}
