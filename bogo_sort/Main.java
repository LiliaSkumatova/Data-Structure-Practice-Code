package bogo_sort;

public class Main {

	public static void main(String[] args) {

		int[] nums = {5,2,8,10,1,0,11};
		BogoSort sort = new BogoSort(nums);
		sort.sort();
	}

}
