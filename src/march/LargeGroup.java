package march;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dbuch
 *
 *         In a string S of lowercase letters, these letters form consecutive
 *         groups of the same character.
 * 
 *         For example, a string like S = "abbxxxxzyy" has the groups "a", "bb",
 *         "xxxx", "z" and "yy".
 * 
 *         Call a group large if it has 3 or more characters. We would like the
 *         starting and ending positions of every large group.
 * 
 *         The final answer should be in lexicographic order.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: "abbxxxxzzy" Output: [[3,6]] Explanation: "xxxx" is the single
 *         large group with starting 3 and ending positions 6. Example 2:
 * 
 *         Input: "abc" Output: [] Explanation: We have "a","b" and "c" but no
 *         large group. Example 3:
 * 
 *         Input: "abcdddeeeeaabbbcd" Output: [[3,5],[6,9],[12,14]]
 */
public class LargeGroup {

	public static void main(String[] args) {
		String test = "abcdddeeeeaabbbcd";
		print(largeGroupPositions(test));
	}

	private static void print(List<List<Integer>> largeGroupPositions) {
		System.out.print("[");
		for (List<Integer> list : largeGroupPositions) {
			System.out.println("[" + list.get(0) + "," + list.get(1) + "]");
			System.out.print(",");
		}
		System.out.print("]");
	}

	static List<List<Integer>> largeGroupPositions(String S) {
		int[] cIndex = new int[26];
		int[] start = new int[26];
		int[] end = new int[26];
		char[] c = S.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int j = (c[i] - 'a');
			if (cIndex[j] == 0) {
				start[j] = i;
			} else {
				end[j] = i;
			}
			cIndex[j]++;
		}

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (cIndex[i] >= 3) {
				List<Integer> list = new ArrayList<>();
				list.add(start[i]);
				list.add(end[i]);
			}
		}

		return result;
	}
}
