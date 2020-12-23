//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.LinkedList;
import java.util.Queue;

class The_Maze_490 {
	public boolean hasPath(int[][] maze, int[] start, int[] destination)
	{
		if(maze == null || maze.length == 0)
			return false;
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
		int m = maze.length;
		int n = maze[0].length;
		maze[start[0]][start[1]] = 2;
		while(!q.isEmpty())
		{
			int[] curr = q.poll();
			if(curr[0] == destination[0] && curr[1] == destination[1])
				return true;
			for(int[] dir : dirs)
			{
				int i = curr[0];
				int j = curr[1];
				while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1)
				{
					i = i + dir[0];
					j = j + dir[1];
				}
				// Bring the ball back to its previous position if there is a wall at current location
				i = i - dir[0];
				j = j - dir[1];
				if(maze[i][j] != 2)
				{
					q.add(new int[] {i, j});
					maze[i][j] = 2;
				}
			}
		}
		return false;
	}

}
