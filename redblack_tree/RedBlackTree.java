package redblack_tree;


public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		if(root==null) {
			root = new Node<T>(data, null);
			settleViolations(root);
		}else {
			insert(data, root);
		}
	}
	public void insert(T data, Node<T> node) {
		if(node.getData().compareTo(data) > 0) { //
			if(node.getLeftChild() != null) {
				insert(data, node.getLeftChild());
			}else {
				Node<T> newNode = new Node<>(data, node);
				node.setLeftChild(newNode);
				settleViolations(newNode);
			}
		}else {
			if(node.getRightChild() != null) {
				insert(data, node.getRightChild());
			}else {
				Node<T> newNode = new Node<>(data, node);
				node.setRightChild(newNode);
				//checking violations
				settleViolations(newNode);
			}
		}
	}
	
	@Override
	public void remove(T data) {
		//check if we have root
		//remove
		if(root != null) {
			remove(data, root);
		}
		
	}

	private void remove(T data, Node<T> node) {

		if(node != null) {
			if(data.compareTo(node.getData()) < 0) {
				remove(data, node.getLeftChild());
			}else if(data.compareTo(node.getData()) > 0) {
				remove(data, node.getRightChild());
			}else {
				//found item we want to remove
				//3 cases of removal 
				//first case if node is a leaf
				if(node.getLeftChild() == null && node.getRightChild() == null) {
					System.out.println("Removing a leaf ...");
					Node<T> parent = node.getParentNode();
					if(parent != null && parent.getLeftChild()  == node) {
						parent.setLeftChild(null);
					}else if(parent != null && parent.getRightChild() == node) {
						parent.setRightChild(null);
					}
					//if we want to delete the root and the tree is only made up of a root
					if(parent == null) {
						root = null;
					}
					node = null;
				}else if(node.getLeftChild() == null && node.getRightChild() != null) {
					System.out.println("Removing a node with single right child ...");
					Node<T> parent = node.getParentNode();
					if(parent != null && parent.getLeftChild()  == node) {
						parent.setLeftChild(node.getRightChild());
					}else if(parent != null && parent.getRightChild() == node) {
						parent.setRightChild(node.getRightChild());
					}
					if(parent == null) {
						root = node.getRightChild();
					}
					node.getRightChild().setParentNode(parent);
					node = null;
				}else if(node.getLeftChild() != null && node.getRightChild() == null) {
					System.out.println("Removing a node with single left child ...");
					Node<T> parent = node.getParentNode();
					if(parent != null && parent.getLeftChild()  == node) {
						parent.setLeftChild(node.getLeftChild());
					}else if(parent != null && parent.getRightChild() == node) {
						parent.setRightChild(node.getLeftChild());
					}
					if(parent == null) {
						root = node.getLeftChild();
					}
					node.getLeftChild().setParentNode(parent);
					node = null;
				
			}else {
				System.out.println("Removing a node with 2 children ...");
				Node<T> predecessor = getPredecessor(node.getLeftChild());
				T temp = predecessor.getData();
				predecessor.setData(node.getData());
				node.setData(temp);
				
				remove(data, predecessor);
			}
				
			}
		}
	}
	private void settleViolations(Node<T> node) {
		Node<T> parentNode = null;
		Node<T> grandParentNode = null;
		//we have to check violations up to the root node
		while(node != root && isRed(node) && isRed(node.getParentNode())) {
			parentNode = node.getParentNode();
			grandParentNode = node.getParentNode().getParentNode();
			//parent is a left child of its parent (so grandparent)
			if(parentNode == grandParentNode.getLeftChild()) {
				Node<T> uncle = grandParentNode.getRightChild();
				
				//case 1 and case 4 Recolor
				if(uncle != null && isRed(uncle)) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				}else {
					//case 2
					if(node == parentNode.getRightChild()) {
						leftRotation(parentNode);
						//update the references we keep going up to the root node
						node = parentNode;
						parentNode = grandParentNode;
					}
					//case3 rotation on the grandparent + parent and grandparent switch color
					rightRotation(grandParentNode);
					System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
					//swap the color of the parent and grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					//update the references because we keep going to the root node
					node = parentNode;
				}
			}else {
				//parent is a right child of it's parent (so the grandparent)
				Node<T> uncle = grandParentNode.getLeftChild();
				//case 1 and case 4 Recolor
				if(uncle != null && isRed(uncle)) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				}else {
					//case 2 symmetric partner
					if(node == parentNode.getLeftChild()) {
						rightRotation(parentNode);
						//update the references we keep going up to the root node
						node = parentNode;
						parentNode = grandParentNode;
					}
					//case 3 
					leftRotation(grandParentNode);
					System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
					//swap the color of the parent and grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					//update the references because we keep going to the root node
					node = parentNode;
				}
			}
			
		}//end while
		//root node cannot be Red
		if(isRed(root)) {
			System.out.println("Recoloring the root to black... ");
			root.setColor(NodeColor.BLACK);
		}
	}
	private boolean isRed(Node<T> node) {
		if(node == null) {
			return false;
		}
		return node.getColor() == NodeColor.RED;
	}
	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		return node;
	}

	@Override
	public void traversal() {

		if(root != null) {
			traversal(root);
		}
		
	}
	private void traversal(Node<T> node) {
		if(node.getLeftChild() != null) {
			traversal(node.getLeftChild());
		}
		System.out.print(node + " - ");
		
		if(node.getRightChild() != null) {
			traversal(node.getRightChild());
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
