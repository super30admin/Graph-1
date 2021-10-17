public class Solution {
	public boolean hasPath(int[][] maze, int[] start, int[] dest) {
		if(maze==null) return false;
		int m = maze.length; int n = maze[0].length;
		Queue<int[]> q = new LinkedList<>();
		maze[start[0]][start[1]] = 1;
		q.add(start);
		int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int[] dir: dirs) {
				int i = curr[0]; int j = curr[1];
				while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1 ) {
					i += dir[0];
					j += dir[1];
				}
				i-=dir[0];
				j-=dir[1];
				if(maze[i][j]==0){
					if(i==dest[0] && j==dest[1]) return true;
					maze[i][j]=2;
					q.add(new int[]{i,j});
				}
			}
		}
		return false;
	}
}