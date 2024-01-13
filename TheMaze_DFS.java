//T.C : O(m*n)
//S.C : O(m*n)
//Solution: Use DFS recursive stack space to explore all possible solutions and check edge conditions

public class TheMaze_DFS {
    int m, n;
    int[][] dirs;
    public boolean findPath(int[][] maze, int[] st, int[] dest){
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        if(st[0]==dest[0] && st[1] == dest[1])
            return true;

        return dfs(maze, st,dest);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] dest) {
        //base case
        if(curr[0] == dest[0] && curr[1] == dest[1])
            return true;

        if(maze[curr[0]][curr[1]]==2)
            return false;

        //logic
        maze[curr[0]][curr[1]] = 2;
        for(int[] dir: dirs){
            int r = dir[0] + curr[0];
            int c = dir[1] + curr[1];

            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] == 0){
                r += dir[0];
                c += dir[1];
            }
            r-=dir[0];
            c-=dir[1];

            if(dfs(maze, new int[]{r,c}, dest)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},
                {0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] dest = new int[]{4,4};
        boolean res = new TheMaze_DFS().findPath(maze, start, dest);
        System.out.println("Result is : " + res);
    }
}
