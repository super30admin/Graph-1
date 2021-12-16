class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int directions[][] = new int[4][2];
        directions[0] = new int[]{-1,0};
        directions[1] = new int[]{1, 0};
        directions[2] = new int[]{0,1};
        directions[3] = new int[]{0, -1};

        return helper(maze, start, destination, directions);
    }

    public boolean helper(int[][] maze, int []start, int[] destination, int[][] directions){
        int x = start[0];
        int y = start[1];
        if(maze[start[0]][start[1]]==2)
            return false;
        maze[start[0]][start[1]] = 2;
        int wall[];
        for(int direction[]:directions){
            wall = findWall(maze, x, y, direction);
            if(maze[wall[0]][wall[1]] ==2)
                continue;
            if(eq(wall, destination))
                return true;
            if(helper(maze, wall, destination, directions))
                return true;
            maze[wall[0]][wall[1]] = 2;
        }
        return false;
    }

    public int[] findWall(int[][] maze, int x, int y, int direction[]){
        while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]!=1){
            x += direction[0];
            y += direction[1];
        }
        return new int[]{x-direction[0], y-direction[1]};
    }

    public boolean eq(int[] x, int []y){
        return x[0] == y[0] && x[1] == y[1];
    }
}