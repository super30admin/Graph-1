import java.util.LinkedList;
import java.util.Queue;

//apprach BFS AND DFS 

//did not understand fully BFS approach

public class BallInMaze {
	//DFS TIMELIMIT EXCEEDED
	/*Time complexity : O(mn). Complete traversal of maze will be done in the worst case. Here, mm and nn refers to the number of rows and coloumns of the maze.

	Space complexity : O(mn). visitedvisited array of size m*nm∗n is used and queuequeue size can grow upto m*nm∗n in worst case.*/
	    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
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
	    
	    
	    //BFS
	  /*  Time complexity : O(mn)O(mn). Complete traversal of maze will be done in the worst case. Here, mm and nn refers to the number of rows and coloumns of the maze.

	    Space complexity : O(mn)O(mn). visitedvisited array of size m*nm∗n is used and queuequeue size can grow upto m*nm∗n in worst case.*/
	        public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
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
