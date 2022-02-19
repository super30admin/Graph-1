// Time Complexity : O(mn), where m is the no of rows and n is the no of columns
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - DFS
class Solution {
    int[][] dirs;
    int r;
    int c;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][]{{-1,0}, {1,0}, {0,1},{0,-1}};
        r = maze.length;
        c = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;

        if(visited[start[0]][start[1]]) return false;
        visited[start[0]][start[1]] = true;
        for(int[] d : dirs) {
            int nr = start[0] + d[0];
            int nc = start[1] + d[1];
            while(nr >= 0 && nr < r && nc >= 0 && nc < c && maze[nr][nc] != 1){
                nr += d[0];
                nc += d[1];
            }
            nr = nr - d[0];
            nc = nc - d[1];

            if(dfs(maze, new int[]{nr, nc}, destination, visited)) return true;

        }
        return false;
    }
}

// Time Complexity : O(mn), where m is the no of rows and n is the no of columns
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - BFS
class Solution {
    int[][] dirs;
    int r;
    int c;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][]{{-1,0}, {1,0}, {0,1},{0,-1}};
        r = maze.length;
        c = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        return bfs(maze, destination, visited, q);
    }

    public boolean bfs(int[][] maze, int[] destination, boolean[][] visited, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] start = q.poll();
            if(start[0] == destination[0] && start[1] == destination[1])
                return true;

            for(int[] d : dirs) {
                int nr = start[0] + d[0];
                int nc = start[1] + d[1];
                while(nr >= 0 && nr < r && nc >= 0 && nc < c && maze[nr][nc] != 1){
                    nr += d[0];
                    nc += d[1];
                }
                nr = nr - d[0];
                nc = nc - d[1];
                if(!visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
}