package anagrams;

import java.util.Arrays;

public class Sorting {

	public static boolean solve(char[] s1, char[] s2) {
		if(s1.length != s2.length) {
			return false;
		}else {
			Arrays.sort(s1);
			Arrays.sort(s2);
			if(Arrays.equals(s1, s2)) {
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
