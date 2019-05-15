package may;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * @author dbuch
 *
 */
public class FirstUniqueChar {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("cc"));
		System.out.println(firstUniqChar("aadadaad"));

	}

	static int firstUniqChar(String s) {
		Set<Character> set = new HashSet<>();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.add(s.charAt(i))) {
				map.put(s.charAt(i), i);
			} else {
				map.remove(s.charAt(i));
			}
		}
		int min = Integer.MAX_VALUE ;
		for (Character c : map.keySet()) {
			if(map.get(c) < min) min = map.get(c);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
