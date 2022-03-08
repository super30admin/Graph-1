//Maze
//time complexity : O(NM)
//Space complexity: O(NM)


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



//Find town judge
//Time complexity: O(E)
//Space complexity: O(N)

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int count[] = new int[n+1];
        
        for(int t[] : trust){
            count[t[0]]--;     // outdegree
            count[t[1]]++;   // indegree
        }
        
        for(int i=1;i<=n;i++){
            if(count[i]==n-1) return i;
        }
        
        return -1;
        
    }
}
