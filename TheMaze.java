// Time: O(K*(MN)) | Space: O(MN)

//DFS

class Solution {
    private int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int sr = start[0];
        int sc = start[1];
        int dr = destination[0];
        int dc = destination[1];

        if(sr == dr && sc == dc) return true;
        return dfs(maze, sr, sc, destination);
    }
    private boolean dfs(int[][] maze, int r, int c, int[] destination) {
        if(r == destination[0] && c == destination[1]) return true;
        maze[r][c] = 2;
        for(int[] dir: dirs) {
            // we should keep going the same direction until we hit the hurdle or corner
            int i=r;
            int j=c;
            while(i >=0 && i<m && j>=0 && j<n && maze[i][j] != 1) {
                i+= dir[0];
                j+=dir[1];
            }
            // once we hit the hurdle or corner, we step back one step, because our while loops stops at the breaching place only
            i-= dir[0];
            j-= dir[1];
            // we should explore the other direction as well, as long as it's not already visited
            if(maze[i][j] != 2 && dfs(maze, i, j, destination)) return true;
        }
        return false;
    }
}

// BFS

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int sr = start[0];
        int sc = start[1];
        int dr = destination[0];
        int dc = destination[1];
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        if(sr == dr && sc == dc) return true;
        maze[sr][sc] = 2;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        while(!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir: dirs) {
                int i=cr;
                int j=cc;
                while(i >=0 && i<m && j>=0 && j<n && maze[i][j] != 1) {
                    i+= dir[0];
                    j+=dir[1];
                }
                i-= dir[0];
                j-= dir[1];
                if(dr == i && dc == j) return true;
                if(maze[i][j] != 2) {
                    q.add(i);
                    q.add(j);
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}