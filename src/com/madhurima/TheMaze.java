//Time complexity: O(m*n)
//Space Complexity: O(m*n) its the max possible queue length in BFS solution and max possible recursion stack in dfs
//Did the code run successfully in LeetCode = yes

package com.madhurima;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
}

class SolutionBFS {

    //BFS solution
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start[0], start[1]});

        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r = r + dir[0];
                    c = c + dir[1];
                }

                r = r - dir[0];
                c = c - dir[1];

                if(maze[r][c] != 2){
                    if(r == destination[0] && c == destination[1]){
                        return true;
                    }
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }

            }
        }

        return false;

    }
}


class SolutionDFS {
    int[][] dirs;
    int m, n;

    //dfs solution
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }

        m = maze.length;
        n = maze[0].length;

        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        return dfs(maze, start, destination);

    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }

        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir: dirs){
            int r = start[0];
            int c = start[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                r = r + dir[0];
                c = c + dir[1];
            }

            r = r - dir[0];
            c = c - dir[1];

            if(maze[r][c] != 2 && dfs(maze, new int[]{r, c}, destination)){
                return true;
            }
        }

        return false;

    }
}