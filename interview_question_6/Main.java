package interview_question_6;

public class Main {

	public static void main(String[] args) {
//		int array1[] = {1,2,3,4,5,6,7};
//		int array2[] = {1,2,3,4,5,6,7};
//		int x = 8;
//		TwoSum sum = new TwoSum();
//		sum.sum(array1, array2, x);
		
		int[] nums = {3,5,2,-4,8,11};
		int S = 7;
		DynamicProgramminTwoSum solution = new DynamicProgramminTwoSum(nums, S);
		solution.solve();
	}

}
