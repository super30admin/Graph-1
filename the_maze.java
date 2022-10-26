// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int []> q = new LinkedList <>();

        int [][] dirs = {{0,1},{1,0}, {0, -1}, {-1, 0}};

        q.offer(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==destination[0] && curr[1] == destination[1]) return true;

            for(int[] dir : dirs){
                int i = curr[0];
                int j = curr[1];

                while(i<m && i>=0 && j<n && j>=0 && maze[i][j]!=1){
                    i=i+dir[0];
                    j=j+dir[1];
                }

                i=i-dir[0];
                j=j-dir[1];

                if(maze[i][j]!=2){
                    q.offer(new int[]{i,j});
                    maze[i][j]=2;
                }
            }
        }
        return false;
    }
}