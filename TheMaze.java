//BFS approadh
import java.util.Queue;

class Solution{

    //Time Complexity: 0(m*n) where m is the rows and n is the columns
    //Space Complexity: 0(m*n)
    //Did it successfully run on leetcode: No(I don't have leetcode premium)
    //Did you face any problem while coding : No

    //In brief explain your approach

    public boolean hasPath(int [][] maze, int [] start, int [] destination){
        if(maze == null || maze.length == 0){
            return false;
        }
        Queue<int[]> q = new Queue<>(); //declaring a queue for bfs
        int[][] dirs = {(-1,0), (0,-1), (1,0), (0,1)};  //declaring a direction array to traverse in all 4 directions
        int m = maze.length;
        int n = maze[0].length;
        q.add(new int []{start[0], start[1]});  //adding the stating point to the queue
        maze[start[0]][start[1]] = 2;   //marking it as visited
        while(!q.isEmpty()){
            int [] curr = q.poll(); //removing the top element in the queue
            for(int [] dir : dirs){ //traversing in the possible direction
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < m && maze[r][c] != 1){   //rolling the ball to the end of the maze of till it hits an obstace i.e. 1
                    r = r + dir[0];
                    c = c + dir[1];
                }
                r = r - dir[0]; //since when we come out of the while loop, the index of the ball will be 1 greater so adjusting the same
                c = c - dir[1];
                if(maze[r][c] != 2){    //if the index where the ball is is not visited earlier
                    if(r == destination[0] && c == destination[1]){ //and if the coordinates are the same as the destination
                        return true;    //we return true
                    }
                    maze[r][c] == 2;    //if not, we mark the index as visited
                    q.add(new int[] {r,c}); //and add it to the queue
                }
            }
        }
        return false;   //if we don't return true, means that the ball cannot reach the destination hence returning false
    }
}

//DFS approach

class Solution {
    int m, n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = {(-1,0), (0,-1), (1,0), (0,1)};  //declaring a direction array to traverse in all 4 directions
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
    public boolean dfs(int [][] maze, int [] start, int [] destination){
        //base case
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        //logic
        maze[start[0]][start[1]] = 2;
        for(int [] dir: dirs){
            int r = start[0];
            int c = start[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];
            if(maze[r][c] != 2 && dfs(maze, new int []{r,c}, destination)){
                return true;
            }
        }
        return false;
    }
}