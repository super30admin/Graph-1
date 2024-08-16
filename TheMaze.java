import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) { //O(m*n) T.C, O(m*n) S.C
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}}; //direction array
        Queue<int[]> q = new LinkedList<>();
        q.add(start); //add start point to q as a valid stop point
        maze[start[0]][start[1]] = 2; //make it as visited

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir : dirs) { //for all directions
                int r = curr[0]; //start from initial grid position
                int c = curr[1];
                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) { //boundary check
                    r += dir[0]; //move the ball until a wall is hit
                    c += dir[1];
                }
                //step back
                r -= dir[0]; //once the wall is hit, take a step back to arrive at last open position
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true; //if this open is the destination, return
                if(maze[r][c] != 2) { //else if it is not already marked
                    q.add(new int[]{r, c}); //add it to the q
                    maze[r][c] = 2; //and mark as visited
                }
            }
        }
        return false; //if no visited position is the destination, return false
    }

    boolean flag;
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) { //O(m*n) T.C, O(m*n) S.C
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        flag = false;
        dfs(maze, start, destination, m, n, dirs);
        return flag;
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int m, int n, int[][] dirs) {
        //base
        if(maze[start[0]][start[1]] == 2) return; //if the grid is already visited, return directly

        //logic
        maze[start[0]][start[1]] = 2; //mark the current grid as visited
        for(int[] dir : dirs) { //in all directions
            int r = start[0]; //take the initial start coordinates
            int c = start[1];
            while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) { //boundary check
                r += dir[0]; //move the ball until a wall is hit
                c += dir[1];
            }
            //step back
            r -= dir[0]; //go to last open position from the wall
            c -= dir[1];

            if(r == destination[0] && c == destination[1]) flag = true; //if this is the destination, make the flag true

            if(!flag) { //if the flag is not found yet
                dfs(maze, new int[]{r, c}, destination, m, n, dirs); //continue recursion with the newly visited grid
            }
        }
    }
    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();

        int[][] maze = {
                {0,1,0,0,0},
                {1,0,0,1,0},
                {0,0,1,0,0},
                {0,0,0,1,1},
                {1,1,0,0,0}
        };

        int[] start = {0,3};

        int[] destination = {4, 4};
        System.out.println("Will the ball from " + Arrays.toString(start) + " stop at " + Arrays.toString(destination)
                + " in the maze " + Arrays.deepToString(maze) + " : " + theMaze.hasPathBFS(maze, start, destination));

        int[] destination2 = {3, 2};
        System.out.println("Will the ball from " + Arrays.toString(start) + " stop at " + Arrays.toString(destination2)
                + " in the maze " + Arrays.deepToString(maze) + " : " + theMaze.hasPathDFS(maze, start, destination2));
    }
}