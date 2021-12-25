//time o(mn)
//space o(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        row.add(start[0]);
        col.add(start[1]);
        int r = maze.length;
        int c = maze[0].length;
        
        while(!row.isEmpty()){
            int currRow = row.poll();
            int currCol = col.poll();
            for(int[] dir: dirs) {
                int newRow = currRow;
                int newCol = currCol;
                while(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && maze[newRow][newCol] != 1) {
                    newRow = newRow + dir[0];
                    newCol = newCol + dir[1];
                }
                newRow = newRow - dir[0];
                newCol= newCol - dir[1];
                if(newRow == destination[0] &&newCol == destination[1]) 
                    return true;
                if(maze[newRow][newCol] != 2) {
                    maze[newRow][newCol] = 2;
                    row.add(newRow);
                    col.add(newCol);
                }
            }
            
        }
        return false;
    }
}
