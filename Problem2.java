// 490 The maze
// Time - O(m + n)
// space - O(mn/2)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> row = new LinkedList();
        Queue<Integer> col = new LinkedList();
        
        row.add(start[0]);
        col.add(start[1]);
        
        int m = maze.length;
        int n = maze[0].length;
        
        maze[start[0]][start[1]] = 2;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!row.isEmpty()){
            
            int x = row.poll();
            int y = col.poll();
            
            for(int[] d: dir){
                
                 int newRow = x;
                 int newCol = y;
                
                 while(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&  maze[newRow][newCol] != 1){
                     newRow = newRow + d[0];
                     newCol = newCol + d[1];
                 }
                
                newRow = newRow - d[0];
                newCol = newCol - d[1];
                
                if(newRow == destination[0] && newCol == destination[1]){
                    return true;
                }
                
                if(maze[newRow][newCol] != 2){
                    maze[newRow][newCol] = 2;
                    row.add(newRow);
                    col.add(newCol);
                }
            }
        }
        return false;
    }
}