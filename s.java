class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] trustscores = new int [n+1];
        for(int[] pair : trust){
           int pers1 = pair[0];
            int pers2=pair[1];
            trustscores[pers1]--;
            trustscores[pers2]++;
        }
        for (int i = 1; i <= n; i++) {
    if (trustscores[i] == n - 1) {
        return i;  
    }
}
        return -1;
        
    }
}
//
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] dest, boolean[][] visited) {
        if (visited[curr[0]][curr[1]]) return false;
        if (curr[0] == dest[0] && curr[1] == dest[1]) return true;
        visited[curr[0]][curr[1]] = true;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] dir : dirs) {
            int x = curr[0], y = curr[1];
            // Roll the ball until it hits a wall
            while (x + dir[0] >= 0 && x + dir[0] < maze.length &&
                   y + dir[1] >= 0 && y + dir[1] < maze[0].length &&
                   maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(maze, new int[]{x, y}, dest, visited)) return true;
        }
        return false;
    }
}