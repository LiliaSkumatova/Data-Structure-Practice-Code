package binary_search_tree;

public interface Tree<T> {
	public void insert(T data);
	public void remove(T data);
	public void traversal();
	public T getMax();
	public T getMin();
}
