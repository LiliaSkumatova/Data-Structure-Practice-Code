package heaps;

import java.util.Objects;

public class Heap<T> {
	//maxHeap implementation
	//no generic arrays can have object with cast arrays
	//	T[] o = (T[])new Objects[10];
	//this implementation will just be ints tho
	private int[] heap;
	//num of items in the heap
	private int heapSize;
	
	public Heap() {
		heap = new int[Constants.CAPACITY];
	}
	
	public void insert(int data) {
		if(isFull()) {
			throw new RuntimeException("heap is full... ");
		}
		heap[heapSize] = data;
		heapSize++;
		//we have to check heap properties
		//that has index heapSize-1
		//Check from leaf to root O(logN)
		fixUp(heapSize-1);
	}
	private void fixUp(int index) {
		//parent index
		int parentIndex = (index-1)/2;
		//in worst-case we have to consider all the nodes up to the root node (index 0)
		//in a maximum heap the parent is always larger
		if(index>0 && heap[index] > heap[parentIndex]) {
			swap(index, parentIndex);
			fixUp(parentIndex);
		}
		
	}
	public int getMax() {
		return heap[0];
	}
	//heapsort is doing a poll() operation for N times O(NlogN)
	public void heapSort() {
		int n = heapSize;
		for(int i = 0; i<n; i++) {
			int max = poll();
			System.out.println(max);
		}
	}
	//that removes and returns the max item in O(logN)
	public int poll() {
		int max = getMax();
		
		//swap the root node with the last item
		swap(0, heapSize-1);
		heapSize--;
		
		//fix the heap properties if needed
		fixDown(0);
		
		return max;
	}
	//O(logN)
	private void fixDown(int index) {

		int leftChildIndex = 2*index+1;
		int rightChildIndex = 2*index+2;
		//in a max heap the parent is always larger than the children
		int largestIndex = index;
		
		if(leftChildIndex <heapSize && heap[leftChildIndex] > heap[index]) {
			largestIndex = leftChildIndex;
		}
		if(rightChildIndex<heapSize && heap[rightChildIndex] > heap[largestIndex]) {
			largestIndex = rightChildIndex;
		}
		//one of the children is larger than the parent have to swap
		if(index!= largestIndex) {
			swap(index, largestIndex);
			//while there are violations
			fixDown(largestIndex);
		}
	}
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
		
	}
	private boolean isFull() {
		return heapSize == Constants.CAPACITY;
	}
	public int[] getHeap() {
		return this.heap;
	}
}
