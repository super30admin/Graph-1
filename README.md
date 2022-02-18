# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)
class Solution {
    //time complexity: O(V+E), V = vertices , E = edges 
    //space complexity: O(N) , n=N
    public int findJudge(int n, int[][] trust) {
        int indegrees[] = new int[n+1];
        
        for(int[] relation: trust)
        {
            indegrees[relation[1]]++;
            indegrees[relation[0]]--;
        }
        
        for(int i=1; i<=n; i++)
        {
            if(indegrees[i] == n-1 )
                return i;
        }
        
        return -1;
    }
}

## Problem2 The Maze (https://leetcode.com/problems/the-maze/)
//BFS
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //null check 
        if(maze == null || maze.length == 0) return false;
        int dirs[][]={{-1,0}, {0,1}, {1,0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int m = maze.length;
        int n = maze[0].length;
        
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for(int dir[]: dirs)
            {
                int nr = row + dir[0];
                int nc = col + dir[1];
                while(nr>=0 && nr<= m-1 && nc>=0 && nc<= n-1 && maze[nr][nc] != 1)
                {
                    nr+= dir[0];
                    nc+= dir[1];
                }
                
                //step back from the hurdle
                nr  -= dir[0];
                nc -= dir[1];
                
                
                if(nr == destination[0] && nc == destination[1])
                {
                    return true;
                }
                
                if(maze[nr][nc] != 2) {
                    maze[nr][nc] =2;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        return false;
        
    }
}

//DFS
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //null check 
        if(maze == null || maze.length == 0) return false;
        int dirs[][]={{-1,0}, {0,1}, {1,0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int m = maze.length;
        int n = maze[0].length;
        boolean result = dfs(maze, start, destination);
        return result;
    }
    
    private boolean dfs(int[][] maze, int start[], int destination[])
    {
        int row = start[0];
        int col = start[1];

        if(row == destination[0] && col == destination[1]) return true;
        
        int dirs[][]={{-1,0}, {0,1}, {1,0}, {0, -1}};
        
        for(int dir[] : dirs)
        {
            int nr = row + dir[0];
            int nc = col + dir[1];
            
            while(nr >=0 && nr < maze.length && nc>= 0 && nc < maze[0].length &&  maze[nr][nc] != 1)
            {
                nr += dir[0];
                nc += dir[1];
            }
            
            //step back from the hurdle
            nr -= dir[0];
            nc -= dir[1];
            
            //mark visited 
            if(maze[nr][nc]!= 2)
            {
                maze[nr][nc]= 2;
                boolean ans = dfs(maze, new int[]{nr, nc}, destination);
                if (ans) return ans;
            }
        }
       return false;
        
    }
}