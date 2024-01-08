package palindrome;

public class Palindrome2 {

	public static int reverse(int n) {
		int reversed = 0;
		int remainder = 0;
		while(n != 0) {
			remainder = n%10;
			reversed = reversed * 10 + remainder;
			n /=10;
		}
		
		return reversed;
	}
	public static void main(String[] args) {
		System.out.println(1234);
		System.out.println(reverse(1234));

	}

}
