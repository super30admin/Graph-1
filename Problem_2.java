// Time Complexity : O(mn) + O(kp)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// go to each direction and check if the end exits or not
// Your code here along with comments explaining your approach
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if( maze == null ) return false;
        int m = maze.length; int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int [][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int iIndex = curr[0];
            int jIndex = curr[1];
            while(iIndex < m && jIndex <n && iIndex >= 0 && jIndex >=0 && maze[iIndex][jIndex] != 1){
                iIndex = iIndex + dir[0];
                jIndex = jIndex + dir[1];
            }
            // comaback one step
            iIndex = iIndex - dir[0];
            jIndex = jIndex - dir[1];
            // mark visited
            if(maze[iIndex][jIndex] == 0){
                if( iIndex == destination[0] && jIndex == destination[1]) return true;
                maze[iIndex][jIndex] = 2;
                q.add(new int[]{iIndex,jIndex});
            }
        }
        return false;
    }
}