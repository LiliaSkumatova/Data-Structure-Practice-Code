package bubble_sort;

public class BubbleSort {

	private int[] nums;
	public BubbleSort(int[] nums) {
		this.nums = nums;
	}
	public void sort()
    {
    int temp;

        for(int i=0;i<nums.length-1;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[j] < nums[i])
                {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                }
        showSortedArray();
    }    
//	public void sort() {
//		for(int i = 0; i<nums.length-1; ++i) {
//			for(int j = 0; j<nums.length-i-1;++j) {
//				if(nums[j] > nums[j+1]) {
//					swap(j, j+1);
//				}
//			}
//		}
//		showSortedArray();
//	}
	private void showSortedArray() {
		for(int i = 0; i<nums.length;++i) {
			System.out.println(nums[i] + " ");
		}
	}
	
	//swap 2 items in the nums array in O(1)
		private void swap(int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
}
