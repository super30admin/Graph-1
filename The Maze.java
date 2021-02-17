/*
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze is None or len(maze) == 0:
            return False
        
        rows, cols = len(maze), len(maze[0])
        queue = collections.deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        
        while len(queue) > 0:
            node = queue.popleft()
            
            if node[0] == destination[0] and node[1] == destination[1]:
                return True
            
            for d in dirs:
                i = node[0]
                j = node[1]
                while i >= 0 and i < rows and j >= 0 and j < cols and (maze[i][j] == 0 or maze[i][j] == 2):
                    i= i + d[0]
                    j = j + d[1]
                
                # bring one position back
                i -= d[0]
                j -= d[1]
                
                if maze[i][j] != 2:
                    queue.append([i,j])
                    maze[i][j] = 2
                    
        return False
*/

/*
dfs
class Solution {
    int m = 0;
    int n  = 0;

    int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if(maze == null || maze.length == 0) return false;

        m = maze.length;
        n = maze[0].length;

        return dfs(maze,start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        // Base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        maze[start[0]][start[1]] = 2;
        // Logic
        for(int [] dir : dirs){
            int r = start[0];
            int c = start[1];

            while(r >= 0 && r < m && c>= 0 && c<n && (maze[r][c] == 0 || maze[r][c] == 2)){
                r += dir[0];
                c += dir[1];

            }
            // Bring it back to stopping point
            r -= dir[0];
            c -= dir[1];

            if(maze[r][c] != 2 && dfs(maze, new int [] {r,c}, destination)) 
                return true;

        }
        return false;
    }
}
*/

// time - O(rows*cols)
// space - O(rows*cols)
// logic - normal bfs only this time we keep on going until hit a wall
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        
        
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!q.isEmpty()){
            int[] node = q.poll();
            
            if (node[0] == destination[0] && node[1] == destination[1])
                return true;
            
            for (int[] d:dirs){
                int i = node[0];
                int j = node[1];
                
                // keep rolling until hit a wall and also if we had already visited that position keep rolling it as it is not a wall
                while (i >= 0 && i < rows && j >= 0 && j < cols && (maze[i][j] == 0 || maze[i][j] == 2)){
                    i = i + d[0];
                    j = j + d[1];
                }
                // bring one position back
                i -= d[0];
                j -= d[1];
                
                if (maze[i][j] != 2){
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}