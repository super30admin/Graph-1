//Time Complexity : O(MN) 
//Space Complexity : O(MN)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Y
public class Maze {
	int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	boolean visited[][];
	int row, col;

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze == null || maze.length == 0)
			return false;
		if (Arrays.equals(start, destination))
			return true;
		row = maze.length;
		col = maze[0].length;
		visited = new boolean[row][col];
		return bfs(maze, start, destination);
	}

	public boolean bfs(int[][] maze, int[] start, int[] destination) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(start);
		visited[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] cell = queue.remove();

			if (Arrays.equals(cell, destination))
				return true;

			for (int dir[] : dirs) {
				int newRow = cell[0] + dir[0];
				int newCol = cell[1] + dir[1];

				while (isSafe(newRow, newCol) && maze[newRow][newCol] != 1) {
					newRow += dir[0];
					newCol += dir[1];
				}
				newRow -= dir[0];
				newCol -= dir[1];

				if (!visited[newRow][newCol]) {
					queue.add(new int[] { newRow, newCol });
					visited[newRow][newCol] = true;
				}
			}
		}
		return false;
	}

	public boolean isSafe(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}

	public static void main(String args[]) {
		int maze[][] = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int start[] = { 0, 4 };
		int destination[] = { 4, 4 };

		Maze m = new Maze();

		boolean isReachable = m.hasPath(maze, start, destination);

		System.out.println(isReachable);
	}
}
