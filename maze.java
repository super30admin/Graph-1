// Time Complexity : O(N * M) 
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        int rows = maze.length, cols = maze[0].length;
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()) {
            int[] currentPosition = q.poll();

            int currentRowPosition = currentPosition[0], currentColPosition = currentPosition[1];

            if(currentRowPosition == destination[0] && currentColPosition == destination[1]) {
                return true;
            }

            for(int[] direction : directions) {

                int nextRowPosition = currentRowPosition + direction[0], nextColPosition = currentColPosition + direction[1];

                while(withinMaze(nextRowPosition, nextColPosition, rows, cols) && maze[nextRowPosition][nextColPosition] != 1) {
                    nextRowPosition += direction[0];
                    nextColPosition += direction[1];
                }

                nextRowPosition -= direction[0];
                nextColPosition -= direction[1];

                if(maze[nextRowPosition][nextColPosition] != 2) {
                    maze[nextRowPosition][nextColPosition] = 2;
                    q.add(new int[]{nextRowPosition, nextColPosition});
                }
            }
        }

        return false;
    }

    private boolean withinMaze(int row, int col, int rows, int cols) {

        return (row >= 0 && col >= 0 && row < rows && col < cols);
    }
}

class Solution {

    int[][] directions;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        return dfs(maze, start, destination);        
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        if(maze[start[0]][start[1]] == 2) {
            return false;
        }

        maze[start[0]][start[1]] = 2;

        for(int[] direction : directions) {
            int nextRowPosition = start[0] + direction[0], nextColPosition = start[1] + direction[1];

            while(withinMaze(nextRowPosition, nextColPosition, maze.length, maze[0].length) && maze[nextRowPosition][nextColPosition] != 1) {
                 nextRowPosition += direction[0];
                 nextColPosition += direction[1];
            }

            nextRowPosition -= direction[0];
            nextColPosition -= direction[1];

            if(dfs(maze, new int[] {nextRowPosition, nextColPosition}, destination)) {
                return true;
            }

        }

        return false;
    }

    private boolean withinMaze(int row, int col, int rows, int cols) {

        return (row >= 0 && col >= 0 && row < rows && col < cols);
    }
}
