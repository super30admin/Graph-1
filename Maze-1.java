// This solution uses a BFS approach to grab the neighbors first
// On each direction of neighbor we roll the ball until valid and add it to the queue
// We change the number to -1 if a column is visited
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList();

        queue.add(start);
        maze[start[0]][start[1]]=-1;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()) {
            int[] dest = queue.poll();

            for(int i=0;i<dirs.length;i++) {
                row = dest[0];
                col = dest[1];
                int[] dir = dirs[i];
                while((row+dir[0]>=0 && col+dir[1]>=0 && row+dir[0]<=m-1 && col+dir[1]<=n-1) && maze[row+dir[0]][col+dir[1]]!=1) {
                    row = row+dir[0];
                    col = col+dir[1];
                }
                if(maze[row][col]!=-1) {
                    if(row==destination[0] && col==destination[1]) return true;
                    queue.add(new int[]{row, col});
                    maze[row][col]=-1;
                }
            }
        }

        return false;
    }
}
