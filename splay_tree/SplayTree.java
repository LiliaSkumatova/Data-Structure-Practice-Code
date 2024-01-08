package splay_tree;


public class SplayTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	@Override
	public void insert(T data) {
		if(root==null) {
			root = new Node<T>(data, null);
		}else {
			insert(data, root);
		}
	}
	

	@Override
	public T getRoot() {
		if(root == null) {
			return null;
		}
		return root.getData();
	}
	public void insert(T data, Node<T> node) {
		if(node.getData().compareTo(data) > 0) {
			if(node.getLeftChild() != null) {
				insert(data, node.getLeftChild());
			}else {
				Node<T> newNode = new Node<>(data, node);
				node.setLeftChild(newNode);
//				splay(newNode);
			}
		}else {
			if(node.getRightChild() != null) {
				insert(data, node.getRightChild());
			}else {
				Node<T> newNode = new Node<>(data, node);
				node.setRightChild(newNode);
				//checking violations
//				splay(newNode);
			}
		}
	}

	//this is when we make rotations on the new node to become the root node;
	private void splay(Node<T> node) {
		//while the node is not the root node
		while(node.getParentNode() != null) {
			//if the grandparent is null it means we have to make a simple rotation
			//zig situation
			if(node.getParentNode().getParentNode() == null) {
				//if the node is the left child of the root then right rotate on the root
				if(node.getParentNode().getLeftChild() == node) {
					rightRotation(node.getParentNode());
				//if the node is the right child of the root then left rotate on the root
				}else {
					leftRotation(node.getParentNode());
				}
				//zig-zig situation
			}else if(node.getParentNode().getLeftChild()== node 
					&& node.getParentNode().getParentNode().getLeftChild() == node.getParentNode()) {
				rightRotation(node.getParentNode().getParentNode());
				rightRotation(node.getParentNode());
			}else if(node.getParentNode().getRightChild()== node 
					&& node.getParentNode().getParentNode().getRightChild() == node.getParentNode()) {
				leftRotation(node.getParentNode().getParentNode());
				leftRotation(node.getParentNode());
			//zig-zag situation
			}else if(node.getParentNode().getLeftChild()== node 
					&& node.getParentNode().getParentNode().getRightChild() == node.getParentNode()) {
				rightRotation(node.getParentNode());
				leftRotation(node.getParentNode());
			}else {
				leftRotation(node.getParentNode());
				rightRotation(node.getParentNode());
			}
		}
		
	}
	
	@Override
	public T find(T data) {
		if(root == null) {
			return null;
		}
		return find(data, root);
	}
	
	private T find(T data, Node<T> node) {
		//this is when we look for a given item in the tree
		if(data.compareTo(node.getData()) < 0) {
			find(data, node.getLeftChild());
		}else if(data.compareTo(node.getData()) > 0) {
			find(data, node.getRightChild());
		}else {
			//we have found the item we looking for
			splay(node);
			return data;
		}
		return null;
	}

	@Override
	public void traverse() {

		if(root != null) {
			traverse(root);
		}
		
	}

	private void traverse(Node<T> node) {
		if(node.getLeftChild() != null) {
			traverse(node.getLeftChild());
		}
		System.out.print(node + " - ");
		
		if(node.getRightChild() != null) {
			traverse(node.getRightChild());
		}
		
	}
	private void rightRotation(Node<T> node) {
		System.out.println("Rotating right on node " + node);
		 Node<T> tempLeftChild = node.getLeftChild();
		 Node<T> grandChild = tempLeftChild.getRightChild();
		 
		 tempLeftChild.setRightChild(node);
		 node.setLeftChild(grandChild);
		 
		 if(grandChild != null) {
			 grandChild.setParentNode(node);
		 }
		 
		 //we have to handle the parents for the node
		 Node<T> tempParent = node.getParentNode();
		 node.setParentNode(tempLeftChild);
		 tempLeftChild.setParentNode(tempParent);
		 
		 //we have to handle the parent
		 if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
			 tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
		 }
		 if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
			 tempLeftChild.getParentNode().setRightChild(tempLeftChild);
		 }
		 //no parent after rotation
		 if(node == root) {
			 root = tempLeftChild;
		 }
		 
	}
	
	private void leftRotation(Node<T> node) {
		System.out.println("Rotating left on node " + node);
		 Node<T> tempRightChild = node.getRightChild();
		 Node<T> grandChild = tempRightChild.getLeftChild();
		 
		 tempRightChild.setLeftChild(node);
		 node.setRightChild(grandChild);
		 
		 if(grandChild != null) {
			 grandChild.setParentNode(node);
		 }
		 
		 //we have to handle the parents for the node
		 Node<T> tempParent = node.getParentNode();
		 node.setParentNode(tempRightChild);
		 tempRightChild.setParentNode(tempParent);
		 
		 //we have to handle the parent
		 if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
			 tempRightChild.getParentNode().setLeftChild(tempRightChild);
		 }
		 if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
			 tempRightChild.getParentNode().setRightChild(tempRightChild);
		 }
		 //no parent after rotation
		 if(node == root) {
			 root = tempRightChild;
		 }
		 
	}

}
