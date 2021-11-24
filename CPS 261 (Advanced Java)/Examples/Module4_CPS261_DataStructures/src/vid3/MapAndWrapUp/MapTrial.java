package vid3.MapAndWrapUp;

import java.util.HashMap;
import java.util.Map;

public class MapTrial {

	public static void main(String[] args) {

		String msg = "Good evening have a good class have a good evening have fun";

		String[] words = msg.split(" ");

		Map<String, Integer> wordCount = new HashMap<>();

		for (String eachWord : words) {

			String key = eachWord.toLowerCase();

			if (wordCount.containsKey(key)) {
				int val = wordCount.get(key);
				wordCount.put(key, val + 1);
			} else {
				wordCount.put(key, 1);
			}

		}

		wordCount.forEach((k, v) -> System.out.println(k + " " + v));

	}

}
