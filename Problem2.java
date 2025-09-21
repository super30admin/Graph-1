
//Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the maze
//Space Complexity: O(m*n) in the worst case we might have to store all the elements in the queue

//BFS approach
//we use a queue to keep track of the cells to be processed
//we also use a directions array to keep track of the 4 possible directions we can move in
//we start from the start cell and mark it as visited by changing its value to -1
//we then process each cell in the queue and for each cell we try to move in all 4 directions until we hit a wall or the boundary of the maze
//we then check if the cell we reached is the destination cell, if yes we return true

class Solution {
    int[][] dirs;
    int m,n;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != -1){
                    q.add(new int[]{r,c});
                    maze[r][c] = -1;
                }
            }
        }

        return false;
    }
}
