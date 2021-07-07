# Time complexity:O(V+E)
# Space complexity: 0(V)
# Did code run successfully on leetcode: yes
# Any problem you faced: No








public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */



        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;


        while(!queue.isEmpty()){
            Point current = queue.poll();
            if(current.x == destination[0] && current.y == destination[1]){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int x = current.x + dx[i];
                int y = current.y + dy[i];


            while(isValid(maze, x, y) && maze[x][y] != 1){
                x += dx[i];
                y += dy[i];

            }

            x -= dx[i];
            y -= dy[i];

            if(!visited[x][y]){
                visited[x][y] = true;

                queue.add(new Point(x,y));
            }
            }



        }

        return false;

    }
    // return false;



    private boolean isValid(int[][] maze, int x, int y){
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length;
    }

}
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


