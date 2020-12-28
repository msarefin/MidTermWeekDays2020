package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */


		Map<String , String> map = new HashMap<String, String>();
		map.put("Name","Alex");
		map.put("Gender","Male");
		map.put("Age", "33");
		map.put("City", "New York");
		map.put("Country", "United States");

		for(Map.Entry record: map.entrySet()){
			System.out.println(record.getKey()+" : "+record.getValue());
		}
		System.out.println("---------------------------");
		System.out.println(map.get("Name"));
		System.out.println(map.get("Gender"));
		System.out.println(map.get("Age"));
		System.out.println(map.get("City"));
		System.out.println(map.get("Country"));


	}

}
