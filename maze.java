//Time - O(m*n)
//Space - O(n) visted set

class Solution {
    int m;
    int n;
    boolean flag;
    HashSet<Pair<Integer,Integer>> visited = new HashSet();
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m=maze.length;
        n=maze[0].length;
        helper(start[0],start[1], destination, maze);
        return flag;
    }
    
    public void helper(int row, int col, int[] destination,int[][] maze){
        if(row==destination[0] && col==destination[1]) {
            flag = true;
            return;
        }
        if((row>=m || row<0 || col>=n || col<0) || visited.contains(new Pair(row,col)) || maze[row][col]==1)
            return;
        if (flag) return;
        
        
        visited.add(new Pair(row,col));
        for(int[] dir: dirs){
            int or = row;
            int oc = col;
            while(or<m && or>=0 && oc<n && oc>=0 && maze[or][oc]==0){
                or=or+dir[0];
                oc=oc+dir[1];
            }
            or=or-dir[0];
            oc=oc-dir[1];
            helper(or,oc,destination,maze);
        }
    }
}
