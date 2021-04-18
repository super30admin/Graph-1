// Time Complexity : O(m x n)
// Space Complexity : O(m x n )
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        while(!q.isEmpty()){
            int len = q.size();
            for(int i= 0; i <len; i++){
                int[] elem = q.poll();
                
                if(elem[0] == destination[0] && elem[1] == destination[1])
                    return true;

                for(int[] dir: dirs){
                    int r = elem[0] + dir[0];
                    int c = elem[1] + dir[1];
                    while( r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1 ){
                        r += dir[0];
                        c += dir[1];
                    }
                    if((r - dir[0]) == destination[0] && (c - dir[1]) == destination[1])
                        return true;
                    if(maze[r - dir[0]][c - dir[1]] == 0){
                        q.add(new int[]{r - dir[0], c - dir[1]});
                        maze[r - dir[0]][c - dir[1]] = 2;
                    }
                    
                }
            }
        }
        return false;
    }
}
