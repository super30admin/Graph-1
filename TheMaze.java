/*
----------------------------------------------------------- PROBLEM STATEMENT ---------------------------------------------------------
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/

// "static void main" must be defined in a public class.
public class Main {
    
    // Time Complexity: O(mn)   (where m -> no. of rows and n -> no. of cols)
    // Space Complexity: O(maximum possible stops) -- O(mn)
    
    private static int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, destination, start[0], start[1]);
    }
    
    private static boolean dfs(int[][] maze, int[] dest, int i, int j){
        // Condition to check if its already visited
        if(maze[i][j] == 2)
            return false;
        
        // Condition to check if we have reached destination
        if(i == dest[0] && j == dest[1])
            return true;
        
        maze[i][j] = 2;
        for(int[] dir: dirs){
            int row = i;
            int col = j;
            
            // Keep rolling the ball - till we hit the wall or go out of bounds
            while(row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1){
                row = row + dir[0];
                col = col + dir[1];
            }
            
            // We come back one step back - because our while loop will break when we hit the wall
            row = row - dir[0];
            col = col - dir[1];
            
            // Now check if we have reached the destination
            if(dfs(maze, dest, row, col))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}};
        int[] start = {0,4};
        int[] destination = {4,4};
        
        System.out.println(hasPath(maze, start, destination));
    }
}