package anagrams;

public class DoubleForLoop {

	public static boolean solve(char[] s1, char[] s2) {
		if(s1.length != s2.length) {
			return false;
		}else {
			int count = 0;
			for(int i = 0; i < s1.length; i++) {
				for(int j = 0; j <s2.length; j++) {
					if(s1[i] == s2[j]) {
						count++;
					}
				}
			}
			if(s1.length == count && s2.length == count) {
				return true;
			}else {
				return false;
			}
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
