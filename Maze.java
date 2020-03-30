package com.example.problems;


//Time Complexity : O(M*N) for BFS
//Space Complexity : O(M*N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 * we try to explore the search space on a level by level basis. i.e. We try to move in all the directions at every step. When all the directions have been explored and we still don't reach the destination, then only we proceed to the new set of traversals from the new positions obtained.

In order to implement this, we make use of a queuequeue. We start with the ball at the startstart position. For every current position, we add all the new positions possible by traversing in all the four directions(till reaching the wall or boundary) into the queuequeue to act as the new start positions and mark these positions as True in the visitedvisited array. When all the directions have been covered up, we remove a position value, ss, from the front of the queuequeue and again continue the same process with ss acting as the new startstart position.

Further, in order to choose the direction of travel, we make use of a dirdir array, which contains 4 entries. Each entry represents a one-dimensional direction of travel. To travel in a particular direction, we keep on adding the particular entry of the dirsdirs array till we hit a wall or a boundary. For a particular start position, we do this process of dirdir addition for all all the four directions possible.

If we hit the destination position at any moment, we return a True directly indicating that the destinationdestination position can be reached starting from the startstart position.
 * */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	boolean visited[][];
	Queue<int[]> queue = new LinkedList<>();
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
}
