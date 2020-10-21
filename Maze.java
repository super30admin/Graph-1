/*
 * #490. The Maze
 * 
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

 

Example 1:
Refer image from leetcode

Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:
Refer image from leetcode

Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.

Example 3:

Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: false
 

Constraints:

1. 1 <= maze.length, maze[i].length <= 100
2. maze[i][j] is 0 or 1.
3. start.length == 2
4. destination.length == 2
5. 0 <= startrow, destinationrow <= maze.length
6. 0 <= startcol, destinationcol <= maze[i].length
7. Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
8. The maze contains at least 2 empty spaces.

 */

/*
 * Time Compelxity: O (m * n) -> In worst case, we will end up traversing whole 2D array to find a path to destination
 * 
 * Space Complexity: O (n) -> At a time, recursive stack will store 'n' cells in a path in particular direction
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.graph1;

public class Maze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        // #1. Base condition
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        
        // #2. Call the recursive function, return either true or false
        return recurr(maze, start, destination);
        
    }
    
    // Global directions array to move either up, down, left or right
    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    
    
    // Reucrsive function
    public boolean recurr(int[][] maze, int[] start, int[] destination){
        
        // Take new starting point's row and column indices everytime in x and y
        int x = start[0];
        int y = start[1];
        
        
        // # Base case, to stop recursion
        /*
        *   If new starting point's row and column indices are same as destination's, 
        *   we have found our path to destination, return true
        */
        if(x == destination[0] && y == destination[1]){
            return true;
        }
        
        // Recursive case
    
        // Explore all four directions 
        for(int[] dir : dirs){
            // Take starting point's row index in r, column index in c
            int r = x;
            int c = y;
            
            // Keep rolling the ball -> traverse in a particular direction until we hit a wall or indices are out of bounds
            while(r + dir[0] >= 0 && r + dir[0] < maze.length && c + dir[1] >= 0 && c + dir[1] < maze[0].length
                 && maze[r + dir[0]][c + dir[1]] != 1)
            {
                r = r + dir[0];
                c = c + dir[1];
            }
            
            // We hit a wall, and the starting point I am right now is already marked visited, say maze[r][c] = 2
            // then, continue, means explore other direction becuase we know that we will not find destination on the same path traversed earlier(starting point marked visited)
            if(maze[r][c] != 0){
                    continue;
            }
            
            // If we hit a wall, and the new strating point is not yet marked visited, mark it as visited
            maze[r][c] = 2;
            
            
            // Recursion
            if(recurr(maze, new int[] {r,c}, destination))
                return true;
        }
        
        // not found the path to destination, return false
        return false;
        
    }
    
}
