/**
 * Idea: Use classic BFS algo, just keep in mind that, the ball rolls until it hits wall.
 * 
 * Space Complexity: O(mn)
 * Time Compelexity: O(mn)
 */
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.add(new Point(start[0], start[1]));
        
        while(!queue.isEmpty()) {
            Point current = queue.remove();
            // goal?
            if(current.x == destination[0] && current.y == destination[1]) {
                return true;
            }
            
            for(int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                }
                // wall encountered
                if(!visited[x - dx[i]][y - dy[i]]) {
                    queue.add(new Point(x - dx[i], y - dy[i]));
                    visited[x-dx[i]][y-dy[i]] = true;
                }
            }
        }
        
        return false;
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}