package interview_question_6;

public class TwoSum {
	public void sum(int array1[], int array2[], int x) {
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if(array1[i] + array2[j] == x) {
					System.out.println(array1[i] + " " + array2[j]);
				}
			}
		}
	}
	
}
