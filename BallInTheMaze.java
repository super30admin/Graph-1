// TC: O(m x n)
// SC: O(m x n)
public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] dirs = new int[][] { {-1,0}, {0, -1}, {1, 0}, {0, 1} };

        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];

                while( r >= 0 && c >= 0 && r < n && c < m && maze[r][c] != 1){
                    r = r+ dir[0];
                    c = c+ dir[1];
                }

                r = r - dir[0];
                c = c - dir[1];
                if(r == destination[0] && c == destination[1]){
                    return true;
                }
                if(maze[r][c] != 2){
                    q.add( new int[] {r, c});
                    maze[r][c] = 2;
                }

            }

        }

        return false;

    }
}