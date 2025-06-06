// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
import java.util.*;

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // right, down, left, up

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];

                // Roll the ball until it hits a wall
                while (x + dir[0] >= 0 && x + dir[0] < m &&
                       y + dir[1] >= 0 && y + dir[1] < n &&
