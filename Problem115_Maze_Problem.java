/**
 * Time Complexity - O(m*n)
 * Space Complexity - O(m*n)
 */

class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // return hasPathBFS(maze,start,destination);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPathDFS(maze,visited,start,destination);

    }

    private boolean hasPathBFS(int[][] maze, int[] start, int[] destination){

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()){

            int[] pos = queue.poll();

            if(pos[0] == destination[0] && pos[1] == destination[1] ){
                return true;
            }

            for(int[] dir : dirs ){

                int x = pos[0];
                int y = pos[1];

                while(x >= 0 && x < m &&  y >=0 && y < n && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }

                if(!visited[x-dir[0]][y-dir[1]]){
                    queue.add(new int[] {x-dir[0],y-dir[1]});
                    visited[x-dir[0]][y-dir[1]] = true;
                }
            }
        }
        return false;
    }

    private boolean hasPathDFS(int[][] maze,boolean[][] visited, int[] start, int[] destination){

        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }

        visited[start[0]][start[1]] = true;
        boolean result = false;

        for(int[] dir : dirs ){

            int x = start[0];
            int y = start[1];

            while(x >= 0 && x < maze.length &&  y >=0 && y < maze[0].length && maze[x][y] == 0){
                x += dir[0];
                y += dir[1];
            }

            if(!visited[x-dir[0]][y-dir[1]]){
                result = result || hasPathDFS(maze,visited,new int[]{x-dir[0],y-dir[1]},destination);
            }
        }
        return result;
    }

}