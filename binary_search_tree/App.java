package binary_search_tree;

public class App {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(12);
		bst.insert(20);
		bst.insert(4);
		bst.insert(1);
		bst.insert(5);
//		System.out.println(bst.treeSize(bst.getRoot()));
		System.out.println(bst.getKSmallest(bst.getRoot(), 3).getData());
//		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
//		bst2.insert(12);
//		bst2.insert(4);
//		bst2.insert(1);
//		bst2.insert(8);
//		bst2.insert(20);
//		
//		TreeCompareHandler<Integer> tca = new TreeCompareHandler<>();
//		System.out.println(tca.isTreeSame(bst.getRoot(), bst2.getRoot()));
//		
//		bst.insert(1);
//		bst.insert(8);
//		bst.insert(16);
//		bst.insert(27);
////		System.out.println(bst.getMin());
////		System.out.println(bst.getMax());
//		bst.traversal();
//		bst.remove(16);
//		bst.traversal();
//		bst.remove(20);
//		bst.traversal();
//		bst.remove(12);
//		bst.traversal();
		BinarySearchTree<Person> bstPerson = new BinarySearchTree<>();
		bstPerson.insert(new Person(47, "Adam"));
		bstPerson.insert(new Person(21, "Kevin"));
		bstPerson.insert(new Person(55, "Ana"));
		bstPerson.insert(new Person(20, "Michael"));
		bstPerson.insert(new Person(34, "Daniel"));
		bstPerson.insert(new Person(68, "Bill"));
		bstPerson.insert(new Person(23, "Susan"));
		bstPerson.insert(new Person(38, "Rose"));
		System.out.println(bstPerson.getSums());
		
//		bst.traversal();


	}

}
