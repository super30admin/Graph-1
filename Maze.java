// Time Complexity : 
/*                  APPROACH 1 : BFS: O(n) where n is the number of elements in the matrix
                    APPROACH 2 : DFS: O(n) where n is the number of elements in the matrix
// Space Complexity : 
/*                  APPROACH 1 : BFS: O(n) where n is the number of elements in the queue at a certain instant
                    APPROACH 2 : DFS: O(n) n recursive calls for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult problem because for BFS/DFS the children are not the very next element, they are the ones where the ball stops
/* Your code here along with comments explaining your approach:  In the BFS approach, we enter the cell as the starting point in the queue. Then
we start traversing from that cell and we select the next children when we reach either the out of bounds or we reach the wall. As we reach the wall
we take a step back and enter the new children into the queue because this is the point where the ball stops as per the question. Else the ball is moving
back and forth. We mutate the matrix when we visit a stopped place , we mark that place as 2 to avoid a revisit. As we reach the destination, we return
true since we have reached the goal else we return false as we have gone to all the possible bounds but we couldnt land up on the destination.
*/
// BFS APPROACH
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null | maze.length == 0){return true;}
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;                                                           // Mark the start cell as visited
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};                                                      // To move to all possible directions
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){          
                int r = curr[0];
                int c = curr[1];
                while(r < maze.length && c < maze[0].length && r>=0 && c>=0
                    && maze[r][c] != 1){                                                                        // Move the ball till it reaches out of the bounds or the wall
                    r +=dir[0];
                    c +=dir[1];
                }
                r-=dir[0];                                                                                  // Take a step back since we have reached the bounds
                c-=dir[1];
                if(maze[r][c] != 2){                                                                            // Mark the cell visited where we have stopped
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});                                                                      // Add the cell to the queue to further explore this cell
                }
                if(r == destination[0] && c == destination[1]){                                                 // Destination reached!
                    return true;
                }
            }
        }
        return false;                                                                                           // Couldn't land up in the destination
    }
}

// DFS APPROACH
class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};                                                      // Dirs array to move in all directions
    int r = 0;
    int c = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null | maze.length == 0){return true;}
        maze[start[0]][start[1]] = 2;                                                                                   // Mark the start cell as visited
        return dfs(maze, start, destination);                                                                           // Let's roll
    }   
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1]){                                                   // Destination found
            return true;
        }
        for(int[] dir: dirs){
            r = start[0];
            c = start[1];
            while(r < maze.length && c < maze[0].length && r >=0 && c >=0 && maze[r][c] != 1){                                      // Move till you reach the bounds or a wall
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];                                                                                                  // Take a step back
            c-=dir[1];
            if(maze[r][c] != 2){
                maze[r][c] = 2;                                                                                             // Mark the cell as visited
                if(dfs(maze, new int[]{r,c}, destination)){return true;}                                                 // start the dfs from the new coordinates r and c 
            }
            }
        return false;                                                                                                   // Couldn't find the destination
    }
}