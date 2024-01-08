package warmup;

public class Problem5 {

	public static String shrink(String str) {
		StringBuilder strBuilder = new StringBuilder();
		int charOccurance =0;
		for(int i = 0; i < str.length(); i++) {
			charOccurance++;
			if(!Character.isWhitespace(str.charAt(i))) {
				if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
					strBuilder.append(str.charAt(i))
					.append(charOccurance);
					charOccurance = 0;
				}
			}else {
				strBuilder.append(str.charAt(i));
				charOccurance = 0;
			}
		}//end for
		return strBuilder.toString();
	}
	public static void main(String[] args) {

		System.out.println(shrink("abbb vvvv s rtt"));
	}

	
}
