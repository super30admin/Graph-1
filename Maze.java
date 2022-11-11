//Time complexity : O(k*m*n)
//Space complexity : O(m*n)
public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(maze == null || maze.length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L F
        //BFS Solution
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int i = curr[0];
                int j = curr[1];
                while () {

                }
                i = i - dir[0];
                j = j - dir[1];
                if (maze[i][j] == 0) {
                    if (i == destination[0] && j = destination[1]) {
                        return true;
                    }
                    maze[i][j] = -1;
                    q.add(new int[] {i, j});
                }
            }
        }
        return false;
    }
}
