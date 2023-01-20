// The Maze

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

// BFS

class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; // Mark it as visited
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                // Mark the previous cell as visited and add it to the queue
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1])
                    return true;
                if(maze[r][c] == 0){
                    q.add(new int[]{r, c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}