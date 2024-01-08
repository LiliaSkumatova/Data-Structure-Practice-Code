package quicksort_iteration;

public class Main {

	public static void main(String[] args) {

		int[] nums = {4,-2,8,1,2,12,10,-55,99,10};
		QuickSortIteration sort = new QuickSortIteration(nums);
		sort.sort();
		sort.showArray();
	}

}
