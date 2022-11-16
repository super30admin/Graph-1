//Time: O(mn)
//Space: O(mn)
//DFS
// public class Solution {
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         boolean[][] visited = new boolean[maze.length][maze[0].length];
//         return dfs(maze, start, destination, visited);
//     }
//     public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
//         if (visited[start[0]][start[1]])
//             return false;
//         if (start[0] == destination[0] && start[1] == destination[1])
//             return true;
//         visited[start[0]][start[1]] = true;
//         int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
//         while (r < maze[0].length && maze[start[0]][r] == 0) // right
//             r++;
//         if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
//             return true;
//         while (l >= 0 && maze[start[0]][l] == 0) //left
//             l--;
//         if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
//             return true;
//         while (u >= 0 && maze[u][start[1]] == 0) //up
//             u--;
//         if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
//             return true;
//         while (d < maze.length && maze[d][start[1]] == 0) //down
//             d++;
//         if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
//             return true;
//         return false;
//     }
// }
//Time: O(mn)
//Space: O(mn)
//BFS
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
