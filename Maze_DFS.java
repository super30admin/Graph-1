// Time Complexity : O(m * n) --> where m and n are the lengths of input 2D-Array
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode (490): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// DFS Solution
class Solution {
	int m; int n;
	int dirs[][];
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// edge case
		if (maze == null || maze.length == 0) return false;
		
		m = maze.length; n = maza[0].length;
		maze[start[0]][start[1]] = 2; // mark the start visited
		dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		return dfs(maze, start, destination);

		while (!q.isEmpty()) {
			int curr[] = q.poll();
			if (curr[0] == destination[0] && curr[1] == destination[1]) return true;
			for (int dir[] : dirs) {
				int r = curr[0]; int c = curr[1];
				while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
					r += dir[0]; c+= dir[1];
				}
				r -= dir[0]; c-= dir[1]; // bring back to actual stop point
				if (maze[r][c] != 2) {
					maze[r][c] = 2; // mark the stop node position as visited
					q.add(int[] {r,c});	
				}
			}
		}
		return false;
	}
	
	private boolean dfs(int[][] maze, int[] start, int[] destination) {
		// base case
		if (start[0] == destination[0] && start[1] == destination[1]) return true;
		
		// logic
		for (int dir[] : dirs) {
			int r = start[0]; int c = start[1];
			while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
				r += dir[0]; c+= dir[1];
			}
			r -= dir[0]; c-= dir[1]; // bring back to actual stop point
			if (maze[r][c] != 2) {
				maze[r][c] = 2; // mark the stop node position as visited
				if (dfs(maze, new int[] {r,c}, destination)) return true;
			}
		}
		return false;
	}
}