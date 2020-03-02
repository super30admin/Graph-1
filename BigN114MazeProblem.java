// Time complexity is O(n)
// Space complexity is O(n)

public class BigN114MazeProblem {
	int row;
	int column;
	int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		row = maze.length;
		if (row == 0 || maze == null)
			return false;
		column = maze[0].length;
		return DFS(maze, start, destination);
	}

	private boolean DFS(int[][] maze, int[] start, int[] destination) {
		int i = start[0];
		int j = start[1];
		// base case
		if (i == destination[0] && j == destination[1])
			return true;
		if(maze[i][j]==2)
			return false;
		// logic
		maze[i][j] = 2;
		for (int[] dir : dirs) {
			int r = i;
			int c = j;
			while (r >= 0 && r < row && c >= 0 && c < column && (maze[r][c] == 0 || maze[r][c] == 2)) {
				r += dir[0];
				c += dir[1];
			}
			r -= dir[0];
			c -= dir[1];
			if (maze[r][c] != 2) {
				if(DFS(maze, new int[] { r, c }, destination))
					return true;
			} 
		}
		return false;
	}

	public static void main(String[] args) {
		BigN114MazeProblem maze = new BigN114MazeProblem();
		int[][] mazes = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 }};
		int[] start = { 0, 4 };
		int[] destination = { 3, 2 };
		System.out.println(maze.hasPath(mazes, start, destination));
	}
}