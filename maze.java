// Time Complexity : O(mn) mn is the size of maze
// Space Complexity : O(mn) mn is the size of maze because a node will go only once in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int [][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int [] dir:dirs){
                int i = curr[0]; int j = curr[1];
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(maze[i][j]!=2){
                    if(i==destination[0] && j==destination[1]) return true;
                    q.add(new int[]{i,j});
                    maze[i][j]=2;
                }
            }
        }

        return false;
    }

    public static void main(String [] args){
        Maze m = new Maze();
        System.out.println(m.hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},
                new int[]{0,4}, new int[]{4,4}));
    }
}