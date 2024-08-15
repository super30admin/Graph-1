# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> temp(n + 1, 0); 
        int size = trust.size();
        for (int i = 0; i < size; i++) {
            temp[trust[i][0]]--;
            temp[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) { 
            if (temp[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
};

## Problem2 The Maze (https://leetcode.com/problems/the-maze/)


class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[start[0]][start[1]] = true;
        Deque<int[]> q = new LinkedList<>();
        q.offer(start);
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int k = 0; k < 4; ++k) {
                int x = i, y = j;
                int a = dirs[k], b = dirs[k + 1];
                while (
                    x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
                    x += a;
                    y += b;
                }
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                if (!vis[x][y]) {
                    vis[x][y] = true;
                    q.offer(new int[] {x, y});
                }
            }
        }
        return false;
    }
}