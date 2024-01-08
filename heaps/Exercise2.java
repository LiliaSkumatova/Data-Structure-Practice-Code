package heaps;

public class Exercise2 {

private int[] heap;
	
	public Exercise2(int[] heap) {
		this.heap = heap;
	}
	
	public int[] transform() {
		for(int i = ((heap.length-2)/2); i>=0;i--) {
			heapify(i);
		}
		return this.heap;
	}

	private void heapify(int index) {
		int leftChildIndex = 2*index+1;
		int rightChildIndex = 2*index+2;
		//in a max heap the parent is always larger than the children
		int smallestIndex = index;
		
		if(leftChildIndex <heap.length && heap[leftChildIndex] < heap[index]) {
			smallestIndex = leftChildIndex;
		}
		if(rightChildIndex<heap.length && heap[rightChildIndex] < heap[smallestIndex]) {
			smallestIndex = rightChildIndex;
		}
		
		if(smallestIndex != index) {
			swap(smallestIndex, index);
			heapify(smallestIndex);
		}
	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
