// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        maze[start[0]][start[1]] = 2;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int[] dir : dirs) {
                int x = current[0];
                int y = current[1];
                while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {

                    x = x + dir[0];
                    y = y + dir[1];
                }
                x = x - dir[0];
                y = y - dir[1];
                
                if(x == destination[0] && y == destination[1]) {
                    return true;
                }
                
                if(maze[x][y] != 2) {
                    queue.add(new int[] {x, y});
                    maze[x][y] = 2;
                }
            }
        }
        
        return false;
    }
}