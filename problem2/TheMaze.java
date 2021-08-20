// Time Complexity : O(m*n*max(m, n)), m -> Number of rows, n -> Number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
	int[][] dirs;

	/********************* BFS *********************/
	// Time Complexity : O(m*n*max(m, n)), m -> Number of rows, n -> Number of
	// columns
	// Space Complexity : O(m*n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
		if (maze == null || maze.length == 0) {
			return false;
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int m = maze.length;
		int n = maze[0].length;

		maze[start[0]][start[1]] = 2;

		while (!queue.isEmpty()) {
			int[] space = queue.poll();

			for (int[] dir : dirs) {
				int i = space[0];
				int j = space[1];

				while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
					i += dir[0];
					j += dir[1];
				}

				i -= dir[0];
				j -= dir[1];

				if (destination[0] == i && destination[1] == j) {
					return true;
				}

				if (maze[i][j] != 2) {
					queue.add(new int[] { i, j });
					maze[i][j] = 2;
				}
			}
		}

		return false;
	}

	/********************* DFS *********************/
	public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
		if (maze == null || maze.length == 0) {
			return false;
		}

		int m = maze.length;
		int n = maze[0].length;
		dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		return dfs(maze, start, destination, m, n);
	}

	private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n) {
		// Base
		if (destination[0] == start[0] && destination[1] == start[1]) {
			return true;
		}
		// Logic
		maze[start[0]][start[1]] = 2;
		for (int[] dir : dirs) {
			int i = start[0];
			int j = start[1];

			while (i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1) {
				i += dir[0];
				j += dir[1];
			}

			i -= dir[0];
			j -= dir[1];

			if (maze[i][j] != 2 && dfs(maze, new int[] { i, j }, destination, m, n)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TheMaze obj = new TheMaze();

		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] dest = { 4, 4 };

		System.out.println(
				"Can the ball reach the destination? " + (obj.hasPathDFS(maze, start, dest) == true ? "Yes" : "No"));
	}

}
