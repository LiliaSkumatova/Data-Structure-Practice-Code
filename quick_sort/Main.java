package quick_sort;

public class Main {

	public static void main(String[] args) {

		int[] nums = {5,-1,0,7,2,3,2,1,0,1,2};
		
		QuickSort sort = new QuickSort(nums);
		sort.sort();
		sort.showArray();
	}

}
