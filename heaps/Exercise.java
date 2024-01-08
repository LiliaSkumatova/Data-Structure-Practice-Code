package heaps;

public class Exercise {

	public boolean isMinHeap(int[] heap) {
//		int index = 0;
//		if(heap != null) {
//			while(index < heap.length){
//				if(2*index+1 < heap.length && heap[index] > heap[2*index+1]) {
//					return false;
//				}else if(2*index+2 < heap.length && heap[index] > heap[2*index+2]) {
//					return false;
//				}
//				index++;
//			}
//			return true;
//		}
//		return false;
		
		for(int i =0; i<(heap.length-2)/2;i++) {
			if(heap[i] > heap[2*i+1] || heap[i] > heap[2*i+2]) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isMinHeap2(int[] heap) {
		return checkMin(0, heap);
	}

	private boolean checkMin(int index, int[] heap) {
		int leftChildIndex = 2*index+1;
		int rightChildIndex = 2*index+2;
		if(heap != null && index < heap.length) {
			if(leftChildIndex < heap.length && heap[index] > heap[leftChildIndex]) {
				return false;
			}else if(rightChildIndex < heap.length && heap[index] > heap[rightChildIndex]) {
				return false;
			}
			checkMin(++index, heap);
			
		}else {
			return false;
		}
		return true;
		
	}
	
}
