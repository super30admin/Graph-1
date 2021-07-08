// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We do a BFS, ovr the Maze to check if there is a valid path.
*/

class Solution {
    boolean visited[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int n=maze.length, m=maze[0].length;

        visited = new boolean[n][m];

        Queue<int[]> queue= new LinkedList<>();

        queue.offer(new int[]{start[0],start[1]});

        int dirs[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            visited[curr[0]][curr[1]] = true;

            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;

            for(int[] dir:dirs){
                int x = curr[0], y = curr[1];
                while( x+dir[0]<n && x+dir[0]>=0 
                        && y+dir[1]<m && y+dir[1]>=0 
                        && maze[x+dir[0]][y+dir[1]]!=1 ){
                    x=x+dir[0];
                    y=y+dir[1];
                }
                if(visited[x][y]==false){
                    queue.offer(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
        }
        return false;
    }

}