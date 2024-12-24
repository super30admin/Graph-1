// Time Complexity: O(m * n) as cells are visited once
// Space Complexity O(m * n) for visited array and recursion stack
public class MazeDFS {
    public boolean hasPathDFS(int [][] maze, int [] start, int [] destination){
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, destination, visited);

    }

    private boolean dfs(int [][] maze, int [] current, int[] destination, boolean[][] visited){
        if( visited [current[0]][current[1]]) return false;
        if(current[0] == destination[0] && current[1] == destination[1]) return true;

        visited [current[0]][current[1]] = true;
        int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};

        for( int[] dir: directions){
            int x = current [0], y = current [1];

            while(x+ dir[0] >=0 && x + dir[0]<  maze.length &&  y + dir[1] >=0 && y + dir[1] <maze[0].length && maze[x+ dir[0]][y+ dir[1]] ==0){
                x += dir[0];
                y += dir[1];
            }

            if(dfs(maze, new int[]{x,y}, destination,visited)){
                return true;
            }

        }
      return false;

    }
    public static void main(String[] args) {
        MazeDFS solution = new MazeDFS();
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println("DFS Result: " + solution.hasPathDFS(maze, start, destination)); // Output: true
    }
}
