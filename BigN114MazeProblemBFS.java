//Time complexity is O(n)
//Space complexity is O(n)

import java.util.LinkedList;
import java.util.Queue;

public class BigN114MazeProblemBFS {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// edge case
		if (maze == null || maze.length == 0)
			return false;
		int row = maze.length;
		int column = maze[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start[0], start[1] });
		maze[start[0]][start[1]] = 2;
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int[] dir : dirs) {
				int r = temp[0];
				int c = temp[1];
				while (r >= 0 && r < row && c >= 0 && c < column && maze[r][c] != 1) {
					r += dir[0];
					c += dir[1];
				}
				// step back
				r -= dir[0];
				c -= dir[1];
				if (r == destination[0] && c == destination[1])
					return true;
				if (maze[r][c] != 2) {
					q.offer(new int[] { r, c });
					maze[r][c] = 2;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		BigN114MazeProblemBFS maze = new BigN114MazeProblemBFS();
		int[][] mazes = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 }};
		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		System.out.println(maze.hasPath(mazes, start, destination));
	}
}