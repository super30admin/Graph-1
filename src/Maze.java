import java.util.LinkedList;
import java.util.Queue;
//Time Complexity : O(M*N) 
//Space Complexity : O(M*N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Use BFS. Push the start indices to queue. Pop from queue until its empty. at
 * each pop, check if its the destination, if so return true. Else, pick any of
 * the 4 directions and move until a boundary is hit. Then check the previous
 * index from the boundary is not visited. If not, push it to the queue and mark
 * it visited. Iterate this for 4 directions and repeat this until queue is
 * empty. If nothing found, return false.
 *
 */
class Solution {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		int[] x4 = { 0, 0, -1, 1 };
		int[] y4 = { 1, -1, 0, 0 };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			if (pair[0] == destination[0] && pair[1] == destination[1])
				return true;
			for (int i = 0; i < 4; i++) {
				int x = pair[0] + x4[i];
				int y = pair[1] + y4[i];

				while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
					x += x4[i];
					y += y4[i];
				}
				if (!visited[x - x4[i]][y - y4[i]]) {
					queue.add(new int[] { x - x4[i], y - y4[i] });
					visited[x - x4[i]][y - y4[i]] = true;
				}
			}
		}
		return false;
	}
}
