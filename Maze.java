// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use BFS to solve this
// we put the start in the queue and mark it as 2(visited)
// We poll the queue and go in all directions until we get to the edges
// if we find the destination we return true 
// and if the location is not visited we add it to the queue

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int m = maze.length;
        int n = maze[0].length;
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if (i == destination[0] && j == destination[1]) {
                    return true;
                }
                if (maze[i][j] == 0) {
                    maze[i][j] = 2;
                    q.add(new int[] { i, j });
                }
            }
        }
        return false;
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use DFS to solve this
// we call a recursive function
// We go in all directions till we reach the edge
// and from that point we will do the dfs
// we check if we reached the destination as base condition

class Solution {

    int[][] dirs;
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        m = maze.length;
        n = maze[0].length;

        return dfs(maze, start, destination);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        if (maze[start[0]][start[1]] == 2)
            return false;
        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int i = start[0];
            int j = start[1];
            while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                i = i + dir[0];
                j = j + dir[1];
            }
            i = i - dir[0];
            j = j - dir[1];
            if (maze[i][j] != 2 && dfs(maze, new int[] { i, j }, destination)) {
                return true;
            }
        }
        return false;
    }
}