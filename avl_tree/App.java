package avl_tree;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Integer> avl = new AVLTree<>();
//		avl.insert(12);
//		avl.insert(20);
//		avl.insert(4);
//		avl.insert(1);
//		avl.insert(5);
//		avl.insert(23);
//		
//		avl.remove(23);
//		avl.remove(20);
		avl.insert(3);
		avl.insert(5);
		avl.insert(4);
		avl.traversal();

	}

}
