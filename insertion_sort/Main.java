package insertion_sort;


public class Main {

	public static void main(String[] args) {
		int[] nums = {4,2,3,0,1};
		InsertionSort sort = new InsertionSort(nums);
		sort.sort();
		sort.showArray();
	}

}
