package avl_tree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(data, null);
		} else {
			insert(data, root);
		}
	}

	public void insert(T data, Node<T> root) {
		if (root.getData().compareTo(data) > 0) {
			if (root.getLeftChild() == null) {

				root.setLeftChild(new Node<>(data, root));
			} else {
				insert(data, root.getLeftChild());
			}
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(new Node<>(data, root));
			} else {
				insert(data, root.getRightChild());
			}

		}
		
		//settle the violation
		updateHeight(root);
		settleViolations(root);
	}

	@Override
	public void remove(T data) {
		// check if we have root
		// remove
		if (root != null) {
			remove(data, root);
		}

	}

	private void remove(T data, Node<T> node) {

		if (node != null) {
			if (data.compareTo(node.getData()) < 0) {
				remove(data, node.getLeftChild());
			} else if (data.compareTo(node.getData()) > 0) {
				remove(data, node.getRightChild());
			} else {
				// found item we want to remove
				// 3 cases of removal
				// first case if node is a leaf
				if (node.getLeftChild() == null && node.getRightChild() == null) {
					System.out.println("Removing a leaf ...");
					Node<T> parent = node.getParentNode();
					if (parent != null && parent.getLeftChild() == node) {
						parent.setLeftChild(null);
					} else if (parent != null && parent.getRightChild() == node) {
						parent.setRightChild(null);
					}
					// if we want to delete the root and the tree is only made up of a root
					if (parent == null) {
						root = null;
					}
					node = null;
					
					updateHeight(parent);
					settleViolations(parent);
				} else if (node.getLeftChild() == null && node.getRightChild() != null) {
					System.out.println("Removing a node with single right child ...");
					Node<T> parent = node.getParentNode();
					if (parent != null && parent.getLeftChild() == node) {
						parent.setLeftChild(node.getRightChild());
					} else if (parent != null && parent.getRightChild() == node) {
						parent.setRightChild(node.getRightChild());
					}
					if (parent == null) {
						root = node.getRightChild();
					}
					node.getRightChild().setParentNode(parent);
					node = null;
					updateHeight(parent);
					settleViolations(parent);
					
				} else if (node.getLeftChild() != null && node.getRightChild() == null) {
					System.out.println("Removing a node with single left child ...");
					Node<T> parent = node.getParentNode();
					if (parent != null && parent.getLeftChild() == node) {
						parent.setLeftChild(node.getLeftChild());
					} else if (parent != null && parent.getRightChild() == node) {
						parent.setRightChild(node.getLeftChild());
					}
					if (parent == null) {
						root = node.getLeftChild();
					}
					node.getLeftChild().setParentNode(parent);
					node = null;

					updateHeight(parent);
					settleViolations(parent);
				} else {
					System.out.println("Removing a node with 2 children ...");
					Node<T> predecessor = getPredecessor(node.getLeftChild());
					T temp = predecessor.getData();
					predecessor.setData(node.getData());
					node.setData(temp);

					remove(data, predecessor);
					
				}

			}
		}
		
		//settle the violations
	}

	private Node<T> getPredecessor(Node<T> node) {
		if (node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		return node;
	}

	@Override
	public void traversal() {

		// in-order traversal in O(N) linear running time
		// visit left subtree of the binary tree then the root node
		// and finally the right subtree in a recursive manner
		if (root == null) {
			return;
		}
		traversal(root);
	}

	private void traversal(Node<T> node) {
		if (node.getLeftChild() != null) {
			traversal(node.getLeftChild());
		}
		System.out.print(node + " - ");

		if (node.getRightChild() != null) {
			traversal(node.getRightChild());
		}
	}
	
	private void settleViolations(Node<T> node) {
		//we have to check up to the root node
		//0(logN)
		while(node != null) {
			updateHeight(node);
			settleViolationsHelper(node);
			node = node.getParentNode();
		}
	}
	
	private void settleViolationsHelper(Node<T> node) {
		int balance = getBalance(node);
		
		//Ok, we know that the tree is left Heavy but it can be left-right or left-left
		if(balance > 1) {
			if(getBalance(node.getLeftChild()) < 0) {
				leftRotation(node.getLeftChild());
			}
			//this is the right rotation
			rightRotation(node);
		}
		if(balance < -1) {
			if(getBalance(node.getRightChild()) > 0) {
				rightRotation(node.getRightChild());
			}
			//this is the right rotation
			leftRotation(node);
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
		 
		 updateHeight(node);
		 updateHeight(tempLeftChild);
		 
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
		 
		 updateHeight(node);
		 updateHeight(tempRightChild);
		 
	}
	
	private void updateHeight(Node<T> node) {
		node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild()))+1);
	}
	
	private int height(Node<T> node) {
		if(node == null) return -1;
		return node.getHeight();
	}
	
	private int getBalance(Node<T> node) {
		if(node == null) return 0;
		
		return height(node.getLeftChild()) - height(node.getRightChild());
	}



	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}


}
