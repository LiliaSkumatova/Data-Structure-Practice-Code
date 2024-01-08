package heaps;

public class Exc2 {

	 private int[] heap;
		
		public Exc2(int[] heap) {
			this.heap = heap;
		}
		
		public int[] transform() {
//			for(int i =0;i < heap.length; i++) {
//				heapify(i);
//			}
			heapify(0);
			return heap;
		}

		private void heapify(int index) {
			for(int k = index;k < heap.length; k++) {
				if(heap[index] > heap[k]) {
					swap(index, k);
				}
			}
			if(index != heap.length-1) {
				heapify(index + 1);
			}
			
		}

		private void swap(int index1, int index2) {
			int temp = heap[index1];
			heap[index1] = heap[index2];
			heap[index2] = temp;
		}
}
