// Time Complexity = O(kmn), where k is max of m and n, which is used to travel in each direction
// Space Complexity = O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We can use a BFS or DFS approach to solve this and we maintain visited spots by changing the visited elements to 2
// BFS solution
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) return false;
        int m=maze.length, n=maze[0].length;
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // use a queue to implement BFS, and add to the queue the row and col of the spots where the ball has stopped
        // make sure the spot is not already visited, otherwise we will be stuck in a loop, so mark the visited spots as 2
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        maze[start[0]][start[1]] = 2;

        // we check till queue is not null
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            // check in each direction as its a BFS, we consider all the directions from each spot.
            for (int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                // we move in the same direction till we reach the stopping condition which is either end of row/col or spot == 1 (wall)
                while (row>=0 && col>=0 && row<m && col<n && maze[row][col] != 1) {
                    row = row + dir[0];
                    col = col + dir[1];
                }
                row = row - dir[0];     // reducing one extra for the above condition
                col = col - dir[1];

                // check if the stopped location is the destination, return true
                if (row == destination[0] && col == destination[1])
                    return true;

                // when the spot where the ball has stopped is 0 (that is != 2), we put that in the queue and mark it visited
                if (maze[row][col] == 0) {
                    q.offer(new int[]{row, col});
                    maze[row][col] = 2;
                }
            }
        }
        return false;
    }
}

//------------------------------------------------------------------------------------------------------------------
// DFS solution
public class Solution {
    int m,n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0) return false;
        m=maze.length;
        n=maze[0].length;
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        if (maze[start[0]][start[1]] == 2) return false;

        // logic
        // mark the starting point as visited = 2
        maze[start[0]][start[1]] = 2;
        for (int[] dir: dirs) {
            int row = start[0] + dir[0];
            int col = start[1] + dir[1];

            // we move in the same direction till we reach the stopping condition which is either end of row/col or spot == 1 (wall)
            while (row>=0 && col>=0 && row<m && col<n && maze[row][col] != 1) {
                row = row + dir[0];
                col = col + dir[1];
            }
            row = row - dir[0];     // reducing one extra for the above condition
            col = col - dir[1];

            // when the spot where the ball has stopped is 0 (that is != 2), we call the dfs function recursively with the row and col as starting points
            if (maze[row][col] == 0 && dfs(maze, new int[]{row, col}, destination)) {
                return true;
            }
        }
        return false;
    }
}