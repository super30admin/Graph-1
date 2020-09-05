import java.util.*;
//Leetcode: 490
/**************************************************Approach 1******************************************/
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : none

/**Using Queue, we only add to the queue when reached border or obstacles
 * we iterate through directions until reached border or wall and add to queue if its never been visited(2) before
 * each time we visit a node, change from 0 to 2
 * we check each time visiting a node is the value needed or not
 * if not found, return false
 * **/

class Maze_BFS {
	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		//edge case
		if(maze == null || maze.length == 0)
			return false;

		int m = maze.length;
		int n = maze[0].length;
		Queue<int[]> q = new LinkedList<>();	//using queue, BFS
		int[][] dirs = new int[][] {{0,1},{-1,0},{1,0},{0,-1}};
		q.add(new int[] {start[0], start[1]});
		maze[start[0]][start[1]] = 2;	// mark the starting position as visited
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0] == destination[0] && curr[1] == destination[1]) {
				return true;	//return true if reached destination
			}

			for(int[] dir: dirs) {
				int r = curr[0];	//source cell indices
				int c = curr[1];
				while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
					r = r + dir[0];
					c = c + dir[1];
				}
				//bring the ball to actual child, i.e one behind the obstacle
				r = r - dir[0];	// we stop when we reach a wall i.e 1 so we have to give a index prior to that
				c = c - dir[1];

				if(maze[r][c] != 2) {	// putting all the children in the queue
					q.add(new int[] {r, c});
					maze[r][c] = 2;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] maze = { {0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0 }}; 
		int[] start = {0, 4};
		int[] destination= {4, 4};
		System.out.println(hasPath(maze, start, destination));
	}
}

/**************************************************Approach 2******************************************/
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : none

class Maze_DFS {
	static int m;
	static int n;
	static int[][] dirs;
	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		//edge case
		if(maze == null || maze.length == 0)
			return false;

		m = maze.length;
		n = maze[0].length;
		dirs = new int[][] {{0,1},{-1,0},{1,0},{0,-1}};

		maze[start[0]][start[1]] = 2;	// mark the starting position as visited
		return dfs(maze, start, destination);
	}
	private static boolean dfs(int[][] maze, int[] start, int[] destination) {
		//base
		if(start[0] == destination[0] && start[1] == destination[1]) {	// when the start of dfs becomes destination
			return true;	//return true if reached destination
		}

		//logic
		for(int[] dir: dirs) {
			int r = start[0];	//source cell indices
			int c = start[1];
			while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
				r = r + dir[0];
				c = c + dir[1];
			}
			//bring the ball to actual child, i.e one behind the obstacle
			r = r - dir[0];	// we stop when we reach a wall i.e 1 so we have to give a index prior to that
			c = c - dir[1];

			if(maze[r][c] != 2) {	//if position is not visited
				maze[r][c] = 2;

				if(dfs(maze, new int[] {r,c}, destination))	// start dfs on the new starting index, if it returns true at any point return true
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] maze = { {0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0 }}; 
		int[] start = {0, 4};
		int[] destination= {4, 4};
		System.out.println(hasPath(maze, start, destination));
	}
}