package counting_sort;

public class App {

	public static void main(String[] args) {

		//has to be between 0-10
		int[] nums = {1,6,4,0,8,7,3,6,5};
		CountingSort sort = new CountingSort(nums);
		sort.sort();
		sort.showArray();
		
		//counting arbitrary lets us have numbers that are not only between 0-10
		//sadly it is O(N+K)
	}

}
