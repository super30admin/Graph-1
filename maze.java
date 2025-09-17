//TC: O(m·n) — each DFS/BFS step may roll across a row/column, and each cell is settled once.
//SC: O(m·n) worst-case for recursion/visited marking.

//From the start, roll in each of the 4 directions until hitting a wall, stop just before the wall.
//Recursively DFS from that stopping cell if not already visited.
//If you ever reach the destination, return true; if all paths fail, return false.

class Solution {
    int[][] dirs;
    int m,n;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        return dfs(maze, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination){
        //base case
        if(destination[0] == i && destination[1] == j) return true;

        if(maze[i][j] == -1) return false;
        
        maze[i][j] = -1;
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];
            if(dfs(maze, r, c, destination)) return true;
        }

        return false;
    }
}
