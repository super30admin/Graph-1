// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Maze {
    boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination);
    }

    //dfs method
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //if element is already visited then return
        if(visited[start[0]][start[1]])
            return false;

        //check if destination is reached
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;

        //mark current element as visited
        visited[start[0]][start[1]] = true;

        //set all 4 directions
        int right = start[1] + 1, left = start[1] - 1;
        int top = start[0] - 1, down = start[0] + 1;

        //go right as far as possible
        while(right < maze[0].length && maze[start[0]][right] == 0){
            right++;
        }

        //do dfs from there
        if(dfs(maze, new int[] {start[0], right-1}, destination))
            return true;

        //go left as far as possible
        while(left >= 0 && maze[start[0]][left] == 0){
            left--;
        }

        //do dfs from there
        if(dfs(maze, new int[] {start[0], left+1}, destination))
            return true;

        //go up as far as possible
        while(top >= 0 && maze[top][start[1]] == 0){
            top--;
        }

        //do dfs from there
        if(dfs(maze, new int[] {top+1, start[1]}, destination))
            return true;

        //go down as far as possible
        while(down < maze.length && maze[down][start[1]] == 0){
            down++;
        }

        //do dfs from there
        if(dfs(maze, new int[] {down-1, start[1]}, destination))
            return true;

        //return false as every path was tried but didn't work
        return false;
    }
}