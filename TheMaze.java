/*
* Approach1: BFS (Connected Components)
- The idea is to start from the starting coordinate and keep moving in whichever direction possible. 
- But we are not just stopping at the neighbour and adding that to the queue, we want to check where the wall is in that direction, because the ball will not stop until it hits the wall
- Once the ball hits the wall, the cell before that is where the ball will stop and explore other possible direction, so we need to make sure we take the step back and if that cell is the destination, then return true
- Also, if we move passed the destination and the ball didnt stop, we should not immediately return false because ball can reach the destination from multiple directions so we dont return false, until we have explored all the paths from which the ball can reach the destination
- TC: O(m*n) - because the each cell is explored once and as the visited nodes increases, the traversal decreases
-SC: O(m*n) - for maintaining the queue (queue of where teh ball stops and not the neighbours)
*/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        //O(m*n)
        while(!q.isEmpty()){
            int[] curr = q.poll();
            //put the babies
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];
                while(r < m && r>= 0 && c>=0 && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                //1 is not the neighbour, it is the previous cell which is where the ball is stopping
                //basically taking a step back
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1])
                    return true;
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}