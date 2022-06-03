/*
Problem: https://leetcode.com/problems/the-maze/
TC: O(m * n)
SC: O(m * n)
*/

// Approach 1: BFS
class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}  
    };
    int n, m;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return false;
        }
        
        n = maze.length; m = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        
        while (!queue.isEmpty()) {
            int pos[] = queue.poll();
            for (int d[] : dirs) {
                int r = pos[0];
                int c = pos[1];
                
                while (r >= 0 && r < n && c >= 0 && c < m && maze[r][c] != 1) {
                    r = r + d[0];
                    c = c + d[1];
                }
                r = r - d[0];
                c = c - d[1];
                
                if (maze[r][c] != 2) {
                    if (r == destination[0] && c == destination[1]) {
                        return true;
                    }
                    
                    maze[r][c] = 2;
                    queue.add(new int[]{r, c});
                }
            }
        }
        
        return false;
    }
}

// Approach 2 : DFS
class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}  
    };
    int n, m;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return false;
        }
        
        n = maze.length; m = maze[0].length;
        
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        maze[start[0]][start[1]] = 2;
        
        for (int d[] : dirs) {
            int r = start[0];
            int c = start[1];
                
            while (r >= 0 && r < n && c >= 0 && c < m && maze[r][c] != 1) {
                r = r + d[0];
                c = c + d[1];
            }
            r = r - d[0];
            c = c - d[1];
                
            if (maze[r][c] != 2) {
                if (dfs(maze, new int[]{r, c}, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
