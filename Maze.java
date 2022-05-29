// O(mn) time: complete traversal of maze, m rows and n cols
// O(mn) space: visited array of size mn and queue size can grow to mn in worst case 

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue <int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true; // mark starting position as visited
        
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1]) // check if reached destination
                return true;
            for (int[] dir: dirs) { // loop for each direction (breadth first search)
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) { // move until we hit a wall or a boundary
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) { // once we exit while loop, we are AT boundary or wall, so need to bring back to last available space by subtracting
                    queue.add(new int[] {x - dir[0], y - dir[1]}); // new starting position is destination of last move
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}