import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * This is a BFS and DFS approach where the ball starts from the mentioned start co-ordinates and that position will be added inside the Queue(BFS).
 * when polled out, the movement of the ball will be checked in all the 4 directions until it reaches a hurdle, and mark the previous 
 * position of the wall as visited by '2'; and add that position(s) inside the queue.
 * While processing the coordinated from the Queue, that position will be checked whether it is the mentioned destination or not.
 */
public class TheMaze {
	public boolean hasPathBFS(int [][] maze, int [] start, int [] destination){
		if(maze == null || maze.length == 0) return false;
		int [][] dirs  = {{0,1},{1,0},{0,-1},{-1,0}};
		int m = maze.length;
		int n = maze[0].length;
		Queue<int []> q = new LinkedList<>();
		q.add(new int [] {start[0],start[1]});
		maze[start[0]][start[1]] = 2;
		while(!q.isEmpty()){
			int [] curr = q.poll();
			if(curr[0] == destination[0] && curr[1] == destination[1]){
				return true;
			}
			for(int [] dir : dirs){
				int i = curr[0];
				int j = curr[1];
				while(i >= 0 && j >= 0 && i < m && i < n && maze[i][j] != 1){
					i += dir[0];
					j += dir[1];
				}
				i -= dir[0];
				j -= dir[1];
				if(maze[i][j] != 2){
					q.add(new int []{i,j});
					maze[i][j] = 2;
				}
			}
			
		}
		return false;
	}
	
	int [][] dirs;
	public boolean hasPath(int [][] maze, int [] start, int [] destination){
		if(maze == null || maze.length == 0) return false;
		dirs  = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		int m = maze.length;
		int n = maze[0].length;
		return dfs(maze, start, destination, m, n);
	}
	
	private boolean dfs(int [][] maze, int [] start, int [] destination, int m, int n){
		//base
		if(maze[start[0]][start[1]] == 2) return false;
		if(start[0] == destination[0] && start[1] == destination[1]) return true;
		//logic
		maze[start[0]][start[1]] = 2;
		for(int [] dir : dirs){
			int i = start[0];
			int j = start[1];
			while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1){
				i += dir[0];
				j += dir[1];
			}
			i -= dir[0];
			j -= dir[1];
			if(dfs(maze, new int[]{i,j}, destination, m, n)){
				return true;
			}
		}
		return false;
	}
	
}
