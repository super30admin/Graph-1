/*
  Time: O(m*n)
  Spcae: O(m*n) stack memory
  Run on LeetCode: yes
*/
class Solution {
    //DFS Approch.
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze[start[0]][start[1]] == -1)
            return false;

        if(start[0] == destination[0] &&
           start[1] == destination[1])
            return true;

        int x = start[0];
        int y = start[1];

        //mark seen
        maze[x][y] = -1;

        //move up.
        while(x >= 0 && (maze[x][y] == 0 || maze[x][y] == -1)){
            x--;
        }
        if(hasPath(maze, new int[]{x+1, y}, destination))
            return true;


        //move down.
        x = start[0];
        y = start[1];
        while(x < maze.length && (maze[x][y] == 0 || maze[x][y] == -1)){
            x++;
        }
        if(hasPath(maze, new int[]{x-1, y}, destination))
            return true;


        //move left.
        x = start[0];
        y = start[1];
        while(y>= 0 && (maze[x][y] == 0 || maze[x][y] == -1)){
            y--;
        }
        if(hasPath(maze, new int[]{x, y+1}, destination))
            return true;


        //move right.
        x = start[0];
        y = start[1];
        while(y < maze[0].length && (maze[x][y] == 0 || maze[x][y] == -1)){
            y++;
        }
        if(hasPath(maze, new int[]{x, y-1}, destination))
            return true;


           return false;
    }
}
