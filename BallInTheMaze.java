//Time Complexity: O(mn) where m is length of maze raw and n is length of maze column
//Space Complexity: O(mn)

public class BallInTheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0) return false;
        int m = maze.length;
        int n = maze[0].length;
        int [][] dirs = {{0,1},{1,0}, {0,-1}, {-1,0}};
        Queue<int []> q = new LinkedList<>();
        if(Arrays.equals(start,destination)) return true;
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] curr_idx = q.poll();
            int r = curr_idx[0];
            int c = curr_idx[1];
            for(int[] dir: dirs){
                int i = r; int j =c;
                while(i>=0 && i< m && j >=0 && j<n && maze[i][j] !=1){
                    i += dir[0];
                    j += dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(i == destination[0] && j == destination[1]) return true;
                if(maze[i][j] !=2){
                    q.add(new int[] {i,j});
                    maze[i][j] =2;
                }
            }
        }
    return false;
    }
}
