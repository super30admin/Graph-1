class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(start);

        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};

        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            for(int[] dir : dirs)
            {
                int row = curr[0]+dir[0];
                int col = curr[1]+dir[1];

                while(row>=0 && row<maze.length && col>=0 && col<maze[0].length && maze[row][col]!=1)
                {
                    row += dir[0];
                    col += dir[1];
                }

                row -= dir[0];
                col -= dir[1];

                if(row == destination[0] && col == destination[1]) return true;

                if(maze[row][col] != 2)
                {
                    q.offer(new int[]{row,col});
                    maze[row][col] = 2;
                }

            }
        }

        return false;
    }
}
