// Using :BFS
// TC : O(M*N + K)
// SC : O(M*N)
public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    int m;
    int n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        m = maze.length;
        n = maze[0].length;

        dirs = new int[][]{{-1,0} , {0,1} , {1,0} , {0,-1}};

        Queue<Integer> q = new LinkedList<>();
        q.add(start[0]);
        q.add(start[1]);

        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs){
                int i = cr;
                int j = cc;
                while(i>=0 && j>=0 && i < m && j < n && maze[i][j] != 1){
                    i+=dir[0];
                    j+=dir[1];

                }
                i -=dir[0];
                j -=dir[1];
                if(i == destination[0] && j == destination[1]){
                    return true;
                }
                if(maze[i][j] != 2){
                    q.add(i);
                    q.add(j);
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}



// Using : DFS
// TC: O(M*N)
// SC : O(M*N)

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    int m;
    int n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        m = maze.length;
        n = maze[0].length;

        dirs = new int[][]{{-1,0} , {0,1} , {1,0} , {0,-1}};


        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        if(maze[start[0]][start[1]] == 2) return false;
        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs){
            int i = start[0];
            int j = start[1];
            while(i>=0 && j>=0 && i < m && j < n && maze[i][j] != 1){
                i+=dir[0];
                j+=dir[1];
            }
            i -=dir[0];
            j -=dir[1];  
            if(dfs(maze, new int[]{i,j}, destination)){
                return true;
            } 
        }
        return false;
    }

}