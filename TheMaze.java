// TC = O((m * n) * (m + n)) 
// SC = O(m + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// DFS - TC = O((m * n) * (m + n)), SC = O(m + n)
// class Solution {
//     int m, n;
//     int[][] dirs;
    
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         if(maze == null || maze.length == 0) return false;
//         m = maze.length;
//         n = maze[0].length;
//         dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
//         return dfs(maze, start, destination);
//     }

//     private boolean dfs(int[][] maze, int[] start, int[] destination) {
//         // base
//         if(start[0] == destination[0] && start[1] == destination[1]) {
//             return true;
//         }
//         // logic
//         maze[start[0]][start[1]] = 2;
//         for(int[] dir: dirs) {
//             int nr = start[0];
//             int nc = start[1];
//             while((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && maze[nr][nc] != 1) { // keep the ball rolling until it hits boundary or wall
//                 nr  = nr + dir[0];
//                 nc  = nc + dir[1];
//             }
//             nr = nr - dir[0]; // bring the ball back to a valid cell, as while loop breaks on the invalid condition
//             nc = nc - dir[1]; // undo last action
//             if(maze[nr][nc] != 2) { // not visited
//                 if(dfs(maze, new int[] {nr, nc}, destination)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// BFS - TC = O((m * n) * (m + n)), SC = O(m + n)
class Solution {
    int m, n;
    int[][] dirs;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for(int[] dir: dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                while((nr >= 0 && nr < m) && (nc >= 0 &&nc < n) && maze[nr][nc] != 1) { // keep rolling // O(m + n)
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0]; // bring back
                nc = nc - dir[1];
                if(maze[nr][nc] != 2) {
                    q.add(new int[] {nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }   
        return false;
    }
}