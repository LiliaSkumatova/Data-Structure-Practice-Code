package doubly_linkedList;


public class LinkedList<T extends Comparable<T>> implements List<T> {

	private int numOfItems;
	private Node<T> head;
	private Node<T> tail;
	@Override
	public void insert(T data) {
		Node<T> newNode = new Node<>(data);
		if(tail == null) {
			tail = newNode;
			head = newNode;
		}else {
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
		}
		
	}
	@Override
	public void insertStart(T data) {
		Node<T> newNode = new Node<>(data);
		if(tail == null) {
			tail = newNode;
			head = newNode;
		}else {
			newNode.setNextNode(head);
			head.setPreviousNode(newNode);
			head = newNode;
		}
		
	}
	

	@Override
	public void remove(T data) {}
	
	private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
		//find the node we want to remove
		while(actualNode != null) {
			//this is the node we want to remove
			if(actualNode.getData().compareTo(data)==0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}

	public void getMiddle() {
		Node<T> fast = head;
		Node<T> slow = head;
		while(fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
			
		}
		System.out.println(slow.getData());
	}
	public void findMiddle() {
		if(head != null && tail != null) {
			Node<T> leftPointer = head;
			Node<T> rightPointer = tail;
//			while(leftPointer.getData() != rightPointer.getData() && 
//					leftPointer.getNextNode().getData() 
//					!= rightPointer.getPreviousNode().getData()) {
////				if(leftPointer.getNextNode() == rightPointer) {
////					break;
////				}
//				leftPointer = leftPointer.getNextNode();
//				rightPointer = rightPointer.getPreviousNode();
//			}
			while(leftPointer.getData() != rightPointer.getData() 
					&& leftPointer.getNextNode() != rightPointer ) {
				leftPointer = leftPointer.getNextNode();
				rightPointer = rightPointer.getPreviousNode();
			}
			System.out.println(rightPointer);
		}
		
		
	}
	@Override
	public void traverseForward() {
		Node<T> actualNode = head;
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}

	}
	
	@Override
	public void traverseBackward() {
		Node<T> actualNode = tail;
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getPreviousNode();
		}

	}
	
	@Override
	public int size() {
		return numOfItems;
	}

}
