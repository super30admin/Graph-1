import java.util.LinkedList;
import java.util.Queue;

class mazeMatrix{
    public boolean isWay(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        q.add(new int[] {start[0], start[1]});
        maze[start[0]] [start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r = r + dir[0];
                    c = c + dir[1];
                }
                r = r - dir[0];
                c = c - dir[1];
                if(maze[r][c] != 2){
                    if(r == destination[0] && c == destination[1]){
                        return true;
                    }
                    maze[r][c] = 2;
                    q.add(new int[] {r,c});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        mazeMatrix m = new mazeMatrix();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};
        System.out.print(m.isWay(maze, start, destination));
    }
}

//time complexity O(m * n)
//space complexity O(m * n)
// where m is raw of maze and n is coloum of maze