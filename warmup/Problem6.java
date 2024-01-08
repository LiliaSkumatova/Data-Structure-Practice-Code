package warmup;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

	public static List<Integer> extractingInt(String str) {
		StringBuilder strBuilder = new StringBuilder();
		List<Integer> digits = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			if(strBuilder.length() > 0 
					&& !Character.isDigit(str.charAt(i))) {
				digits.add(Integer.parseInt(strBuilder.toString()));
				strBuilder.delete(0, strBuilder.length());
			}else if(Character.isDigit(str.charAt(i))) {
				strBuilder.append(str.charAt(i));
			}
		}
		return digits;
	}
	public static void main(String[] args) {
		List<Integer> digits = extractingInt("cv dd 4 k 2321 2 11 k4k2 66 4d.");
		for(int num:digits) {
			System.out.print(num + ", ");
		}

	}

}
