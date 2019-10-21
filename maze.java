//Time Complexity:O(n) where n is the length of the maze array.
//Space Complexity:O(n)
//Approach- A queue to maintain the current location of the ball in the maze. The current position of the ball is marked as true in the visited array. While the current position is not the destination, Then the ball is moved either up, down, left or right to a new position until it hits an obstacle and the new position of the ball is added to the queue. Once the destinations is reached, the function will return true. Else, false.
//This code was executed successfully and got accepted in leetcode. 
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m=maze.length;
        int n=maze[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        q.add(start);
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==destination[0]&&cur[1]==destination[1]){
                return true;
            }
            if(visited[cur[0]][cur[1]]){
                continue;
            }
            visited[cur[0]][cur[1]]=true;
            
            int[][] move={{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] mo:move){
                int x=cur[0];
                int y=cur[1];
                while(x>=0&&x<m&&y>=0&&y<n&&maze[x][y]==0){
                    x+=mo[0];
                    y+=mo[1];
                }
                x-=mo[0];
                y-=mo[1];
                q.add(new int[] {x,y});
            }
        }
        return false;
    }
}