package tim_sort;

public class Main {

	public static void main(String[] args) {

		int[] nums = {4,-2,8,1,2,12,10,-55,99};
		
		TimSort sort = new TimSort(nums);
		sort.sort();
		sort.showResult();
	}

}
