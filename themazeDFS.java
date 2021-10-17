public class Solution {
	int[][] dirs;
	int m; int n;
	public boolean hasPath(int[][] maze, int[] start, int[] dest) {
		if(maze==null) return false;
		m = maze.length; n = maze[0].length;
		dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
		return dfs(maze, start, dest);
	}

	public boolean dfs(int[][] maze, int[] start, int[] dest ) {
		if(start[0]==dest[0] && start[1]==dest[1]) return true;
		maze[start[0]][start[1]] = 2;

		for(int [] dir: dirs) {
			int i = start[0]; int j = start[1];
			while(i<m && i>=0 && j<n && j>=0 && maze[i][j]!=1) {
				i+=dir[0];
				j+=dir[1];
			}
			i-=dir[0];
			j-=dir[1];
			if(maze[i][j]!=2 && dfs(maze, new int[]{i,j}, dest)) return true;
		}
		return false;
	}
}