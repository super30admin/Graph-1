// Time Complexity:  Amortized: O(mn) 
//  Space Complexity: O(mn) worst case
//  BFS Approach
class Solution {

    int m, n;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        this.n = maze[0].length;

        dirs = new int[][]{{0, -1}, {0,1}, {-1,0}, {1,0}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;

        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            for(int dir[]:dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    queue.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}


// Time Complexity:  Amortized: O(mn) 
//  Space Complexity: O(mn) worst case
//  DFS Approach
class Solution {
    int m, n;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        this.m = maze.length;
        this.n = maze[0].length;

        dirs = new int[][]{{0, -1}, {0,1}, {-1,0}, {1,0}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        return dfs(maze, start, destination);
    }

    private boolean dfs(int maze[][], int curr[], int destination[]){
        // base
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
        if(maze[curr[0]][curr[1]] == 2) return false;

        // logic
        maze[curr[0]][curr[1]] = 2;
        for(int dir[]: dirs){
            int r = curr[0] + dir[0];
            int c = curr[1] + dir[1];

            while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];
            if(dfs(maze, new int[]{r,c}, destination)) return true;
        }
        return false;
    }
}