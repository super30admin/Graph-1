
// Time - O(M*N) * max(M,N)
// Space - O(M*N)




class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(maze == null) return false;
        int m = maze.length;
        int n = maze[0].length;

        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {start[0],start[1]}); // putting the start index element in the queue
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()) {
            int [] curr = q.poll();

            for(int [] dir : dirs) {

                int i = curr[0]; // polled element
                int j = curr[1];

                while(i < m && i >= 0 && j >= 0 && j < n && maze[i][j] != 1) { // check if it does not hit the wall and boundary conditions

                    i += dir[0];
                    j += dir[1];

                }
                // bring back one step
                i -= dir[0]; // it checks the wall and we need to bring our elements one step back
                j -= dir[1];

                if( maze[i][j] != 2) { // check if it is visited or not

                    if( i == destination[0] && j == destination[1]) return true;
                    q.add(new int[] {i,j});
                    maze[i][j] = 2; // mark if you are visiting it

                }
            }



        }

        return false;



    }
}