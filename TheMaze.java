// bfs
public class TheMaze {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        dirs = new int[][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;
            for(int[] dir:dirs){
                int i = curr[0];
                int j = curr[1];
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];

                if(maze[i][j]!=2){
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)


// dfs
public class TheMaze {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        return dfs(maze,start,destination);
    }
    private boolean dfs(int[][] maze, int[] curr, int[] destination){
        // base
        if(maze[curr[0]][curr[1]]==2) return false;
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true;

        // logic
        maze[curr[0]][curr[1]] = 2;
        for(int[] dir:dirs){
            int i = curr[0];
            int j = curr[1];
            while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                i += dir[0];
                j += dir[1];
            }
            i -= dir[0];
            j -= dir[1];
            
            if(dfs(maze, new int[]{i,j}, destination)) return true;
        }
        return false;
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)