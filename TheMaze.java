// Time Complexity : O(M x N) - As we traverse through all the elements in the maze
// Space Complexity : O(M x N) - As we use a queue data structure which might store all the elements in the maze
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] s = q.remove();
            if(s[0] == destination[0] && s[1] == destination[1]){
                return true;
            }
            else{
                for(int[] dir : dirs){
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    while(x >= 0 && y >= 0 && x < row && y < col && maze[x][y] == 0){
                        x += dir[0];
                        y += dir[1];
                    }
                    if(!visited[x - dir[0]][y - dir[1]]){
                        q.add(new int[] {x - dir[0],y - dir[1]});
                        visited[x - dir[0]][y - dir[1]] = true;
                    }
                }
            }
        }
        return false;
    }
}
// Your code here along with comments explaining your approach