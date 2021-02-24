// Time Complexity : O(mn) 
// Space Complexity : O(n) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// BFS approach -
//Mark a node as visited by changing 0 to 2.

class Solution {


    int m;
    int n;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0} , {-1,0}};



    public boolean hasPath(int[][] maze, int[] start, int[] destination) {


        if(maze == null || maze.length == 0) return false;

        Queue<int[]> queue = new LinkedList();
        queue.add(start);


        int m = maze.length;
        int n = maze[0].length;

        maze[start[0]][start[1]] = 2;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == destination[0] && cur[1] == destination[1])
                return true;

            for(int[] dir : dirs) {
                int r = cur[0];
                int c = cur[1];
                while((r >=0 && r < m && c >= 0 && c < n) && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(maze[r][c] == 0) {
                    queue.add(new int[]{r, c});
                    maze[r][c] = 2;
                }

            }

        }
        return false;

    }
}
