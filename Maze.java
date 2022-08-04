// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    private class Cell {
        public int row;
        public int col;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        
        Deque<Cell> q = new ArrayDeque<>();
        q.addFirst(new Cell(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (q.size() > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Cell cell = q.removeLast();
                
                int r = cell.row;
                int c = cell.col;
                
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                
                for (int[] dir : dirs) {
                    int nextRow = r;
                    int nextCol = c;
                    while (nextRow + dir[0] >= 0 && nextRow + dir[0] < rows && nextCol + dir[1] >= 0 && nextCol + dir[1] < cols && maze[nextRow + dir[0]][nextCol + dir[1]] == 0) {
                        nextRow = nextRow + dir[0];
                        nextCol = nextCol + dir[1];
                    }
                    
                    if (!visited[nextRow][nextCol]) {
                        q.addFirst(new Cell(nextRow, nextCol));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        
        return false;
    }
}
