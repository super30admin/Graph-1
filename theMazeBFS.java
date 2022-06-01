//sc and tc: o(m * n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;

        //Breadth-First-search

        Queue<int[]> q = new LinkedList<>(); // I could also use two Queues for row and column separately also
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up Down Left Right

        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir : dirs) {
                int r = cur[0];
                int c = cur[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r = r + dir[0];
                    c = c + dir[1];
                }
                r = r - dir[0];
                c = c - dir[1];
                if(maze[r][c] != 2) {
                    if(r == destination[0] && c == destination[1]) {
                        return true;
                    }
                    maze[r][c] = 2;
                    q.add(new int[] {r, c});
                }
            }
        }
            return false;
    }
}