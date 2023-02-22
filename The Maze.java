// Time Complexity = O(mn)
// Space Complexity = O(mn)

class Solution {
    private int [][] dirs;
    private int n;
    private int m;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if((start[0] == destination[0]) && (start[1] == destination[1])) return true;
        m = maze.length;
        n = maze[0].length; 
        dirs = new int [][] {{-1,0}, {1,0},{0,-1},{0,1}};
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start[0]);
        q.add(start[1]);
        
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int currR = q.poll();
            int currC = q.poll();
            
            for(int[] dir:dirs){
                int i = currR;
                int j = currC;
                while(i>=0 && j >=0 && i<m &&j<n && maze[i][j] != 1){
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                
                if(maze[i][j] != 2){
                    if(i == destination[0] && j == destination[1])
                        return true;
                    maze[i][j] = 2;
                    q.add(i);
                    q.add(j);
                }
                
            }
            
        }
        return false;
    }
}