package week9.day4;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	public static boolean canReachDestination(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		maze[start[0]][start[1]] = 2; // visited
		
		while (!q.isEmpty()) {
			int[] el = q.poll();
			int row = el[0];
			int col = el[1];
			System.out.println(row + " " + col);
			for (int[] dir : directions) {
				int nr = row;
				int nc = col;

				while (nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] != 1) {
					nr = nr + dir[0];
					nc = nc + dir[1];
				}

				nr = nr - dir[0]; // step back and compare if it is 0
				nc = nc - dir[1];
				if (nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] == 0) {
					q.add(new int[] { nr, nc });
					maze[nr][nc] = 2;
				}

				if (destination[0] == nr && destination[1] == nc)
					return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] destination = {4,4 };

		System.out.println(canReachDestination(maze, start, destination));

	}

}
