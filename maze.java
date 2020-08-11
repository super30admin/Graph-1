//Time ccomplexity:O(mn)
//Space complexity:O(mn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList();
        if(maze==null || maze.length==0){
            return false;
        }
        q.add(start);
        int m=maze.length;
        int n=maze[0].length;
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            if(curr[0]==destination[0] && curr[1]==destination[1]){
                return true;
            }
            for(int[] dir:dirs){
                int row=curr[0];
                int col=curr[1];
                while(row<m && col<n && row>=0 && col>=0 && maze[row][col]!=1){
                    row+=dir[0];
                    col+=dir[1];
                }
                row-=dir[0]; col-=dir[1];
                if(maze[row][col]!=2){
                    maze[row][col]=2;
                    q.add(new int[] {row,col});
                }
            }
        }
        return false;
    }
}