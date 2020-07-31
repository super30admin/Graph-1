// Time Complexity - O(mn)
// Space Complexity - O(mm) for BFS it is total no of elements in the queue, for DFS = height of stack

// Approach -
// In BFS, Add starting point into queue and we traverse from that cell and select next children when we 
// reach either out of bound or wall. When we reach the wall, we move to previous cell and enter the new children into queue.
// We mark the place as 2 to indicate that it is already visited. If we reach destination, return true - otherwise false.

import java.util.Queue;
// BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2; // mark as visited
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir:dirs) {
                int r = curr[0];
                int c = curr[1];
                if(r==destination[0] && c==destination[1]) return true; // reached end point
                // move the ball until we reach out of bounds or wall
                while(r<maze.length && c<maze[0].length && r>=0 && c>=0 && maze[r][c]!=1) { 
                    r+=dir[0];
                    c+=dir[1];
                }
                // move to previous cell
                r-=dir[0];
                c-=dir[1];
                if(maze[r][c]!=2) {
                    maze[r][c]=2; // mark as visited if its not yet visited
                    q.add(new int[]{r,c}); // add the cell to queue
                }
            }
        }
        return false; // couldnt reach end
    }
}

// DFS

class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int r=0,c=0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        maze[start[0]][start[1]]=2; // mark as visited
        return dfs(maze,start,destination);
    }

    private boolean dfs(int[] maze,int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        for(int[] dir:dirs) {
            int r = start[0];
            int c = start[1];
            while(r<maze.length && c<maze[0].length && r>=0 && c>=0 && maze[r][c]!=1) {
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            if(maze[r][c]!=2) {
                maze[r][c]=2;
                if(dfs(maze,new int[]{r,c},destination)) return true;
            }
        }
        return false;
    }
}