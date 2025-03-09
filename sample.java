class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degrees = new int [n];
        for (int[] t:trust) {
            degrees[t[0]-1]--;
            degrees[t[1]-1]++;
        }

        for (int i=0;i<n;i++) {
            if(degrees[i] == n-1) {
                return i+1;
            }
        }
        return -1;
    }
}


class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q= new LinkedList<>();
        int[][] dirs = new int[][] {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        maze[start[0]][start[1]] = 2;
        q.add(new int[] {start[0], start[1]});
        int m = maze.length;
        int n = maze[0].length;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            if (point[0] == destination[0] && point[1] == destination[1]) {
                return true;
            }
            for (int[] dir :dirs) {
                int nr = point[0] + dir[0];
                int nc = point[1] + dir[1];
                while (nr >=0 && nr < m && nc >=0 && nc < n && maze[nr][nc] != 1) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0];
                nc = nc - dir[1];
                if (maze[nr][nc] != 2) {
                    q.add(new int []{nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
        
    }
} 
