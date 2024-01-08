package warmup;

public class Boo {

	public static int sum;
	public static void main(String[] args) {
		add(1);

	}
	public static void add(int num) {
		sum += num;
		System.out.println(num);
		if(num<5) {
			add(num+1);
		}
		System.out.println(sum);
		
	}

}
