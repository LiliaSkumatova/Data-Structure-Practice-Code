package redblack_tree;

public class Main {

	public static void main(String[] args) {
		Tree<Integer> rbt = new RedBlackTree<>();
		rbt.insert(1);
		rbt.insert(2);
		rbt.insert(3);
		rbt.insert(19);
		rbt.insert(6);
		rbt.insert(17);
		rbt.traversal();
	}

}
