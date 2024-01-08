package HashMapExample2;
import java.util.Map;
import java.util.HashMap;
public class App {

	public static void main(String[] args) {

		Map<String, Person> map = new HashMap<>();
		map.put("Adam", new Person("Keving", 23));
	}

}
