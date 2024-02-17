/*
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeBFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;

        int n = maze[0].length;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        maze[start[0]][start[1]] = 2;

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int minStops = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // find the wall in the given direction
                    while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                        nr += dir[0];
                        nc += dir[1];
                    }

                    nr -= dir[0];
                    nc -= dir[1];

                    // if it is destination
                    if (nr == destination[0] && nc == destination[1]) {
                        return true;
                    }

                    // unvisited
                    if (maze[nr][nc] != 2) {
                        maze[nr][nc] = 2;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }

            minStops++;
        }

        System.out.println("minStops:" + minStops);
        return false;
    }
}
