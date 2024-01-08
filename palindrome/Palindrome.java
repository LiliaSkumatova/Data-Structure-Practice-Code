package palindrome;

public class Palindrome {

	public static boolean solve(String s) {
		
//		String reverseString = "";
//		for(int i = s.length()-1; i >= s.length()-1; i--) {
//			reverseString = reverseString + s.charAt(i);
//		}
		int pointer1 = 0;
		int pointer2 = s.length()-1;
		
		while(pointer1 <= pointer2) {
			if(s.charAt(pointer1) != s.charAt(pointer2)) {
				return false;
			}
			pointer1 ++;
			pointer2--;
		}
		return true;
		
//		return false;
//		if(s.equals(reverseString)) {
//			return true;
//		}else {
//		return false;
//		}
	}
	public static void main(String[] args) {
		if(solve("radars")) {
			System.out.println("Is a palindrome");
		}else {
			System.out.println("Is not a palindrome");
		}

	}

}
