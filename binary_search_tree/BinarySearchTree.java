package binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		if(root==null) {
			root = new Node<T>(data, null);
		}else {
			insert(data, root);
		}
	}
	public void insert(T data, Node<T> root) {
		if(root.getData().compareTo(data) > 0) {
			if(root.getLeftChild() == null) {
				
				root.setLeftChild(new Node<>(data, root));
			}else {
				insert(data, root.getLeftChild());
			}
		}else {
			if(root.getRightChild() == null) {
				root.setRightChild(new Node<>(data, root));
			}else {
				insert(data, root.getRightChild());
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
	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		return node;
	}
	@Override
	public void traversal() {

		//in-order traversal in O(N) linear running time
		//visit left subtree of the binary tree then the root node
		//and finally the right subtree in a recursive manner
		if(root == null) {
			return;
		}
		traversal(root);
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

	@Override
	public T getMax() {
		if (root==null) {
			return null;
		}
		return getMax(root);
	}
	private T getMax(Node<T> node) {
		if(node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
	}
	//His implementation
	@Override
	public T getMin() {
		if (root==null) {
			return null;
		}
		return getMin(root);
	}
	private T getMin(Node<T> node) {
		if(node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}

	public int getSums() {
		return getAges(this.root);
	}
	
	private int getAges(Node<T> node) {
		System.out.println("Considering node" + node);
		int sum = 0;
		int leftSum = 0;
		int rightSum = 0;
		
		if(node == null) return 0;
		
		leftSum = getAges(node.getLeftChild());
		
		rightSum = getAges(node.getRightChild());
		
		System.out.println("Considering node " + node +" total ages so far is: " 
		+ (((Person) node.getData()).getAge() + leftSum + rightSum));
		
		sum = ((Person) node.getData()).getAge() + leftSum + rightSum;
		return sum;
	}
	
	public Node<T> getKSmallest(Node<T> node, int k){
		//number of nodes in the left subtree
		//+1 because we count the root node of the subtree as well
		int n = treeSize(node.getLeftChild())+1;
		
		//this is when we find the Kth smallest item
		if(n == k) {
			return node;
		}
		//if the number of node in the left subtree > Kth smallest item
		//It means the Kth smallest item is in the left subtree
		if(n>k) return getKSmallest(node.getLeftChild(), k);
		
		//if the number of node in the left subtree is smaller then kth
		//smallest item then we can discard the left subtree and consider the
		//right subtree
		//NOW we are not looking for the kth but the kth smallest item
		if(n<k) return getKSmallest(node.getRightChild(), k-n);
		
		return null;
	}
	//calculate the size of a subtree with root node 'node'
	public int treeSize(Node<T> node) {
		//this is the base case
		if(node==null) return 0;
		
		//recursively sum up the size of the left subtree + size of the right subtree
		//size of tree = size left subtree + size of right subtree + 1 (because of the root)
		return (treeSize(node.getLeftChild())+treeSize(node.getRightChild()) +1);
	}
	
	
public boolean isTreeSame(Node<T> node1, Node<T> node2) {
	//We have to check if there are two trees?
	//check if root both equal null or if both don't equal null return true
	boolean isEqual = true;
	if(node1 != null && node2 != null) {
		if(node1.getData().compareTo(node2.getData()) == 0) {
			System.out.println("Comparing left child. tree1: "+node1.getData() + " tree2: " + node2.getData());
			if(node1.getLeftChild() != null && node2.getLeftChild() != null) {
				
				isEqual = isTreeSame(node1.getLeftChild(), node2.getLeftChild());
			}
			if(!isEqual) {
				System.out.println("Comparing right child. tree1: "+node1.getData() + " tree2: " + node2.getData());

				if(node1.getRightChild() != null && node2.getRightChild() != null) {
					//checking right
					
					isEqual = isTreeSame(node1.getRightChild(), node2.getRightChild()) ;
				}	
			}
			
		}else {

			return false;
		}
	}else {
		return false;
	}
	return isEqual;
	}
public Node<T> getRoot() {
	return root;
}
public void setRoot(Node<T> root) {
	this.root = root;
}
	
//	@Override
//	public T getMin() {
//		if(root.getLeftChild() == null) {
//			return root.getData();
//		}else {
//			return getMin(root.getLeftChild()).getData();
//		}
//	}
//	public Node<T> getMin(Node<T> node) {
//		if(node.getLeftChild()== null) {
//			return node;
//		}else {
//			return getMin(node.getLeftChild());
//		}
//	}


}
