
public boolean hasPath(int [][] maze, int [] start, int [] destination){
    if(maze == null || maze.length == 0 || maze[0].length ==0 ) return false;
    int m = maze.length;
    int n = maze[0].length;
    Queue<int []> q = new LinkedList<>();
    q.add(new int {start[0],start[1]});
    maze[start[0]][start[1]] = 2;
    int [][] dirs = new int{{0, -1},{0, 1},{1, 0},{-1, 0}};
    while(!q.isEmpty()){
        int [] curr = q.poll();
        for(int [] d: dirs){
            int r = curr[0];
            int c = curr[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != '1'){
                r = r + d[0];
                c = c + d[1];
            }
            r = r - d[0];
            c = c - d[1];
            if(r == destination[0] && c == destination [1]){
                return true;
            }
            if(maze[i][j] != '2'){
                q.add(new int {r, c});
                maze[r][c] = 2;
            }
        }
    }
    return false;
}
}

Time Complexity = O(mn)
Space Complexity = O(queue)
