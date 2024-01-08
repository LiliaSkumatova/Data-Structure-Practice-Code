package anagrams;

public class ASCII_method {

	public static boolean solve(char[] s1, char[] s2) {
		if(s1.length != s2.length) {
			return false;
		}else {
			int[] list = new int[256];
			for(int i = 0; i < s1.length; i++) {
				int numericValue1 = Character.getNumericValue(s1[i]);
				list[numericValue1]++;
				int numericValue2 = Character.getNumericValue(s2[i]);
				list[numericValue2]--;
			}
			for(int j = 0; j < s1.length; j++) {
				int numericValue1 = Character.getNumericValue(s1[j]);
				if(list[numericValue1] != 0 ) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		char[] s1 = new char[] {'s','l','u','g'};
		char[] s2 = new char[] {'l','u','g','s'};
		if(solve(s1, s2)) {
			System.out.println("Is an anagram");
		}else {
			System.out.println("Is not an anagram");
		}
	}
}
