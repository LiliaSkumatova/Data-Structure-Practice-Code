package palindrome;

public class Main {

	public static void longestPal(String str){
		char[] chrArray = str.toCharArray();
		int length = chrArray.length;
		//known that max length is always at least one
		int maxLength = 1;
		
		//need something for star and end index
		for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
            	
            	//need something to with math
            	//I is the start and j is the end
            	// We know that we need to do something
            	//like end minus start divided by two?
            	
            }
		}
		
		
	}
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";

//		palindrome.getLongestPalindrome("forgeeksskeegforg");
//		palindrome.getLongestPalindrome("abba");
//		palindrome.getLongestPalindrome("aba");
//		palindrome.getLongestPalindrome("abbas");
//		palindrome.getLongestPalindrome("geegidfgcocgerreg");

	}

}
