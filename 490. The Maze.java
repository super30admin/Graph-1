class Solution {// time and space of O(mn)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length ;
        int cols = maze[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start[0]][start[1]] = true ;
        
        while(!queue.isEmpty()){
            int[] s = queue.remove();
            if(s[0] == destination[0] && s[1] == destination[1])
                return true;
            
            for(int[] dir: dirs){
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while(x>=0 && y>= 0 && x< rows && y<cols && maze[x][y] == 0){
                    x +=dir[0];
                    y += dir[1];
                }
                if(!visited[x-dir[0]][y-dir[1]]){
                    queue.add(new int[]{x-dir[0],y-dir[1]});
                    visited[x-dir[0]][y-dir[1]] = true;
                }
            }
        }
        return false ;
    }
}