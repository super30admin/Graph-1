// DFS Solution
// Time Complexity : O(mn)
// Space Complexity : O(mn)

class Solution {
    int[][] maze;
    int[] start, dest;
    int[][] dirs;
    boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.start = start;
        this.dest = destination;
        visited = new boolean[maze.length][maze[0].length];
        
        dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        return dfs(start);
    }
    
    private boolean dfs(int[] node){
        int i = node[0];
        int j = node[1];
        
        if(visited[i][j])
            return false;
        
        if(i == dest[0] && j == dest[1])
            return true;
        
        visited[i][j] = true;
        
        for(int[] dir: dirs){ // up, left, down, right
            int ni = i;
            int nj = j;
            
            while(isValid(ni+dir[0],nj+dir[1])){
                ni+=dir[0];
                nj+=dir[1];
            }
            if(dfs(new int[]{ni, nj}))
                return true;
        }
        return false;
    }
    
    private boolean isValid(int i, int j){
        return i<maze.length && j<maze[0].length && i>=0 && j>=0 && maze[i][j] == 0;
    }
}



// BFS Solution
// Time Complexity : O(mn) 
// Space Complexity : O(mn)


class Solution {
    int[][] dirs;
    Queue<int[]> q;
    int[][] maze;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        q = new LinkedList<>();
        dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        q.add(start);
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            
            int i = node[0];
            int j = node[1];
            
            if(i == destination[0] && j == destination[1])
                return true;
            
            
            for(int[] dir: dirs){ // up, left, down, right
                int ni = i;
                int nj = j;

                while(isValid(ni,nj)){
                    ni+=dir[0];
                    nj+=dir[1];
                }
                ni -= dir[0];
                nj -= dir[1];
                
                if(maze[ni][nj] != 2){
                    maze[ni][nj] = 2;
                    q.offer(new int[]{ni, nj});
                }
            }   
        }    
        return false;
    }
    
    private boolean isValid(int i, int j){
        return i<maze.length && j<maze[0].length && i>=0 && j>=0 && maze[i][j] != 1;
    }
}