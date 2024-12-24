// Time Complexity: O(m * n) as cells are visited once
// Space Complexity O(m * n) for visited array and queue
import java.util.LinkedList;
import java.util.Queue;

public class MazeBFS {
    public boolean hasPath(int[][] maze, int [] start, int[] destination){
        int m = maze.length;
        int n = maze[0].length;
        boolean [][] visited = new boolean [m][n];
        int [][] directions = {{0,1}, {-1,0}, {1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true; // marking cell visited as we traverse

        while(! queue.isEmpty()) {
            int[] current = queue.poll();

            // check if destination is reached or not

            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }

            // explore all neighbourse

            for (int[] dir : directions) {
                int x = current[0];
                int y = current[1];

                // check boundary conditions
                while (x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n && maze[x + dir[0]][y + dir[1]] == 0) {
                    x = x + dir[0];
                    y = y + dir[1];

                }

                if (!visited[x][y]) { // if the cells are not visited, add them to the queue and mark them visited
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    public static void main (String [] args){
        MazeBFS solution = new MazeBFS();
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println("BFS Result: " + solution.hasPath(maze, start, destination)); // Output: true
    }
}