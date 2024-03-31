//BFS

// Time Comlexity - O((m*n)+(m+n)), both the terms are inversely proportional. As worst case of while loop is having no walls only boundaries
//which is best case for addding elements in queue. worst case: O(m*n).
// Space Complexity - O(max(m,n)) for BFS as at worst we may have all the elements of the row in the queue
// Did this code successfully run on Leetcode : yes
// Approach: DFS or BFS in the four directions till you hit a wall
// and do the same from there. Mark visited nodes and if you reach destination
// return true;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; //mark it visited
        int [][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];

                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }

                //step back - as this is the stopage
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]){
                    return true;
                }
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }

        return false;
    }
}


//DFS
// Time Comlexity - O((m*n)+(m+n))
// Space Complexity - O(max(m,n)) for BFS as at worst we may have all the elements of the row in the queue
// Did this code successfully run on Leetcode : yes
// Approach: DFS or BFS in the four directions till you hit a wall
// and do the same from there. Mark visited nodes and if you reach destination
// return true;

class Solution {
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int [][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        return dfs(maze,start,destination,dirs);

    }

    private boolean dfs(int[][] maze, int[] start, int[] destination,int [][] dirs){
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs){
            int r = start[0];
            int c = start[1];

            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }

            //step back - as this is the stopage
            r -= dir[0];
            c -= dir[1];


            if(maze[r][c] != 2 && dfs(maze,new int[]{r,c}, destination,dirs)){
                return true;
            }
        }

        return false;
    }
}