// Time Complexity : O(m * n)
// Space Complexity : O(m * n), for visited
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use BFS to simulate ball rolling in all four directions until hitting a wall.
//   - From each cell, roll in one direction until hitting the wall, then step back one cell.
//   - If that cell hasn't been visited, add it to the queue and mark visited.
//   - Repeat until reaching the destination or queue is empty.

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = -1;  //mark visited

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                //roll till it hits the wall
                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                //go back to one space in same direction to get last possible cell before hitting wall
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1])  return true;
                if(maze[r][c] != -1) {
                    q.add(new int[]{r, c});
                    maze[r][c] = -1;    //mark visited and add in Queue
                }

            }

        }

        return false;
    }

    public static void main(String[] args) {
        TheMaze solver = new TheMaze();
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};

        boolean result = solver.hasPath(maze, start, destination);
        System.out.println("Path exists: " + result); // Expected: true
    }
}
