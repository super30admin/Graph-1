import java.util.LinkedList;
import java.util.Queue;
// BFS and DFS have the same time and space complexity of O(m * n), where m is the number of rows and n is the number of columns in the maze.
public class TheMaze {
    int m, n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //**************BFS***********************
        this.m = maze.length;
        this.n = maze[0].length;
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        boolean[][] visited = new boolean[m][n];

        if(start[0] == destination[0] && start[1]==destination[1]) return true;
        Queue<int[]> q = new LinkedList<>();
        maze[start[0]][start[1]] = 2;  //Marking it as visited
        q.add(start);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c ==destination[1]) return true;
                if(maze[r][c] != 2){
                    q.add(new int[]{r , c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        //**************DFS********************
        this.m = maze.length;
        this.n = maze[0].length;
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(start[0] == destination[0] && start[1]==destination[1]) return true;
        return dfs(maze, start, destination);
//        return false;

    }
    private boolean dfs(int[][] maze, int[] curr,  int[] destination) {
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
        if(maze[curr[0]][curr[1]] == 2) return false;

        maze[curr[0]][curr[1]] = 2;
        for (int[] dir : dirs) {
            int r = curr[0] + dir[0];
            int c = curr[1] + dir[1];

            while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];

            if (dfs(maze, new int[]{r,c}, destination)) {
                return true;
            }
        }

        return false;
    }


}
//    Problem Statement:
//        There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left, or right,
//        but it won't stop rolling until hitting a wall. When the ball stops, it can choose the next direction. The maze is represented by a 2D grid where 0
//        represents empty spaces and 1 represents walls. The ball and the destination are represented by a start coordinate and a destination coordinate, respectively.
//
//        Determine if the ball can stop at the destination or not.
//
//        Example:
//            Input 1:
//                    maze =
//                    [
//                    [0,0,1,0,0],
//                    [0,0,0,0,0],
//                    [0,0,0,1,0],
//                    [0,0,0,0,0],
//                    [0,0,0,0,1]
//                    ]
//                    start = [0, 4]
//                    destination = [4, 4]
//
//                    Output 1: true
//
//                    Input 2:
//                    maze =
//                    [
//                    [0,0,1,0,0],
//                    [0,0,0,0,0],
//                    [0,0,0,1,0],
//                    [0,0,0,0,0],
//                    [0,0,1,0,1]
//                    ]
//                    start = [0, 4]
//                    destination = [4, 4]
//
//                    Output 2: false
