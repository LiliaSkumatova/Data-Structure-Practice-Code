package shell_sort;


public class Main {

	public static void main(String[] args) {

		int[] nums = {3,2};
		ShellSort sort = new ShellSort(nums);
		sort.sort();
		sort.showArray();
	}

}
