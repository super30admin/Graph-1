// Time Complexity: O((m*n)*(m+n)) where m is the number of rows and n is the number of columns
// Space Complexity: O(m*n)

import java.util.LinkedList;
import java.util.Queue;

class Maze {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while(!queue.isEmpty()){
            int[] elem = queue.poll();

            if(elem[0] == destination[0] && elem[1] == destination[1]){
                return true;
            }

            for(int[] dir: dirs){
                int nr = dir[0] + elem[0];
                int nc = dir[1] + elem[1];

                while(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] != 1){
                    nr += dir[0];
                    nc += dir[1];
                }
                nr -= dir[0];
                nc -= dir[1];

                if(maze[nr][nc] != 2){
                    queue.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }

    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        // base
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }

        if(maze[start[0]][start[1]] == 2){
            return false;
        }

        maze[start[0]][start[1]] = 2;

        for(int[] dir: dirs){
            int nr = dir[0] + start[0];
            int nc = dir[1] + start[1];

            while(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] != 1){
                nr += dir[0];
                nc += dir[1];
            }
            nr -= dir[0];
            nc -= dir[1];

            if(dfs(maze, new int[]{nr, nc}, destination)){
                return true;
            }
        }
        return false;
    }
}
