# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0) {
            return -1;
        }
        int[] indegrees = new int[n];
        for(int[] t : trust) {
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i = 0; i < n; i++) {
            if(indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
int m = maze.length;

        int n = maze[0].length;

        // boolean [][] visited = new boolean [m][n];

        Queue <int []> q = new LinkedList <>();

        int [][] dirs = {{0,1},{1,0}, {0, -1}, {-1, 0}};

        q.offer(start);

        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){

            int [] top = q.poll();

            int r = top[0];

            int c = top[1];

            if(r == destination[0] && c == destination[1]) return true;

            for(int k = 0; k < dirs.length; k++){

                int i = r;

                int j = c;

                while(i >= 0 && j >= 0 && i < m && j < n && (maze[i][j] == 0 || maze[i][j] == 2)){

                    i += dirs[k][0];

                    j += dirs[k][1];

                }
                i -= dirs[k][0];

                j -= dirs[k][1];

                if(maze[i][j] != 2){

                    q.offer(new int [] {i,j});

                    maze[i][j] = 2; 

                }            }

        }

        return false;
    }
}


