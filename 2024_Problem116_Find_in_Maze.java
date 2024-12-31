//490. The Maze - https://leetcode.com/problems/the-maze/description/
//Time Complexity: O(m*n)
//Space Complexity: O(1) ~ no extra space used

class Solution {
    int[][] dirs;
    int m,n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //edge case
        m = maze.length;
        n = maze[0].length;
        if(maze == null || m == 0)
            return false;

        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2; //marked visited

        //O(m*n)
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                //O(m+n)
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r += dir[0]; //roll in the same direction
                    c += dir[1]; //roll in the same direction
                }
                r -= dir[0]; //since hit the wall, come 1 step back
                c -= dir[1]; //since hit the wall, come 1 step back

                if(r == destination[0] && c == destination[1]){
                    return true; //reached destination
                }
                if(maze[r][c] != 2){ //not visited
                    q.add(new int[]{r,c}); //add children to queue
                    maze[r][c] = 2;
                }
            }
        }
        return false;

    }
}
