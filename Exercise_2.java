class Solution {
    private int[][] dirs = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }

        if(maze[start[0]][start[1]] == 2){
            return false;
        }

        int i =start[0], j = start[1];
        maze[i][j] =2;
        for(int[] dir : dirs){
            int adji = i, adjj = j;
            while(
                (adji>=0 && adjj>=0 && adji<maze.length &&
                adjj<maze[0].length && maze[adji][adjj] != 1)
            ){
                adji +=dir[0];
                adjj +=dir[1];
            }
                adji -=dir[0];
                adjj -=dir[1];

                if(hasPath(maze, new int[]{adji, adjj}, destination)){
                    return true;
                }
        }
        return false;
    }
}
//tc=O(n)
//sc=O(1)
