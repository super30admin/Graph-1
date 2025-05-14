// Time Complexity : O(m * n), m-number of rows, n-number of columns
// Space Complexity : O(m * n), for queue and visited markings
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use BFS to explore all directions by moving the ball until it hits a wall.
// If the ball lands at unvisited cell, mark it visited and add it to the queue.
// Return true if the ball reaches destination cell otherwise return false.

import java.util.*;
class Solution {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m=maze.length;
        this.n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=-1;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dir:dirs){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];
                if(r==destination[0] && c==destination[1]) return true;
                if(maze[r][c]!=-1){
                    q.add(new int[]{r,c});
                    maze[r][c]=-1;
                }
            }
        }
        return false;
    }
}

// Time Complexity : O(m * n), 
// Space Complexity : O(m * n), recursion stack
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use DFS to recursively explore all directions from the current cell by moving the ball until it hits a wall.
// If the ball stops at an unvisited cell, mark it visited and continue the search.
// Return true if the destination is reached during any recursive call.

class Solution2 {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m=maze.length;
        this.n=maze[0].length;
        return dfs(maze,start[0],start[1],destination);
    }
    private boolean dfs(int[][] maze,int i,int j,int[] destination){
        if(maze[i][j]==-1) return false;
        if(i==destination[0] && j==destination[1]) return true;
        maze[i][j]=-1;
        for(int[] dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            if(dfs(maze,r,c,destination)) return true;
        }
        return false;
    }
}