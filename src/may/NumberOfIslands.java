package may;

public class NumberOfIslands {

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));

		System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}

	static int numIslands(char[][] grid) {

		if(grid.length==0)return 0;
		boolean visited[][] = new boolean[grid.length][grid[0].length];

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					dfs(i, j, grid, visited);
					count++;
				}
			}
		}

		return count;
	}

	private static void dfs(int row, int col, char[][] grid, boolean[][] visited) {

		// Diagonal included
		// int[] r = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
		// int[] c = new int[] { 0, +1, -1, -1, -1, 0, 1, 1 };

		// Only vertical and horizontal steps
		int[] r = new int[] { -1, 0, 1, 0 };
		int[] c = new int[] { 0, -1, 0, 1 };

		for (int i = 0; i < r.length; i++) {
			if (isSafe(row + r[i], col + c[i], grid) && grid[row + r[i]][col + c[i]] == '1'
					&& !visited[row + r[i]][col + c[i]]) {
				visited[row + r[i]][col + c[i]] = true;
				dfs(row + r[i], col + c[i], grid, visited);
			}
		}

	}

	private static boolean isSafe(int row, int col, char[][] grid) {
		if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length)
			return true;
		return false;
	}
}
