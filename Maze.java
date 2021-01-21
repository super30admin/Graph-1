// Time Complexity :O(N*M) 
// Space Complexity :O(N*M) 
// Did this code successfully run on Leetcode : tested on playground
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: from the start cordinates start dfs in 4 directions. change the value in maze
// to 2 after stopping at that cordinate. Continue traversing until the destination; 
// "static void main" must be defined in a public class.
public class Main {
    static int dir[][] =  {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        /*int maze[][] = {{0,0,1,0,0},
                    {0,0,0,0,0},
                    {0,0,0,1,0},
                    {1,1,0,1,1},
                    {0,0,0,0,0}};
        int i=0;
        int j=4;*/
        int maze[][] = {{0,0,1,0,0},
                    {0,0,0,0,0},
                    {0,0,0,1,0},
                    {1,1,0,1,1},
                    {0,0,0,0,0}};
        int i=0;
        int j=4;
        int destination[] ={3,2};
        System.out.println(hasPath(maze,new int[]{i,j},destination));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]<0 || start[0]>=maze.length||start[1]<0||start[1]>=maze[0].length)
            return false;
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        maze[start[0]][start[1]]=2;
        for(int d[]: dir){
            int i=d[0]+start[0];
            int j=d[1]+start[1];
            if(i<0 || i>=maze.length||j<0||j>=maze[0].length)
                continue;
            while(maze[i][j]!= 1){
                i+=d[0];
                j+=d[1];
                if(i<0 || i>=maze.length||j<0||j>=maze[0].length)
                break;
            }
            //System.out.print(i+" , "+j+"   ");
            i-=d[0];
            j-=d[1];
            //System.out.println(i+" , "+j);
            if(maze[i][j]!=2){
                if(hasPath(maze,new int[]{i,j},destination))
                    return true;
            }
        }
        return false;
    }
}