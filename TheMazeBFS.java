// TC: O(m x n)
// SC: O(m x n)

// BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) {
            return false;
        }

        int m, n;
        m = maze.length;
        n = maze[0].length;

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dirs) {
                int i = curr[0];
                int j = curr[1];
                while(i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1) {
                    i += d[0];
                    j += d[1];
                }

                i -= d[0];
                j -= d[1];

                if(maze[i][j] != 2) {
                    if(i == destination[0] && j == destination[1]) {
                        return true;
                    } else {
                        q.add(new int[]{i, j});
                        maze[i][j] = 2;
                    }
                }

            }
        }
        return false;
    }
}