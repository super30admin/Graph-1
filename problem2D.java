import java.util.LinkedList;
import java.util.Queue;

class mazeMatrix{
    int m, n;
    int[][] dirs;
    public boolean isWay(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0) return false;

        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[0] == destination[1]){
            return true;
        }

        maze[start[0]] [start[1]] = 2;
        for(int[] dir : dirs){
            int r = start[0];
            int c = start[1];
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
                dfs(maze, new int[] {r,c}, destination);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        mazeMatrix m = new mazeMatrix();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};
        System.out.print(m.isWay(maze, start, destination));
    }
}

//time complexity O(m * n)
//space complexity O(m * n)
// where m is raw of maze and n is coloum of maze