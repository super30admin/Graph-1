// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null||maze.length==0)
            return false;
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int[] dir:dirs){
                int r = curr[0];
                int c = curr[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                    r = dir[0]+r;
                    c = dir[1]+c;
                }
                r = r-dir[0];
                c = c-dir[1];
                if(maze[r][c]!=2){
                    if(r==destination[0]&&c==destination[1])
                    return true;
                    q.add(new int[]{r,c});
                    maze[r][c]=2;
                }
            }
        }
        return false;
    }
}
