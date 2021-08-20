# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

//Time Complexity = O(N)
//Space Complexity = O(N)

class Solution {
public int findJudge(int n, int[][] trust) {

        if(trust.length < n-1) {
            return -1;
        }

        int[] in = new int[n+1];
        int[] out = new int[n+1];

        for(int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }

        for(int i = 1;i <= n; i++) {
            if(in[i] == n-1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}

## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

//Time Complexity = O(M*N + (M+N))
//Space Complexity = O(M*N)

// class Solution {
// boolean result;
// int[][] dirs;
// int m;
// int n;
// public boolean hasPath(int[][] maze, int[] start, int[] destination) {
// if(maze.length == 0 || maze == null) {
// return false;
// }
// m = maze.length;
// n = maze[0].length;
// dirs = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};

// return helper(maze,start[0],start[1],destination,m,n);
// }

// private boolean helper(int[][] maze, int r,int c, int[] destination,int m,int n) {

// if(r == destination[0] && c == destination[1]) {
// return true;
// }

// maze[r][c] = 2;

// for(int[] dir : dirs) {
// int i = r;
// int j = c;
// while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
// i += dir[0];
// j += dir[1];
// }
// i -= dir[0];
// j -= dir[1];

// if(maze[i][j] != 2 && helper(maze,i, j,destination, m,n)) {
// return true;
// }
// }
// return false;
// }
// }

class Solution {
public boolean hasPath(int[][] maze, int[] start, int[] destination) {
if(maze.length == 0 || maze[0].length == 0) {
return false;
}
int[][] dirs = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
Queue<Integer> queue = new LinkedList<>();
maze[start[0]][start[1]] = 2;
queue.add(start[0]);
queue.add(start[1]);

        while(!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for(int[] dir : dirs) {
                int nR = r;
                int nC = c;
                while(nR >= 0 && nC >= 0 && nR<maze.length && nC<maze[0].length && maze[nR][nC] != 1) {
                    nR += dir[0];
                    nC += dir[1];
                }
                nR -= dir[0];
                nC -= dir[1];

                if(nR == destination[0] && nC == destination[1]) {
                    return true;
                }

                if(maze[nR][nC] != 2) {
                    queue.add(nR);
                    queue.add(nC);
                    maze[nR][nC] = 2;
                }
            }
        }
        return false;
    }

}
