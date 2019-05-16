package may;

import java.util.Arrays;

/**
 * 
 * @author dbuch 323. Number of Connected Components in an Undirected Graph
 */
public class ConnectedComponents {

	public static void main(String[] args) {
		System.out.println(countComponents(4, new int[][] {{2, 3}, {1, 2}, {1, 3}}));
		System.out.println(countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
		System.out.println(countComponents(5, new int[][] {{0, 1}, {1, 2}, {2,3}, {3, 4}}));
		System.out.println(countComponents(5, new int[][] {{0, 1}, {0, 4}, {2, 3}}));

	}

	static int countComponents(int n, int[][] edges) {
		int[] parents = new int[n];
		// sets.
		for (int i = 0 ; i < parents.length ; i++ ) {
			parents[i] = i;
		}

		for (int[] edge : edges) {
			int parent1 = find(edge[0], parents);
			int parent2 = find(edge[1], parents);

			union(parent1, parent2, parents);
		}

        Arrays.sort(parents);
		int count = 0;
		int last = -1;
		for (int i : parents) {
			if (i != last) {
				count++;
				last = i;
			}
		}

		return count;
	}

	private static void union(int parent1, int parent2, int[] parents) {
		int x = (parent1 < parent2) ? parent1 : parent2;
		int y = (parent1 < parent2) ? parent2 : parent1;
		for (int i = 0 ; i < parents.length ; i++ ) {
			if(parents[i]==y)parents[i] = x;
		}
	}

	private static int find(int i, int[] parents) {
		while (parents[i] != i) {
			i = parents[i];
		}
		return i;
	}

}
