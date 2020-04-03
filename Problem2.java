// Time complexity - O(mn)
// Space - O(mn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        int i = start[0];
        int j = start[1];
        
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] popped = queue.poll();
            if(popped[0] == destination[0] && popped[1] == destination[1]) return true;
            for(int[] dir: dirs){
                int r = popped[0] + dir[0];
                int c = popped[1] + dir[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                if(!visited[r - dir[0]][c - dir[1]])
                    queue.add(new int[]{r - dir[0], c - dir[1]});
                visited[r - dir[0]][c - dir[1]] = true; 
            }
        }
        
        return false;
    }
}