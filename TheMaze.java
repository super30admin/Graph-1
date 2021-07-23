import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    /*
    TC : O(m*n * max(m,n))
    SC : O(m*n)
     */

    /**
     * We perform BFS starting from the start node. We go in all directions one by one. We mark the start node as visited by making
     * the value as 2.
     * <p>
     * For each direction, we keep on going in that direction until we hit an obstacle or reach a boundary. Then if the node
     * reached is not marked as visited, we check if it is destination.
     * <p>
     * Else, we mark them as visited and add it in the queue and continue.
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null) return false;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});

        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }

                x -= dir[0];
                y -= dir[1];

                if (maze[x][y] != 2) {
                    if (x == destination[0] && y == destination[1])
                        return true;
                    maze[x][y] = 2;
                    q.add(new int[]{x, y});
                }

            }
        }

        return false;
    }
}
