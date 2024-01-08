package splay_tree;

public interface Tree<T> {

	public void insert(T data);
	public void traverse();
	public T find(T data);
	public T getRoot();
	
}
