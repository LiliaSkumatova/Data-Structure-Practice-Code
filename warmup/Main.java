package warmup;
import java.lang.Character;
public class Main {

	public static void replaceWhiteSpaces(char[] str) {
	
	}
	public static void main(String[] args) {
		int numOfSpaces = 0;
		char[] str = "  String   with spaces  .".toCharArray();
		for(int i = 0; i< str.length; i++) {
			if(Character.isWhitespace(str[i])) {
				numOfSpaces += 2;
			}
		}
		System.out.println(numOfSpaces);
		char[] modified = new char[str.length + numOfSpaces];
		int k = 0;
		for(int j = 0; j < str.length ; j++) {
			if(Character.isWhitespace(str[j])) {
				modified[k] = '%';
				modified[k+1] = '2';
				modified[k+2] = '0';
				k +=3;
			}else {
				modified[k] = str[j];
				k++;
			}
			
		}
		
		for(char chr : modified) {
			System.out.print(chr);
		}

	}

}
