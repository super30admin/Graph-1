class Solution {
    int dirs[][];
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m= maze.length;
        n= maze[0].length;
        
        if(maze==null||maze.length==0) return false;
        
        dirs=new int[]{(0,1),(1,0),(0,-1),(-1,0)};
        Queue<int[]> q= new LinkedList<>();
        q.add(start);
        maze
    }
}