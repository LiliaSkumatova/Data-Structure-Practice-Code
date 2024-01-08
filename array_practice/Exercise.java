package array_practice;

import javax.xml.catalog.CatalogResolver;

//have an array
//reverse the array
//O(N)
//Can not use additional memory
public class Exercise {

	// this is the algorithm that reverses the input array
	public static int[] solve(int[] nums) {
		int pointer1 = 0;
		int pointer2 = nums.length - 1;
//		for(int i = 0; i <= pointer2; i++) {
//			swap(nums, i, pointer2);
//			pointer2--;
//		}
//		for(int i = 0; i <= nums.length-1; i++) {
//			
//			if(pointer1 <= pointer2) {
//				swap(nums, pointer1, pointer2);
//				pointer1++;
//				pointer2--;
//			}else {
//				break;
//			}
//		}

//		for (int i = 0; i <= (nums.length - 1)/2; i++) {
//			swap(nums, pointer1, pointer2);
//			pointer1++;
//			pointer2--;
//		}
		
		while(pointer1 < pointer2) {
			swap(nums, pointer1, pointer2);
			pointer1++;
			pointer2--;
		}
		return nums;
	}

	//
	private static void swap(int[] nums, int index1, int index2) {
//		int tmp;
//		tmp = nums[index1];
//		nums[index1] = nums[index2];
//		nums[index2] = tmp;
		
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
		for (int number : nums) {
			System.out.print(number);
		}
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6};
		solve(nums);
		for (int number : nums) {
			System.out.println(number);
		}

	}

}
