// Time Complexity : O(2mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//BFS : Using Queue
//TC : O(2mn)
//SC : O(mn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        //use queue to add visited cells position, and then check 4 neighbors
        Queue<int []> q = new LinkedList<>();
        //add the starting position
        q.add(start);
        //mark is visited, make the value 2
        maze[start[0]][start[1]] = 2;
        //dirs array
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        //while q is not empty
        while(!q.isEmpty()) {
            //get the curr front of queue position
            int[] curr = q.poll();
            //visit the neighbors (that are near walls)
            for(int[] dir : dirs) {
                //get new r and c value
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                //increase r and c such that it does not encounter a wall (ball stops only at wall)
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                //in the while loop r and c reach wall (1)
                //we need prev position, so decrease r and c by 1
                r -= dir[0];
                c -= dir[1];
                //if its not visited mark it visited and add to queue
                if(maze[r][c] != 2){
                    q.add(new int[] {r,c});
                    maze[r][c] = 2; 
                }
                //check if this position is destination, if yes, return true 
                //we can check when polling as well, as also given start =! destination, so we can check here
                if(r == destination[0] && c == destination[1]) {
                    return true;
                }         
            }         
        }
        //if no value of r and c is destination, return false
        return false;     
    }
}

////////////////////////////////

// Time Complexity : O(mn)
// Space Complexity : stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DFS

//DFS : Recursion
//TC : O(mn)
//SC : stack space
class Solution {
    //global variables : maze size and dirs array
    int m;
    int n;
    int[][] dirs; 
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        //dirs array
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        //make visited cells = 2
        maze[start[0]][start[1]] = 2; 
        //return value of helper method
        return hasPathHelper(maze, start, destination); 
    }
    
    private boolean hasPathHelper(int[][] maze, int[] start, int[] destination) {
        //base case : if start = destination, return true
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        //iterate the 4 neighbors till wall
        for(int[] dir : dirs) {
            //get new start value (r, c)
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];
            //move until wall
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            //reaches 1, we need prev cell position so sub 1 from each r and c
            r -= dir[0];
            c -= dir[1];
            //check if its visited, if yes, check next neighbor,
            //if no, mark visited and call helper method on the new start position
            //if the helper method returns true, return true
            if(maze[r][c] != 2) {
                maze[r][c] = 2; 
                if(hasPathHelper(maze, new int[] {r,c}, destination)) {
                    return true;
                }
            }   
        }
        //after checking all cell positions if none returns true, return false
        return false;
    }
}
