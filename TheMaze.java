//BFS
//time o(mn)
//space o(m+n) //queue can occupy max breadth of the matrix
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            for(int[] dir: dirs) {
                int r = cur[0];
                int c = cur[1];
                while(r>=0 && r<maze.length && c>=0 &&
                        c<maze[0].length && maze[r][c] != 1) {
                    r = r+ dir[0];
                    c=  c + dir[1];
                }
                //you will be crossing the border so subtract row and col by 1
                r = r - dir[0];
                c = c - dir[1];
                if(maze[r][c] != 2) {
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}

//DFS
//time o(mn)
//space o(mn) //stack can occupy most of the elements in worst case
class Solution {
    int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}};
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return true;
        m = maze.length;
        n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        //base case
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        //logic
        for(int[] dir: dirs) {
            int r = start[0];
            int c = start[1];
            while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                r = r+ dir[0];
                c = c+ dir[1];
            }
            //we will be crossing the border, comeback
            r = r - dir[0];
            c = c - dir[1];
            if(maze[r][c] != 2) {
                maze[r][c] = 2;
                if(dfs(maze, new int[]{r,c}, destination))
                    return true;
            }
        }
        return false;
    }
}