package palindrome;


public class Palindrome3 {

	int palLength = 1;
	int start = 0;
	public void print(String str) {
		System.out.println(str.substring(start, start + palLength));
	}
	public void checkPalindrome(String str, int leftPointer, int rightPointer) {
		
			while(leftPointer >= 0 && rightPointer < str.length() 
					&& str.charAt(leftPointer) == str.charAt(rightPointer)) {
				leftPointer--;
				rightPointer++;
			}
			if(palLength < (rightPointer - leftPointer)-1) {
				palLength = (rightPointer - leftPointer)-1;
				start = leftPointer + 1;
			}
		
	}
	public void getPalindrome(String str) {
		int leftPointer;
		int rightPointer;
		if(str != null && str.length() > 1) {
//			int center = str.length()/2;
			for(int i = 0; i < str.length(); i++) {
				int center= i;
				leftPointer = center;
				rightPointer = center;
				checkPalindrome(str, leftPointer, rightPointer);
				//second option
				checkPalindrome(str, leftPointer -1, rightPointer);
			}
			print(str);
			
		}
		
		
		
	}
	//getPalindrome
	//checkPalindrome
	//printPalindrome
}
