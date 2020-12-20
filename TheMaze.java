
// Time Complexity :  O(N * M) maze dimensions
// Space Complexity : O(N * M) q size, Z/2 - z is total elements in the maze( at last level)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//we will use BFS here as it is faster than dfs in average case.
//Queue all the neighbours, check if they are the destination if not traverse till the ball stops rolling and the find the suitable or not
//by checking visited or if its a 0 or not.. 
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            if(pos[0] == destination[0] && pos[1] == destination[1])    return true;
            for(int[] d: dirs){
                int x = pos[0] + d[0];
                int y = pos[1] + d[1];
                //keep rolling
                while(x >=0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += d[0];
                    y += d[1];
                }//reduce back the dimensions to the valid case
                if(!visited[x - d[0]][y - d[1]]){
                    q.add(new int[]{x- d[0], y - d[1]});
                    visited[x - d[0]][y - d[1]] = true;
                }
            }
        }
        return false;
    }
}