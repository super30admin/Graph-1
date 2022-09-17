//Time Complexity: O(mn)
//Spce Complexity: O(n)

public class maze {
    public static boolean hasPath(int[][] maze, int[]start, int[]end){
        if(start[0]==end[0] && start[1]==end[1]) return true;
        int m = maze.length;
        int n = maze[0].length;
        Queue<Integer> q = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}} ;
        q.add(start[0]);
        q.add(start[1]);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            for(int[] dir: dirs){
                int i = r; int j = c;
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(maze[i][j]!=2){
                    if(i==end[0] && j==end[1]) return true;
                    q.add(i); q.add(j);
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}