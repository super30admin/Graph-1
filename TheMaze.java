// Time Complexity : O(m*n*(m+n)) // while loop is m+n
// Space Complexity : O(m*n) //queue size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. Start from the start and try to move four directions.
 * 2. in each direction move till you read end or till obstacle.
 * 3. check is it destination if true return.
 * 4. if it is not destination add indexes to queue and mark it as visited. 
 */

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze == null)
			return false;

		Queue<int[]> queue = new LinkedList<>();
		
		//add start to queue and mark it as visited
		queue.add(start);
		maze[start[0]][start[1]] = 2;

		int m = maze.length;
		int n = maze[0].length;

		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] dir : dirs) {
				int i = cur[0];
				int j = cur[1];

				//move till the end of left,right,down,left till you find obstacle or end or start
				while (i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1) {
					i = i + dir[0];
					j = j + dir[1];
				}

				//one step back
				i = i - dir[0];
				j = j - dir[1];

				//if it is stopped at destination return true
				if (i == destination[0] && j == destination[1]) {
					return true;
				}
				//if it is not visited add it to queue and mark it as visited
				else if (maze[i][j] != 2) {
					queue.add(new int[] { i, j });
					maze[i][j] = 2;
				}
			}
		}
		return false;
	}
}
