// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Maze {
    class Solution {
        private int[][] dirs;
        private int m;
        private int n;
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if(Arrays.equals(start, destination)) return true;
            m = maze.length;
            n = maze[0].length;
            dirs = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
            Queue<Integer> rowQ = new LinkedList<>();
            Queue<Integer> colQ = new LinkedList<>();

            rowQ.add(start[0]);
            colQ.add(start[1]);
            maze[start[0]][start[1]] =  2;

            while(!rowQ.isEmpty()) {
                int r = rowQ.poll();
                int c = colQ.poll();
                for(int[] dir :  dirs)  {
                    int dr = r;
                    int dc = c;
                    //check if it is  the destination
                    if(dr == destination[0] && dc == destination[1])
                        return true;

                    while(dr >= 0 && dc >=0 && dr < m && dc < n && maze[dr][dc] != 1){
                        dr += dir[0];
                        dc += dir[1];
                    }
                    dr-=dir[0];
                    dc-=dir[1];

                    //check if vsited
                    if(maze[dr][dc] != 2) {
                        rowQ.add(dr);
                        colQ.add(dc);
                        maze[dr][dc] = 2;
                    }
                }
            }

            return false;
        }
    }
}
