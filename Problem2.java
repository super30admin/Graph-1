import java.util.LinkedList;
import java.util.Queue;

// DFS Approach
// Time Complexity :O(mXn) 
// Space Complexity :O(mXn)
// Did this code successfully run on Leetcode : Don't have leetcode premium 
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1. Have a visited 2d boolean matrix to keep track of bloacks visited.Now check if start equals destination and return true
// 2. Else,traverse through 4 directions and stop at each block if maze[i][j] == 1 . If current position of ball is visited or out of bounds of 
//    of maze , return false.Now check if it is destination and return true. Else traverse again from these blocks you stopped at after 
//    traversing and mark all visited blocks as true to stop repeating same blocks again.
// 3. If no true solution is found , it means the ball cannot stay at that block and it will keep rolling.So, return false.
public class mazeProblem {
    public static boolean hasPath(int[][] maze,int[] start,int[] destination){
        if(maze.length == 0 || start.length == 0 || destination.length == 0)    return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze,visited,start,destination);
    }

    public static boolean helper(int[][] maze,boolean[][] visited,int[] start,int[] destination){
        int r = start[0],c = start[1];
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || visited[r][c] ) return false;
        if(r == destination[0] && c == destination[1])  return true;
        visited[r][c] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int k = 0;k<dirs.length;k++){
            int i = r,j = c;
            while(i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]==0){
                i += dirs[k][0];
                j += dirs[k][1];
            }
            i -= dirs[k][0];
            j -= dirs[k][1];
            if(helper(maze,visited,new int[]{i,j},destination)) return true;
        }
        return false;
    }
    // BFS Approach
    // Time Complexity :O(mXn) 
    // Space Complexity :O(mXn)
    // Did this code successfully run on Leetcode : Don't have leetcode premium 
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. Have a visited 2d boolean matrix to keep track of bloacks visited.Now check if start equals destination and return true
    // 2. Use a queue to store all possible ways of ball rolling.Now push starting block into queue.
    // 3. Poll top element and queue and check if it is destination and return true. Else traverse through all 4 directions and push all 
    //    possible blocks where ball comes to stop while traversing into queue and mark all these blocks as visited.
    // 4. repeat step 3 and if current block is visited move on to next element and repeat same process from step 3 till a solution is found.
    //    If all possible ways are exhausted/checked return false.
    
    public static boolean hasPath2(int[][] maze,int[] start,int[] destination){
        if(maze.length == 0 || start.length == 0 || destination.length == 0)    return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0],c = temp[1];
            if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || visited[r][c])  continue;
            if(r == destination[0] && c == destination[1])  return true;
            visited[r][c] = true;
            for(int k = 0;k<dirs.length;k++){
                int i = r,j = c;
                while(i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]==0){
                    i += dirs[k][0];
                    j += dirs[k][1];
                }
                i -= dirs[k][0];
                j -= dirs[k][1];
                queue.add(new int[]{i,j});
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] end = {3,2};
        System.out.println(hasPath(maze,start,end));
        System.out.println(hasPath2(maze,start,end));
    }
}
