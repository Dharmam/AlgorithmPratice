package may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dbuch Given two words (beginWord and endWord), and a dictionary's
 *         word list, find the length of shortest transformation sequence from
 *         beginWord to endWord, such that:
 * 
 *         Only one letter can be changed at a time. Each transformed word must
 *         exist in the word list. Note that beginWord is not a transformed
 *         word.
 */
public class WordLadder {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		System.out.println(ladderLength("hit", "cog", wordList));
		
		
	}

	// BFS
	static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dict = new HashSet<>();
		HashSet<String> visited = new HashSet<>();

		for (String s : wordList)
			dict.add(s);

		if (!dict.contains(endWord))
			return 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		visited.add(beginWord);

		int count = 1;
		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int k = 0; k < level; k++) {
				String currentWord = queue.poll();

				char[] arr = currentWord.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char c = arr[i];
					for (int j = 'a'; j <= 'z'; j++) {
						arr[i] = (char) j;
						String newWord = new String(arr);

						if (newWord.equals(endWord))
							return count + 1;

						if (dict.contains(newWord) && !visited.contains(newWord)) {
							queue.offer(newWord);
							visited.add(newWord);
						}
					}
					arr[i] = c;
				}
			}
			count++;
		}
		return 0;
	}
}
