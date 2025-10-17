// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Using BFS traversal we start by adding the start cell in the queue
//we then traverse  up, down right and left of the maze until we find a wall and add them into the queue
//To prevent the visit of same cell again we mark the cells as visited whenever its being added to the queue
//If the destination is present inside the queue we return true

import java.util.*;
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int [][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        Queue<int []> q = new LinkedList<>();
        q.add(start);//add the start indices into the queue (0.4)
        maze[start[0]][start[1]] = 2; //mark the start indices as visited ie 0,4 is visited
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int r = cur[0];
                int c = cur[1];
                //the next 0 to go in the queue is not the immediate neighbour but the one above the obstacle or wall
                while(r < m && r >=0 && c>=0 && c< n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                //check if r and c are the destination
                if(r== destination[0] && c == destination[1]) return true;
                //only if the neighbours are not marked visited add them to queue
                if(maze[r][c] !=2) {
                    maze[r][c]= 2;
                    q.add(new int[]{r,c});
                }
            }
            
        }
        return false;
        
    }
}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };

        int[] start = {0, 4};
        int[] destination = {4, 4};

        boolean result = sol.hasPath(maze, start, destination);
        System.out.println(result);
    }
}
