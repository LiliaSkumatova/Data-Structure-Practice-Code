package radix_sort;


public class App {

	public static void main(String[] args) {

		int[] nums = {12,56,34,99,78,0,5,4,3,1000};
		RadixSort sort = new RadixSort(nums);
		sort.sort();
		sort.showArray();
	}

}
