import java.util.LinkedList;
import java.util.Queue;

public class MazeProblem {
	public boolean hasPath(int[][] maze,int [] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;
		if(start[0] == destination[0] && start[1]==destination[1]) return true;
		Queue<int[]> q = new LinkedList<>();
		int [][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};// L R U D
		q.add(new int[] {start[0],start[1]});
		maze[start[0]][start[1]] = 2;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int[] dir: dirs) {
				int r = curr[0];
				int c = curr[1];
				while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1) {
					r+= dir[0];
					c+= dir[1];
				}
				r-=dir[0];
				c-=dir[1];
				if(r == destination[0] && c == destination[1]) return true;
				if(maze[r][c]!=2) {
					q.add(new int[] {r,c});
					maze[r][c] = 2;
				}
			}
		}
		return false;
	}

}
