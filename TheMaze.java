import java.util.LinkedList;
import java.util.Queue;

// Time Complexity :O(MN)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class TheMaze {
    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            Queue<int[]> q = new LinkedList<>();
            q.add(start);
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};//direction of travel
            boolean[][] visited = new boolean[maze.length][maze[0].length];

            //bfs
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                if (pos[0] == destination[0] && pos[1] == destination[1]) return true;//return true if start and end postion are same
                if (maze[pos[0]][pos[1]] == 1 || visited[pos[0]][pos[1]]) continue;//continue if there is a wall or has been visited
                visited[pos[0]][pos[1]] = true;

                //check direction of travel
                for (int[] dir : dirs) {
                    int i = 0;
                    while (pos[0] + dir[0] * i >= 0 && pos[0] + dir[0] * i < maze.length
                            && pos[1] + dir[1] * i >= 0 && pos[1] + dir[1] * i < maze[0].length
                            && maze[pos[0] + dir[0] * i][pos[1] + dir[1] * i] == 0) {
                        i++;
                    }
                    i--;
                    int[] next = {pos[0] + dir[0] * i, pos[1] + dir[1] * i};
                    q.add(next);
                }
            }
            return false;//return false if unable to get to destination
        }
    }
}

