package doubly_linkedList;

public interface List<T> {

	public void insert(T data);
	public void remove(T data);
	public void traverseForward();
	public void traverseBackward();
	public int size();
	public void insertStart(T data);
}
