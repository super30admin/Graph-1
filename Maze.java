//time complexity : O(nXm) n, m = dimenstions of the maze
//space complexity : O(1)

class Solution {

    //BFS

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(maze == null || maze.length == 0)
            return false;

        Queue<int[]> q = new LinkedList();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        //put start in queue
        q.add(start);

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            //check if curr is destination
            if(curr[0]==destination[0] && curr[1]==destination[1])
                return true;

            //go to neighbors
            for(int[] d : dirs) {
                int i = curr[0];
                int j = curr[1];
                //the ball will keep moving until it hits a boundary or an obstacle
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j] != 1) {
                    i += d[0];
                    j += d[1];
                }
                //move one step back when a boundary or obstacle is reached
                i -= d[0];
                j -= d[1];

                //mark visited if not already done so and put in queue
                if(maze[i][j] != 2) {
                    maze[i][j] = 2;
                    q.add(new int[] {i,j});
                }
            }
        }

        //queue finished but we did not reach destination
        return false;

    }
}
