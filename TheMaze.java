/*
The time comlexity is O(m*n) where m*n is the size of the maze and the space complexity is also O(m*n)

Here, the intuition is to use depth first seach of the maze where the points from where we can have dfs are the points having
1 as their border.

Did not run on leetcode as the question is only for premium users.
 */
public class Maze {

    public static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    public static void main(String[] args){
        int[][] maze = {{0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        int rowStart = 0; int colStart = 4; int rowDest = 4; int colDest = 4;

        //Creating the visited array to note down the visited nodes.
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        //Calling dfs function
        System.out.print(dfs(maze,visited , rowStart,colStart ,rowDest ,colDest));


    }

    public static boolean dfs(int[][] maze,boolean[][] visited, int i, int j, int desti, int destj){

        if(i==desti && j==destj){
            return true;
        }
        visited[i][j] = true;

        //Check each direction for current index i,j
        for(int[] each:dir){
            int newI = i; int newJ = j;

            //Go to the end of each path where we either go to the end of maze or to '1'
            while(newI>=0 && newI<maze.length && newJ>=0 && newJ<maze[0].length && maze[newI][newJ]==0){
                newI = newI+each[0]; newJ = newJ+each[1];
            }

            //In the previous while loop, the newI,newJ either go outside maze or on '1'. So, come back.
            newI = newI-each[0]; newJ = newJ - each[1];

            //Dfs on newI,newJ. If found return true.
            if(!visited[newI][newJ]){
                boolean check = dfs(maze,visited,newI,newJ,desti,destj);
                if(check){
                    return true;
                }
            }

        }

        return false;
    }
}