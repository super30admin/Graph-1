import java.util.*;

public class TheMaze {

    //TC: O(N) Travers all node 
    //SC: O(N) For recursize stack all the node will be there in the worst case
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // In DFS
        // Traverse one path till it stopped by object / goal/ bound.
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return false;
        int m = maze.length;
        int n = maze[0].length;
        return helper(maze, destination, m, n, start[0], start[1]);
    }

    private boolean helper(int[][] maze, int[] destination, int m, int n, int currentRow, int currentColumn) {
        // base

        if (destination[0] == currentRow && destination[1] == currentColumn)
            return true;

        if (maze[currentRow][currentColumn] == 2) {
            return false;
        } else {
            maze[currentRow][currentColumn] = 2;
        }
        // logic

        int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

        for (int[] dir : dirs) {
            int iPlus = currentRow;
            int jPlus = currentColumn;
            while (iPlus >= 0 && iPlus < m && jPlus >= 0 && jPlus < n && maze[iPlus][jPlus] != 1) {
                iPlus += dir[0];
                jPlus += dir[1];
            }
            iPlus = iPlus - dir[0];
            jPlus = jPlus - dir[1];
            if (maze[iPlus][jPlus] != 2) {
                if (helper(maze, destination, m, n, iPlus, jPlus))
                    return true;
            }
        }
        return false;
    }

    //TC: O(N) Travers all node 
    //SC: O(N) In the worst case all nodes will be inside the queue.
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        // Sanitization
        // get the length of m and n
        // Add the start point
        // All directions
        // Traverse same direction until we hit boundary or object
        // else get the previous path and add it to the queue.

        if (maze == null || maze[0].length == 0 || maze.length == 0)
            return false;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
         int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] currentPath = queue.poll();
            if(currentPath[0] == destination[0] && currentPath[1] == destination[1]) {
                    return true;
            }
            
            for (int[] dir : dirs) {
                int i = currentPath[0];
                int j = currentPath[1];
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                
                if (maze[i][j] != 2) {
                    maze[i][j] = 2;
                    queue.add(new int[] { i, j });
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        boolean result = new TheMaze().hasPathBFS(maze, new int[] { 0, 4 }, new int[] { 4, 4 });
        System.out.println("The result: " + result);
    }
}
