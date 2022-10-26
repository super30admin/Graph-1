// Time Complexity : O(mn)
// Space Complexity : O(mn)
// m is the number of rows
// n is the number of columns
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//BFS Approach
// TC: O(m*n)
// SC: O(m*n)
// m is the number of rows
// n is the number of columns
class Solution {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;

        //null check
        if(maze == null || maze.length == 0)
            return false;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; //marking it visited

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir: dirs){
                int i = curr[0];
                int j = curr[1];

                //go tillyou find a wall
                while(i >= 0 && j >= 0 && i < m && j <n && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                //since we hit a wall, get the position 1 step behind. Undo you traversal using dir array by 1 step
                i -= dir[0];
                j -= dir[1];

                //add to queue only if its not visited
                if(maze[i][j] !=2){
                    if(i == dest[0] && j == dest[1])
                        return true;
                    q.add(new int[]{i,j}); //add to queue
                    maze[i][j] = 2;  //marking it visited
                }
            }
        }
        return false;
    }
}

//DFS
// TC: O(m*n)
// SC: O(m*n)
// m is the number of rows
// n is the number of columns
class Solution {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;

        //null check
        if(maze == null || maze.length == 0)
            return false;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        return dfs(maze,start,dest);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] dest){
        //base case
        if(maze[curr[0]][curr[1]] == 2)
            return false;
        if(curr[0] == dest[0] && curr[1] == dest[1])
            return true;

        //logic
        maze[curr[0]][curr[1]] = 2; //marking it visited
        for(int[] dir: dirs){
            int i = curr[0];
            int j = curr[1];

            //go tillyou find a wall
            while(i >= 0 && j >= 0 && i < m && j <n && maze[i][j] != 1){
                i += dir[0];
                j += dir[1];
            }
            //since we hit a wall, get the position 1 step behind. Undo you traversal using dir array by 1 step
            i -= dir[0];
            j -= dir[1];

            if(dfs(maze,new int[]{i,j},dest))
                return true;
        }
        return false;
    }
}


